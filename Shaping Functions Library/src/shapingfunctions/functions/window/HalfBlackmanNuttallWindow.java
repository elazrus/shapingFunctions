package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HalfBlackmanNuttallWindow extends Function {

	public HalfBlackmanNuttallWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function
		
		final float a0 = 0.3635819f;
		final float a1 = 0.4891775f;
		final float a2 = 0.1365995f;
		final float a3 = 0.0106411f;
		
		x *= 0.5f;
		float pix = PConstants.PI*x;
		float y = a0 - a1*PApplet.cos(2*pix) + a2*PApplet.cos(4*pix) - a3*PApplet.cos(6*pix);
		
		return clamp(y, clamp);
	}

}
