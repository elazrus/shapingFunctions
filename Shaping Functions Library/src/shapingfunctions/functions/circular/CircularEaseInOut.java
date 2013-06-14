package shapingfunctions.functions.circular;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class CircularEaseInOut extends Function {

	public CircularEaseInOut(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		x *= 2.0f;
		
		if (x < 1) {
			y = -0.5f * (PApplet.sqrt(1.0f - x*x) - 1.0f);
		}
		else {
			x -= 2.0f;
			y = 0.5f * (PApplet.sqrt(1.0f - x*x) + 1.0f);
		}
		
		return clamp(y, clamp);
	}

}
