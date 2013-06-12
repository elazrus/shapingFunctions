package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HannWindow extends Function {

	public HannWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		float y = 0.5f * (1.0f - PApplet.cos(PConstants.TWO_PI*x));
		
		return clamp(y, clamp);
	}

}
