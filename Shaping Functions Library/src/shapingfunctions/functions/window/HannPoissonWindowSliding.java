package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HannPoissonWindowSliding extends Function {
	private float a, b;
	
	public HannPoissonWindowSliding() {
		this(0, 0);
	}
	
	public HannPoissonWindowSliding(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		float epsilon = 0.00001f;
		float tau = 25.0f * PApplet.max(b*b*b*b, epsilon); // nice range of control
		
		float newx = PApplet.constrain(x + (0.5f -a), 0, 1);
		float hy = 0.5f * (1.0f - PApplet.cos(PConstants.TWO_PI*newx));
		float py = PApplet.exp(0.0f - (PApplet.abs(newx - 0.5f))*(1.0f/tau));
		float y = hy*py;
		
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
