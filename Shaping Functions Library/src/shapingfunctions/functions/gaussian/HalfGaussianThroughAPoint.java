package shapingfunctions.functions.gaussian;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class HalfGaussianThroughAPoint extends Function {
	private float a, b;
	
	public HalfGaussianThroughAPoint() {
		super();
			
		this.a = this.b = 0;
	}
	
	public HalfGaussianThroughAPoint(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Gaussian_function
		// http://en.wikipedia.org/wiki/Full_width_at_half_maximum
		
		float fb = PApplet.max(0.0000001f, b);
		float denom = PApplet.sqrt(2.0f*PApplet.log(1.0f/fb));
		float sigma = (1.0f-a) / denom;
		
		// 68.26894921371
		float y = PApplet.exp(0.0f - (PApplet.sq(x-1.0f) / (2.0f*sigma*sigma)));
		
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
