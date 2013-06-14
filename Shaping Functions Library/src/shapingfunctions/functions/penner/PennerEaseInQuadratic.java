package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInQuadratic extends Function {
	
	public PennerEaseInQuadratic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = x*x;
		
		return clamp(y, clamp);
	}
}
