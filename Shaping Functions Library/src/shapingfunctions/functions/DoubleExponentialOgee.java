package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class DoubleExponentialOgee extends Function {
	private float a;
	
	public DoubleExponentialOgee(PApplet applet) {
		super(applet);
			
		this.a = 0;
	}
	
	public DoubleExponentialOgee(PApplet applet, float a) {
		super(applet);
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		
		float y = 0;
		if (Float.compare(x, 0.5f) <= 0) {
			y = (PApplet.pow(2.0f*x, 1.0f-fa)) / 2.0f;
		}
		else {
			y = 1.0f - (PApplet.pow(2.0f*(1.0f-x), 1.0f-fa)) / 2.0f;
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
