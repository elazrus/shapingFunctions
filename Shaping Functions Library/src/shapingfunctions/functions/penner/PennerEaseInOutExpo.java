package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInOutExpo extends Function {

	public PennerEaseInOutExpo(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		if (Float.compare(x, 0.0f) == 0) return 0;
		if (Float.compare(x, 1.0f) == 0) return 1;

		float y = ((x /= 1.0f / 2.0f) < 1) ? (1.0f / 2.0f * PApplet.pow(2, 10 * (x - 1))) 
				: (1.0f / 2.0f * (-PApplet.pow(2, -10 * --x) + 2));

		return clamp(y, clamp);
	}
}
