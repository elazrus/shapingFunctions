package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class FlatTopWindow extends Function {

	public FlatTopWindow() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		final float a0 = 1.000f;
		final float a1 = 1.930f;
		final float a2 = 1.290f;
		final float a3 = 0.388f;
		final float a4 = 0.032f;
		
		float pix = PConstants.PI*x;
		float y = a0 - a1*PApplet.cos(2*pix) + a2*PApplet.cos(4*pix) - a3*PApplet.cos(6*pix) + a4*PApplet.cos(8*pix);
		y /= (a0 + a1 + a2 + a3 + a4);
		
		return clamp(y, clamp);
	}

}
