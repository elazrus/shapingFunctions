package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInOutCubic extends Function {

	public PennerEaseInOutCubic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		x *= 2.0f;
		float y = 0;
		
		if (x < 1) {
			y = 0.5f * x*x*x;
		}
		else {
			x -= 2.0f;
			y = 0.5f * (x*x*x + 2.0f);
		}
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
