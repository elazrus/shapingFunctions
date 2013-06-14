package shapingfunctions.functions.circular;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class CircularEaseOut extends Function {

	public CircularEaseOut() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = PApplet.sqrt(1.0f - PApplet.sq(1.0f - x));
		
		return clamp(y, clamp);
	}

}
