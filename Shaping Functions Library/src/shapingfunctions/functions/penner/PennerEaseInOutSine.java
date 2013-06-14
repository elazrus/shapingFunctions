package shapingfunctions.functions.penner;

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
		
		return clamp(y, clamp);
	}
}
