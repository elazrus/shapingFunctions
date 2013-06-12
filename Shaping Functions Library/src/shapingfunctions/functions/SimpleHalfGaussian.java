package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class SimpleHalfGaussian extends Function {

	public SimpleHalfGaussian(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Gaussian_function
		
		float sigma = 0.25f; // produces results < 0.001 at f(0);
		float y = PApplet.exp(0.0f - (PApplet.sq(x-1.0f) / (2.0f*sigma*sigma)));
		
		return clamp(y, clamp);
	}

}
