package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseOutSine extends Function {

	public PennerEaseOutSine(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = PApplet.sin(x * (PConstants.PI/2));
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
