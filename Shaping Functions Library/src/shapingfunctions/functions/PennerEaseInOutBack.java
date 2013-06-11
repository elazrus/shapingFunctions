package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInOutBack extends Function {

	public PennerEaseInOutBack(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float s = (1.70158f * 1.525f);
		x /= 0.5f;
		
		float y = 0;
		if (x < 1) {
			y = 1.0f/2.0f * (x*x*((s+1.0f)*x - s));
		}
		else {
			x -= 2.0;
			y = 1.0f/2.0f * (x*x*((s+1.0f)*x + s) + 2.0f);
		}

		return clamp(y, clamp);
	}
}
