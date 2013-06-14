package shapingfunctions.functions.penner;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class PennerEaseInSine extends Function {
	
	public PennerEaseInSine() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = -1.0f * PApplet.cos(x * (PConstants.PI/2)) + 1.0f;
		
		return clamp(y, clamp);
	}
}
