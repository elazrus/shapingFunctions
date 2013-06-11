package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInOutExpo extends Function {

	public PennerEaseInOutExpo(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		if (((Float) x).equals(0)) return 0;
		if (((Float) x).equals(1)) return 1;

		float y = ((x /= 1.0f / 2.0f) < 1) ? (1.0f / 2.0f * PApplet.pow(2, 10 * (x - 1))) 
				: (1.0f / 2.0f * (-PApplet.pow(2, -10 * --x) + 2));

		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}

		return y;
	}
}
