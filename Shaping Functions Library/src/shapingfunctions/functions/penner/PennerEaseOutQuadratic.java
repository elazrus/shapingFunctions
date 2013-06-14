package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseOutQuadratic extends Function {
	
	public PennerEaseOutQuadratic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = -1.0f * x * (x-2f);
		
		return clamp(y, clamp);
	}
}
