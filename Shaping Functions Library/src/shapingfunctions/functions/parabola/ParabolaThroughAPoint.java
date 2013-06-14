package shapingfunctions.functions.parabola;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class ParabolaThroughAPoint extends Function {
	private float a, b;
	
	public ParabolaThroughAPoint(PApplet applet) {
		super(applet);
			
		this.a = this.b = 0;
	}
	
	public ParabolaThroughAPoint(PApplet applet, float a, float b) {
		super(applet);
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// Parabola (Quadratic) Through a Point
		
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f;
		float max_param_b = 1.0f;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		
		float A = (1-fb)/(1-fa) - (fb/fa);
		float B = (A*(fa*fa) - fb) / fa;
		float y = A*(x*x) - B*x;
		y = PApplet.constrain(y, 0, 1);
		
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

}
