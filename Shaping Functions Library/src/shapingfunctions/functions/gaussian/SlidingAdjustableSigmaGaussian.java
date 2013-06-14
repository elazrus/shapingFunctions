package shapingfunctions.functions.gaussian;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class SlidingAdjustableSigmaGaussian extends Function {
	private float a, b;
	
	public SlidingAdjustableSigmaGaussian() {
		super();
			
		this.a = this.b = 0;
	}
	
	public SlidingAdjustableSigmaGaussian(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Gaussian_function
		
		x *= 2.0f;
		float sigma = b * 2.0f;
		float dx = 2.0f * (a - 0.5f);
		float y = PApplet.exp(0.0f - (PApplet.sq(x-1.0f-dx) / (2.0f*sigma*sigma)));
		
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
