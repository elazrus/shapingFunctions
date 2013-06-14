package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseOutExpo extends Function {

	public PennerEaseOutExpo() {
		super();
	}

	public float applyFunction(float x, boolean clamp) {
		float y = (Float.compare(x, 1.0f) == 0) ? 1.0f : (-PApplet.pow(2, -10*x) + 1.0f);
		
		return clamp(y, clamp);
	}
}
