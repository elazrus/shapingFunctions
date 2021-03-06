package shapingfunctions.functions.linear;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class DoubleLinear extends Function {
	private float a, b;
	
	public DoubleLinear() {
		this(0, 0);
	}
	
	public DoubleLinear(float a, float b) {
		super();
		
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
		if (Float.compare(x, fa) <= 0) {
			y = (fb/fa) * x;
		}
		else {
			y = fb + ((1.0f-fb) / (1.0f-fa)) * (x-fa);
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
