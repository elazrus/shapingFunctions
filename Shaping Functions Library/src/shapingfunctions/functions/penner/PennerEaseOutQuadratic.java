package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseOutQuadratic extends Function {
	
	public PennerEaseOutQuadratic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = -1.0f * x * (x-2f);
		
		return clamp(y, clamp);
	}
}
