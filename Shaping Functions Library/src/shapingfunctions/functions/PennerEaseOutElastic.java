package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseOutElastic extends Function {

	public PennerEaseOutElastic(PApplet applet) {
		super(applet);
	}

	public float applyFunction(float x, boolean clamp) {
		if (((Float)x).equals(0)) return 0;
		if (((Float)x).equals(1)) return 1;
		
		float p = 0.3f;
		float s = p/4.0f;
		float y = PApplet.pow(2, -10*x) * PApplet.sin((x-s)*(2/PConstants.PI)/p) + 1.0f;
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
