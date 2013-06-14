package shapingfunctions.functions.error;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class NormalizedInverseErf extends Function {

	public NormalizedInverseErf() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Error_function
		// Note that this implementation is a shifted, scaled and normalized error function!
		
		float erfBound = 2.0f;
		float erfBoundNorm = 0.99532226501f; // this = erf(2.0f), i.e., erf(erfBound)
		float z = PApplet.map(x, 0, 1, -erfBoundNorm, erfBoundNorm);
		float z2 = z*z;
		float a = (8.0f*(PConstants.PI-3.0f)) / ((3.0f*PConstants.PI)*(4.0f*PConstants.PI));
		
		float A = (2.0f / (PConstants.PI*a)) + (PApplet.log(1.0f-z2) / 2.0f);
		float B = (PApplet.log(1.0f-z2) / a);
		float y = PApplet.sqrt(PApplet.sqrt(A*A - B) - A);
		
		if (z < 0.0f) y = -y;
		y /= erfBound;
		y = y + 1.0f;
		y /= 2.0f;
		
		y = PApplet.constrain(y, 0, 1); // necessary
		
		return clamp(y, clamp);
	}

}
