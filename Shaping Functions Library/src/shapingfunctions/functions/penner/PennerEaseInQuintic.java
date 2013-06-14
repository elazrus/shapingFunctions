package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInQuintic extends Function {

	public PennerEaseInQuintic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = x*x*x*x*x;
		
		return clamp(y, clamp);
	}
}
