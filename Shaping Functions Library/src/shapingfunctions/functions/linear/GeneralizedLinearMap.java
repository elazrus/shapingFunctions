package shapingfunctions.functions.linear;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class GeneralizedLinearMap extends Function {
	private float a, b, c, d;
	
	public GeneralizedLinearMap() {
		super();
		
		this.a = this.b = this.c = this.d = 0;
	}
	
	public GeneralizedLinearMap(float a, float b, float c, float d) {
		super();
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		if (a < c) {
			if (Float.compare(x, a) <= 0) {
				y = b;
			}
			else if (Float.compare(x, c) >= 0) {
				y = d;
			}
			else {
				y = PApplet.map(x, a, c, b, d);
			}
		}
		else {
			if (Float.compare(x, c) <= 0) {
				y = d;
			}
			else if (Float.compare(x, a) >= 0) {
				y = b;
			}
			else {
				y = PApplet.map(x, c, a, d, b);
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

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}
}
