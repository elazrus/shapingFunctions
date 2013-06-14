package shapingfunctions.functions.exponent;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class ExponentialEmphasis extends Function {
	private float a;
	
	public ExponentialEmphasis(PApplet applet) {
		super(applet);
			
		this.a = 0;
	}
	
	public ExponentialEmphasis(PApplet applet, float a) {
		super(applet);
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		
		float y;
		if (fa < 0.5f) {
			// emphasis
			fa = 2*fa;
			y = PApplet.pow(x, fa);
		}
		else {
			fa = 2*(fa-0.5f);
			y = PApplet.pow(x, 1.0f/(1.0f-fa));
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
