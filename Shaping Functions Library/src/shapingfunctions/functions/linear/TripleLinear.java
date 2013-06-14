package shapingfunctions.functions.linear;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class TripleLinear extends Function {
	private float a, b, c, d;
	
	public TripleLinear() {
		super();

		this.a = this.b = this.c = this.d = 0;
	}
	
	public TripleLinear(float a, float b, float c, float d) {
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
				y = PApplet.map(x, 0, a, 0, b);
			}
			else if (Float.compare(x, c) >= 0) {
				y = PApplet.map(x, c, 1, d, 1);
			}
			else {
				y = PApplet.map(x, a, c, b, d);
			}
		}
		else {
			if (Float.compare(x, c) <= 0) {
				y = PApplet.map(x, 0, c, 0, d);
			}
			else if (Float.compare(x, a) >= 0) {
				y = PApplet.map(x, a, 1, b, 1);
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
