package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInBack extends Function {
	public PennerEaseInBack() {
		super();
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		float s = 1.70158f;
		float y = x*x*((s+1.0f)*x - s);
		
		return clamp(y, clamp);
	}
}
