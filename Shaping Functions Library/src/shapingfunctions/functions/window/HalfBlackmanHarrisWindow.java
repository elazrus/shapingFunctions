package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HalfBlackmanHarrisWindow extends Function {

	public HalfBlackmanHarrisWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function
		
		final float a0 = 0.35875f;
		final float a1 = 0.48829f;
		final float a2 = 0.14128f;
		final float a3 = 0.01168f;
		
		x *= 0.5f;
		float pix = PConstants.PI*x;
		float y = a0 - a1*PApplet.cos(2*pix) + a2*PApplet.cos(4*pix) - a3*PApplet.cos(6*pix);
		
		return clamp(y, clamp);
	}

}
