package shapingfunctions.functions.gaussian;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class AdjustableFwhmHalfGaussian extends Function {
	private float a;
	
	public AdjustableFwhmHalfGaussian() {
		super();
			
		this.a = 0;
	}
	
	public AdjustableFwhmHalfGaussian(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Gaussian_function
		// http://en.wikipedia.org/wiki/Full_width_at_half_maximum
		
		float denom = PApplet.sqrt(2.0f * PApplet.log(2.0f));
		float sigma = (1.0f-a) / denom;
		
		//68.26894921371
		float y = PApplet.exp(0.0f - (PApplet.sq(x - 1.0f) / (2.0f*sigma*sigma)));
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
