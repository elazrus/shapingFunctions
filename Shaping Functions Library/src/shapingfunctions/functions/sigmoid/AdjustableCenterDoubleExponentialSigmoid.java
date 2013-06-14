package shapingfunctions.functions.sigmoid;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class AdjustableCenterDoubleExponentialSigmoid extends Function {
	private float a, b;
	
	public AdjustableCenterDoubleExponentialSigmoid() {
		super();

		this.a = this.b = 0;
	}
	
	public AdjustableCenterDoubleExponentialSigmoid(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		fa = 1.0f - fa;
		
		float y = 0;
		float w = PApplet.max(0, PApplet.min(1, x - (b-0.5f)));
		if (Float.compare(w, 0.5f) <= 0) {
			y = (PApplet.pow(2.0f*w, 1.0f/fa)) / 2.0f;
		}
		else {
			y = 1.0f - (PApplet.pow(2.0f*(1.0f-w), 1.0f/fa)) / 2.0f;
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
