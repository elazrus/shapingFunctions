package shapingfunctions.functions.bezier;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class CubicBezier extends Function {
	private float a, b, c, d;
	
	public CubicBezier() {
		super();
			
		this.a = this.b = this.c = this.d = 0;
	}
	
	public CubicBezier(float a, float b, float c, float d) {
		super();
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	private float slopeFromT(float t, float A, float B, float C) {
		float dtdx = 1.0f / (3.0f*A*t*t + 2.0f*B*t + C);
		return dtdx;
	}
	
	private float xFromT(float t, float A, float B, float C, float D) {
		float x = A*(t*t*t) + B*(t*t) + C*t + D;
		return x;
	}
	
	private float yFromT(float t, float E, float F, float G, float H) {
		float y = E*(t*t*t) + F*(t*t) + G*t + H;
		return y;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// Bezier Shapers
		// adapted from BEZMATH.PS (1993)
		// by Don Lancaster, SYNERGETICS Inc. 
		// http://www.tinaja.com/text/bezmath.html
		
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f;
		float max_param_b = 1.0f;
		float min_param_c = 0.0f + PConstants.EPSILON;
		float max_param_c = 1.0f - PConstants.EPSILON;
		float min_param_d = 0.0f;
		float max_param_d = 1.0f;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		float fc = PApplet.constrain(c, min_param_c, max_param_c);
		float fd = PApplet.constrain(d, min_param_d, max_param_d);
		
		//---------------------------------
		float y0a = 0.00f; // initial y;
		float x0a = 0.00f; // initial x;
		float y1a = fb;    // 1st influence y
		float x1a = fa;    // 1st influence x
		float y2a = fd;    // 2nd influence y
		float x2a = fc;    // 2nd influence x
		float y3a = 1.00f; // final y
		float x3a = 1.00f; // final x
		
		float A = x3a - 3.0f*x2a + 3.0f*x1a - x0a;
		float B = 3.0f*x2a - 6.0f*x1a + 3.0f*x0a;
		float C = 3.0f*x1a - 3.0f*x0a;
		float D = x0a;
		
		float E = y3a - 3.0f*y2a + 3.0f*y1a - y0a;
		float F = 3.0f*y2a - 6.0f*y2a + 3.0f*y0a;
		float G = 3.0f*y1a - 3.0f*y0a;
		float H = y0a;
		
		// Solve for t given x (using Newton-Raphelson), then solve for y given t.
		// Assume for the first guess that t = x.
		float currentt = x;
		int nRefinementIterations = 5;
		for (int i=0; i < nRefinementIterations; i++) {
			float currentx = xFromT(currentt, A, B, C, D);
			float currentslope = slopeFromT(currentt, A, B, C);
			currentt -= (currentx - x)*(currentslope);
			currentt = PApplet.constrain(currentt, 0, 1);
		}
		
		//--------------
		float y = yFromT(currentt, E, F, G, H);
		
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
