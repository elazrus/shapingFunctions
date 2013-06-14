package shapingfunctions.functions.bezier;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class QuadraticBezier extends Function {
	private float a, b;
	
	public QuadraticBezier(PApplet applet) {
		super(applet);
			
		this.a = this.b = 0;
	}
	
	public QuadraticBezier(PApplet applet, float a, float b) {
		super(applet);
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// Bezier Shapers
		// adapted from BEZMATH.PS (1993)
		// by Don Lancaster, SYNERGETICS Inc. 
		// http://www.tinaja.com/text/bezmath.html
		
		float min_param_a = 0.0f;
		float max_param_a = 1.0f;
		float min_param_b = 0.0f;
		float max_param_b = 1.0f;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		
		if (Float.compare(fa, 0.5f) == 0) {
			fa += PConstants.EPSILON;
		}
		
		// solve t from x (an inverse operation);
		float om2a = 1.0f - 2.0f*fa;
		float t = (PApplet.sqrt(fa*fa + om2a*x) - fa) / om2a;
		float y = (1.0f - 2.0f*fb)*(t*t) + (2*fb)*t;
		
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
