package shapingfunctions.functions.cosine;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class BlinnWyvillCosineApproximation extends Function {

	public BlinnWyvillCosineApproximation(PApplet applet) {
		super(applet);
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float x2 = x*x;
		float x4 = x2*x2;
		float x6 = x4*x2;
		float fa = 4.0f/9.0f;
		float fb = 17.0f/9.0f;
		float fc = 22.0f/9.0f;
		float y = fa*x6 - fb*x4 + fc*x2;
		
		return clamp(y, clamp);
	}

}
