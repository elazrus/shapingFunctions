package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInBounce extends Function {

	public PennerEaseInBounce() {
		super();
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		PennerEaseOutBounce pennerEaseOutBounce = new PennerEaseOutBounce();
		float y = 1.0f - pennerEaseOutBounce.applyFunction(1.0f - x);
		
		return clamp(y, clamp);
	}
}
