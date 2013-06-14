package shapingfunctions.functions.step;

import shapingfunctions.library.Function;

public class SmoothStep extends Function {

	public SmoothStep() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Smoothstep
		
		float y = x*x*(3.0f - 2.0f*x);
		
		return clamp(y, clamp);
	}

}
