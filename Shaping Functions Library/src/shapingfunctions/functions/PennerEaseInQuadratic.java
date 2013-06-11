package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInQuadratic extends Function {
	
	public PennerEaseInQuadratic(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = x*x;
		
		return clamp(y, clamp);
	}
}
