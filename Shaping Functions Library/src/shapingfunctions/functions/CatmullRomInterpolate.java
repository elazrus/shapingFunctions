package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class CatmullRomInterpolate extends Function {
	private float a, b;
	
	public CatmullRomInterpolate(PApplet applet) {
		super(applet);
			
		this.a = this.b = 0;
	}
	
	public CatmullRomInterpolate(PApplet applet, float a, float b) {
		super(applet);
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// from http://paulbourke.net/miscellaneous/interpolation/
		
		float y0 = a;
		float y3 = b;
		float x2 = x*x;
		
		float a0 = -0.5f*y0 + 0.5f*y3 - 1.5f;
		float a1 = y0 - 0.5f*y3 + 2.0f;
		float a2 = -0.5f*y0 + 0.5f;
		
		float y = a0*x*x2 + a1*x2 + a2*x;
		y = PApplet.constrain(y, 0.0f, 1.0f);
		
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
