package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HalfExactBlackmanWindow extends Function {

	public HalfExactBlackmanWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function
		
		final float a0 = 7938.0f / 18608.0f;
		final float a1 = 9240.0f / 18608.0f;
		final float a2 = 1430.0f / 18608.0f;
		
		x *= 0.5f;
		float pix = PConstants.PI*x;
		float y = a0 - a1*PApplet.cos(2*pix) + a2*PApplet.cos(4*pix);
		
		return clamp(y, clamp);
	}

}
