package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInExpo extends Function {

	public PennerEaseInExpo() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = (Float.compare(x, 0.0f) == 0) ? 0 : (PApplet.pow(2, 10 * (x-1)));

		return clamp(y, clamp);
	}
}
