package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class Hermite2 extends Function {
	private float a, b, c, d;
	
	public Hermite2(PApplet applet) {
		super(applet);

		this.a = this.b = this.c = this.d = 0;
	}
	
	public Hermite2(PApplet applet, float a, float b, float c, float d) {
		super(applet);
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// from http://paulbourke.net/miscellaneous/interpolation/
		
		/*
		   Tension: 1 is high, 0 normal, -1 is low
		   Bias: 0 is even, positive is towards first segment, negative towards the other
		 */
		float tension = PApplet.map(c, 0, 1, -1, 1);
		float bias = PApplet.map(d, 0, 1, -1, 1);
		
		float y0 = 2.0f * (a- 0.5f); //? a
		float y1 = 0.0f;
		float y2 = 1.0f;
		float y3 = b;
		
		float x2 = x*x;
		float x3 = x2*x;
		
		float m0, m1;
		m0 = (y1-y0)*(1.0f+bias)*(1.0f-tension)/2.0f;
		m0 += (y2-y1)*(1.0f-bias)*(1.0f-tension)/2.0f;
		m1 = (y2-y1)*(1.0f+bias)*(1.0f-tension)/2.0f;
		m1 += (y3-y2)*(1.0f-bias)*(1.0f-tension)/2.0f;
		
		float a0 = 2.0f*x3 - 3.0f*x2 + 1.0f;
		float a1 = x3 - 2.0f*x2 + x;
		float a2 = x3 - x2;
		float a3 = -2.0f*x3 + 3.0f*x2;
		
		float y = (a0*y1 + a1*m0 + a2*m1 + a3*y2);
		
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
