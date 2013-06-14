package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class FastSquareRoot extends Function {

	public FastSquareRoot(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Fast_inverse_square_root
		// http://stackoverflow.com/questions/11513344/how-to-implement-the-fast-inverse-square-root-in-java
		
		float xhalf = 0.5f * x;
		int i = Float.floatToIntBits(x);
		i = 0x5f3759df - (i >> 1);
		x = Float.intBitsToFloat(i);
		x = x * (1.5f - xhalf*x*x);
		float y = 1.0f/x;
		
		return clamp(y, clamp);
	}

}
