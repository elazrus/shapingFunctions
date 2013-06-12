package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class NuttallWindow extends Function {

	public NuttallWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		final float a0 = 0.355768f;
		final float a1 = 0.487396f;
		final float a2 = 0.144232f;
		final float a3 = 0.012604f;
		
		float pix = PConstants.PI*x;
		float y = a0 - a1*PApplet.cos(2*pix) + a2*PApplet.cos(4*pix) - a3*PApplet.cos(6*pix);
		
		return clamp(y, clamp);
	}

}
