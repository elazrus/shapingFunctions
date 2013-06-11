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
		
		return clamp(y, clamp);
	}
}
