package shapingfunctions.functions.sinusoid;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DampedSinusoidReverse extends Function {
	private float a;
	
	public DampedSinusoidReverse() {
		super();
			
		this.a = 0;
	}
	
	public DampedSinusoidReverse(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Damped_sine_wave
		
		float omega = 100*a;
		float lambda = -6.90775527f; // ln(lambda) = 0.001
		float phi = 0;
		float e = 2.718281828459045f;
		
		float t = 1.0f-x;
		float y = PApplet.pow(e, lambda*t) * PApplet.cos(omega*t + phi);
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
