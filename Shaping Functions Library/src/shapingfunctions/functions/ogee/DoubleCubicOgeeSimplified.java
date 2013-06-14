package shapingfunctions.functions.ogee;

import shapingfunctions.library.Function;

public class DoubleCubicOgeeSimplified extends Function {
	private float a, b;
	
	public DoubleCubicOgeeSimplified() {
		super();

		this.a = this.b = 0;
	}
	
	public DoubleCubicOgeeSimplified(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float fb = 1 - b;
		
		float y = 0;
		if (Float.compare(x, a) <= 0) {
			if (Float.compare(a, 0.0f) <= 0) {
				y = 0;
			}
			else {
				float val = 1 - x/a;
				y = fb*x + (1.0f-fb)*a*(1.0f-val*val*val);
			}
		}
		else {
			if (Float.compare(a, 1.0f) <= 0) {
				y = 1.0f;
			}
			else {
				float val = (x-a) / (1.0f-a);
				y = fb*x + (1.0f-b)*(a + (1.0f-a)*val*val*val);
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

}
