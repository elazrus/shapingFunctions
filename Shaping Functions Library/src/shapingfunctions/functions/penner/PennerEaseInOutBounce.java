package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInOutBounce extends Function {

	public PennerEaseInOutBounce() {
		super();
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		float y;
		
		if (x < 0.5f) {
			PennerEaseInBounce pennerEaseInBounce = new PennerEaseInBounce();
			y = pennerEaseInBounce.applyFunction(x*2) * 0.5f;
		}
		else {
			PennerEaseOutBounce pennerEaseOutBounce = new PennerEaseOutBounce();
			y = pennerEaseOutBounce.applyFunction(x*2-1) * 0.5f + 0.5f;
		}
		
		return clamp(y, clamp);
	}
}
