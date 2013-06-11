package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInCubic extends Function {

	public PennerEaseInCubic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = x*x*x;

		return clamp(y, clamp);
	}
}
