package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseOutCubic extends Function {

	public PennerEaseOutCubic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		x = x-1.0f;
		float y = x*x*x + 1.0f;
		
		return clamp(y, clamp);
	}
}
