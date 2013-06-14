package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DampedSinusoid extends Function {
	private float a;
	
	public DampedSinusoid(PApplet applet) {
		super(applet);
			
		this.a = 0;
	}
	
	public DampedSinusoid(PApplet applet, float a) {
		super(applet);
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Damped_sine_wave
		
		float omega = 100*a;
		float lambda = -6.90775527f; // ln(lambda) = 0.001 // decay constant
		float phi = 0;
		float e = 2.718281828459045f;
		
		float t = x;
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
