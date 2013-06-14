package shapingfunctions.functions.sigmoid;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DoubleQuadraticSigmoid extends Function {

	public DoubleQuadraticSigmoid() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		if (Float.compare(x, 0.5f) <= 0) {
			y = PApplet.sq(2.0f*x) / 2.0f;
		}
		else {
			y = 1.0f - PApplet.sq(2.0f*(x-1.0f)) / 2.0f;
		}
		
		return clamp(y, clamp);
	}

}
