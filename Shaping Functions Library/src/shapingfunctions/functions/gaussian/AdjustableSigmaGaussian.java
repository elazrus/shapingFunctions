package shapingfunctions.functions.gaussian;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class AdjustableSigmaGaussian extends Function {
	private float a;
	
	public AdjustableSigmaGaussian() {
		this(0);
	}
	
	public AdjustableSigmaGaussian(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Gaussian_function
		
		x *= 2.0f;
		float sigma = a*2.0f;
		float y = PApplet.exp(0.0f - (PApplet.sq(x-1.0f) / (2.0f*sigma*sigma)));
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
