package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseOutQuintic extends Function {

	public PennerEaseOutQuintic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		x = x-1;
		float y = x*x*x*x*x + 1.0f;
		
		return clamp(y, clamp);
	}
}
