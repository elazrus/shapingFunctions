package shapingfunctions.functions.penner;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseOutSine extends Function {

	public PennerEaseOutSine(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = PApplet.sin(x * (PConstants.PI/2));
		
		return clamp(y, clamp);
	}
}
