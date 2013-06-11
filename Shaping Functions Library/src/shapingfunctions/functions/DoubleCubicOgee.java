package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class DoubleCubicOgee extends Function {
	private float a, b;
	
	public DoubleCubicOgee(PApplet applet) {
		super(applet);

		this.a = this.b = 0;
	}
	
	public DoubleCubicOgee(PApplet applet, float a, float b) {
		super(applet);
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f;
		float max_param_b = 1.0f;
		
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		
		float y = 0;
		if (Float.compare(x, a) <= 0) {
			y = fb - fb*PApplet.pow(1.0f-x/fa, 3.0f);
		}
		else {
			y = fb + (1.0f-fb)*PApplet.pow((x-fa) / (1.0f-fa), 3.0f);
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

}
