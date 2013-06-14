package shapingfunctions.functions.step;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class SmootherStep extends Function {

	public SmootherStep(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Smoothstep
		
		float y = x*x*x*(x*(x*6.0f - 15.0f) + 10.0f);
		
		return clamp(y, clamp);
	}

}
