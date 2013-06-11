package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseInOutSine extends Function {

	public PennerEaseInOutSine(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = -0.5f * (PApplet.cos(PConstants.PI*x) - 1.0f);
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
