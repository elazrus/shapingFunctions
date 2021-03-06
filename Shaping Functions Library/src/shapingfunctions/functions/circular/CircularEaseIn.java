package shapingfunctions.functions.circular;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class CircularEaseIn extends Function {

	public CircularEaseIn() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 1.0f - PApplet.sqrt(1.0f - x*x);
		
		return clamp(y, clamp);
	}

}
