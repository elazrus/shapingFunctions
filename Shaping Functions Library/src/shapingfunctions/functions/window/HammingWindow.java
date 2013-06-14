package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class HammingWindow extends Function {

	public HammingWindow(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		float y = 0.54f - 0.46f*PApplet.cos(PConstants.TWO_PI*x);
		
		return clamp(y, clamp);
	}

}
