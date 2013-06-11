package shaperfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseOutExpo extends Function {

	public PennerEaseOutExpo(PApplet applet) {
		super(applet);
	}

	public float applyFunction(float x, boolean clamp) {
		float y = (((Float)x).equals(1)) ? 1.0f : (-PApplet.pow(2, -10*x) + 1.0f);
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
