package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseInElastic extends Function {

	public PennerEaseInElastic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		if (((Float)x).equals(0)) return 0;
		if (((Float)x).equals(1)) return 1;
		
		float p = 0.3f;
		float s = p/4.0f;
		float postFix = PApplet.pow(2, 10 * (x-=1));
		float y = -(postFix * PApplet.sin((x-s) * (2*PConstants.PI) / p));

		return clamp(y, clamp);
	}
}
