package shapingfunctions.functions.bezier;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class DoubleQuadraticBezier extends Function {
	private float a, b, c, d;
	
	public DoubleQuadraticBezier() {
		super();

		this.a = this.b = this.c = this.d = 0;
	}
	
	public DoubleQuadraticBezier(float a, float b, float c, float d) {
		super();
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// also see http://engineeringtraining.tpub.com/14069/css/14069_150.htm
		// produces mysterious values when a=0,b=1,c=0.667,d=0.417
	
		float xmid = (a+c) / 2.0f;
		float ymid = (b+d) / 2.0f;
		xmid = PApplet.constrain(xmid, PConstants.EPSILON, 1.0f-PConstants.EPSILON);
		ymid = PApplet.constrain(ymid, PConstants.EPSILON, 1.0f-PConstants.EPSILON);
		
		float y=0;
		float om2a;
		float t;
		float xx;
		float aa;
		float bb;
		
		if (Float.compare(x, xmid) <= 0) {
			xx = x / xmid;
			aa = a / xmid;
			bb = b / ymid;
			om2a = 1.0f - 2.0f*aa;
			if (Float.compare(om2a, 0.0f) == 0) {
				om2a = PConstants.EPSILON;
			}
			t = (PApplet.sqrt(aa*aa + om2a*xx) - aa) / om2a;
			y = (1.0f-2.0f*bb)*(t*t) + (2*bb)*t;
			y *= ymid;
		}
		else {
			xx = (x - xmid) / (1.0f - xmid);
			aa = (c - xmid) / (1.0f - xmid);
			bb = (d - ymid) / (1.0f - ymid);
			om2a = 1.0f - 2.0f*aa;
			if (Float.compare(om2a, 0.0f) == 0) {
				om2a = PConstants.EPSILON;
			}
			t = (PApplet.sqrt(aa*aa + om2a*xx) - aa) / om2a;
			y = (1.0f-2.0f*bb)*(t*t) + (2*bb)*t;
			y *= (1.0f - ymid);
			y += ymid;
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
