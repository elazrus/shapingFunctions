package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class LanczosSincWindow extends Function {

	public LanczosSincWindow() {
		super();
	}

	private float sinc(float x) {
		float pix = PConstants.PI * x;
		if (x == 0) {
			return 1.0f;
		} 
		else {
			return (PApplet.sin(pix) / pix);
		}
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function

		x *= 2.0f;
		float y = sinc(1.0f - x);

		return clamp(y, clamp);
	}

}
