package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInQuartic extends Function {

	public PennerEaseInQuartic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = x*x*x*x;
		
		return clamp(y, clamp);
	}
}
