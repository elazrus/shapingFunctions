package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseIntOutQuintic extends Function {

	public PennerEaseIntOutQuintic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = ((x /= 1.0f / 2.0f) < 1) ? (1.0f / 2.0f * x * x * x * x * x)
				: (1.0f / 2.0f * ((x -= 2.0f) * x * x * x * x + 2.0f));

		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
