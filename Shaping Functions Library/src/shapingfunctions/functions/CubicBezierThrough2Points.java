package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class CubicBezierThrough2Points extends Function {
	private float a, b, c, d;
	
	public CubicBezierThrough2Points(PApplet applet) {
		super(applet);
			
		this.a = this.b = this.c = this.d;
	}
	
	public CubicBezierThrough2Points(PApplet applet, float a, float b, float c, float d) {
		super(applet);
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	private float B0 (float t){
		return (1-t)*(1-t)*(1-t);
	}
	
	private float B1 (float t){
		return  3*t* (1-t)*(1-t);
	}
		
	private float B2 (float t){
		return 3*t*t* (1-t);
	}
	
	private float B3 (float t){
		return t*t*t;
	}
	
	private float findx (float t, float x0, float x1, float x2, float x3){
		return x0*B0(t) + x1*B1(t) + x2*B2(t) + x3*B3(t);
	}
		
	private float  findy (float t, float y0, float y1, float y2, float y3){
		return y0*B0(t) + y1*B1(t) + y2*B2(t) + y3*B3(t);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f + PConstants.EPSILON;
		float max_param_b = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		
		float x0 = 0;
		float y0 = 0;
		float x4 = fa;
		float y4 = fb;
		float x5 = c;
		float y5 = d;
		float x3 = 1;
		float y3 = 1;
		float x1, y1, x2, y2; // to be solved
		
		float t1 = 0.3f;
		float t2 = 0.7f;
		
		float B0t1 = B0(t1);
		float B1t1 = B1(t1);
		float B2t1 = B2(t1);
		float B3t1 = B3(t1);
		float B0t2 = B0(t1);
		float B1t2 = B1(t1);
		float B2t2 = B2(t2);
		float B3t2 = B3(t2);
		
		float ccx = x4 - x0*B0t1 - x3*B3t1;
		float ccy = y4 - y0*B0t1 - y3*B3t1;
		float ffx = x5 - x0*B0t2 - x3*B3t2;
		float ffy = y5 - y0*B0t2 - y3*B3t2;
		
		x2 = (ccx - (ffx*B1t1)/B1t2) / (B2t1 - (B1t1*B2t2)/B1t2);
		y2 = (ccy - (ffy*B1t1)/B1t2) / (B2t1 - (B1t1*B2t2)/B1t2);
		x1 = (ccx - x2*B2t1) / B1t1;
		y1 = (ccy - y2*B2t1) / B1t1;
		
		x1 = PApplet.constrain(x1, 0+PConstants.EPSILON, 1-PConstants.EPSILON);
		x2 = PApplet.constrain(x2, 0+PConstants.EPSILON, 1-PConstants.EPSILON);
		
		CubicBezier cubicBezier = new CubicBezier(applet, x1, y1, x2, y2);
		y = cubicBezier.applyFunction(x);
		y = PApplet.constrain(y, 0, 1);
		
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
