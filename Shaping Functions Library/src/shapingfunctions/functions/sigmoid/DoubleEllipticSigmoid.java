package shapingfunctions.functions.sigmoid;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DoubleEllipticSigmoid extends Function {
	private float a, b;
	
	public DoubleEllipticSigmoid() {
		super();

		this.a = this.b = 0;
	}
	
	public DoubleEllipticSigmoid(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		if (Float.compare(x, a) <= 0) {
			if (Float.compare(a, 0.0f) <= 0) {
				y = 0;
			}
			else {
				y = b * (1.0f - (PApplet.sqrt(PApplet.sq(a) - PApplet.sq(x)) / a));
			}
		}
		else {
			if (Float.compare(a, 1.0f) >= 0) {
				y = 1.0f;
			}
			else {
				y = b + ((1.0f-b) / (1.0f-a))*PApplet.sqrt(PApplet.sq(1.0f-a) - PApplet.sq(x-1.0f));
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
