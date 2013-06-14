package shapingfunctions.functions.window;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class BartlettWindow extends Function {

	public BartlettWindow() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function
		// Triangular window with zero-valued end-points:
		
		float y = 2.0f * (0.5f - PApplet.abs(x - 0.5f));
		
		return clamp(y, clamp);
	}

}
