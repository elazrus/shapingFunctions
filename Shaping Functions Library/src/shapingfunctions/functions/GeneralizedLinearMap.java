package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class GeneralizedLinearMap extends Function {
	private float a, b, c, d;
	
	public GeneralizedLinearMap(PApplet applet) {
		super(applet);
		
		this.a = this.b = this.c = this.d = 0;
	}
	
	public GeneralizedLinearMap(PApplet applet, float a, float b, float c, float d) {
		super(applet);
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		if (a < c) {
			if (x < a || ((Float)x).equals(a)) {
				y = b;
			}
			else if (x > c || ((Float)x).equals(c)) {
				y = d;
			}
			else {
				y = PApplet.map(x, a, c, b, d);
			}
		}
		else {
			if (x < c || ((Float)x).equals(c)) {
				y = d;
			}
			else if (x > a || ((Float)x).equals(a)) {
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
