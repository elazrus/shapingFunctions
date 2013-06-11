package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseOutBack extends Function {

	public PennerEaseOutBack(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float s = 1.70158f;
		x = (float) (x-1.0);
		float y = (float) (x*x*((s+1.0)*x + s) + 1.0);
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
