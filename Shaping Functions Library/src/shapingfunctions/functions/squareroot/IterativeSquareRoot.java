package shapingfunctions.functions.squareroot;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class IterativeSquareRoot extends Function {

	public IterativeSquareRoot(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Methods_of_computing_square_roots
		// Ancient Babylonian technology
		
		float y = 0.5f;
		int n = 6;
		for (int i=0; i < n; i++) {
			y = (y + x/y) / 2.0f;
		}
		
		return clamp(y, clamp);
	}

}
