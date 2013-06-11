package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInExpo extends Function {

	public PennerEaseInExpo(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = (((Float)x).equals(0)) ? 0 : (PApplet.pow(2, 10 * (x-1)));

		return clamp(y, clamp);
	}
}
