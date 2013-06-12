package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class NormalizedErf extends Function {

	public NormalizedErf(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Error_function
		// Note that this implementation is a shifted, scaled and normalized error function!
		
		float erfBound = 2.0f; // set bounds for artificial "normalization"
		float erfBoundNorm = 0.99532226501f; // this = erf(2.0f), i.e., erf(erfBound);
		float z = PApplet.map(x, 0, 1, 0-erfBound, erfBound);
		
		float z2 = z*z;
		float a = (8.0f*(PConstants.PI-3.0f)) / ((3*PConstants.PI)*(4.0f*PConstants.PI));
		float y = PApplet.sqrt(1.0f - PApplet.exp(0 - z2*((a*z2 + 4.0f/PConstants.PI) / (a*z2 + 1.0f))));
		if (z < 0.0f) y = 0-y;
		
		y /= erfBoundNorm;
		y = (y + 1.0f) / 2.0f;
		
		return clamp(y, clamp);
	}

}
