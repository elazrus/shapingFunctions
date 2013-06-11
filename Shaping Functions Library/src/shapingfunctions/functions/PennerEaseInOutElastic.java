package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseInOutElastic extends Function {

	public PennerEaseInOutElastic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		if (((Float) x).equals(0)) return 0;
		if (((Float) (x /= 0.5f)).equals(2)) return 1;

		float p = 0.3f * 1.5f;
		float s = p / 4.0f;

		float postFix = (x < 1) ? (PApplet.pow(2, 10 * (x -= 1)))
				: (PApplet.pow(2, -10 * (x -= 1)));
		float y = (x < 1) ? (-0.5f * (postFix * PApplet.sin((x - s) * (2 * PConstants.PI) / p))) 
				: (postFix * PApplet.sin((x - s) * (2 * PConstants.PI) / p) * 0.5f + 1.0f);
		
		return clamp(y, clamp);
	}
}
