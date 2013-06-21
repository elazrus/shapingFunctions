package shapingfunctions.functions.circular;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.FilletParameters;
import shapingfunctions.library.Function;

public class CircularFillet extends Function {
	private float a, b, c;
	private FilletParameters filletParameters;
	
	public CircularFillet() {
		this(0, 0, 0);
	}

	public CircularFillet(float a, float b, float c) {
		super();

		this.filletParameters = new FilletParameters();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// Joining Two Lines with a Circular Arc Fillet
		// Adapted from Robert D. Miller / Graphics Gems III.
		
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f + PConstants.EPSILON;
		float max_param_b = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);

		float R = c;
		filletParameters.computeFilletParameters(0, 0, fa, fb, fa, fb, 1, 1, R);
		
		float arcStartX = filletParameters.getArcStartX(); 
		float arcStartY = filletParameters.getArcStartY();
		float arcEndX = filletParameters.getArcEndX();
		float arcEndY = filletParameters.getArcEndY();
		float arcCenterX = filletParameters.getArcCenterX();
		float arcCenterY = filletParameters.getArcCenterY();
		float arcRadius = filletParameters.getArcRadius();
		
		float t = 0;
		float y = 0;
		x = PApplet.constrain(x, 0, 1);
		
		if (Float.compare(x, arcStartX) <= 0) {
			if (arcStartX < PConstants.EPSILON) {
				y = 0;
			}
			else {
				t = x / arcStartX;
				y = t * arcStartY;
			}
		}
		else if (Float.compare(x, arcEndX) >= 0) {
			t = (x - arcEndX) / (1.0f - arcEndX);
			y = arcEndY + t*(1.0f - arcEndY);
		}
		else {
			if (Float.compare(x, arcCenterX) >= 0) {
				y = arcCenterY - PApplet.sqrt(PApplet.sq(arcRadius) - PApplet.sq(x - arcCenterX));
			}
			else {
				y = arcCenterY + PApplet.sqrt(PApplet.sq(arcRadius) - PApplet.sq(x - arcCenterX));
			}
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}

}
