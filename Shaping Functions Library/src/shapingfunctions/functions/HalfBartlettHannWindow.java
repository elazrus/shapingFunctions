package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HalfBartlettHannWindow extends Function {

	public HalfBartlettHannWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function
		
		final float a0 = 0.62f;
		final float a1 = 0.48f;
		final float a2 = 0.38f;
		
		x *= 0.5f;
		float y = a0 - a1*PApplet.abs(x - 0.5f) - a2*PApplet.cos(2*PConstants.PI*x);
		
		return clamp(y, clamp);
	}

}
