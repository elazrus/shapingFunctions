package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseOutQuartic extends Function {

	public PennerEaseOutQuartic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = -1.0f * ((x=x-1.0f)*x*x*x - 1.0f);
		
		return clamp(y, clamp);
	}
}
