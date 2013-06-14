package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseOutBounce extends Function {
	
	public PennerEaseOutBounce() {
		super();
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {	
		float postFix, y;
		
		if (x < (1.0f / 2.75f)) {
			y = 7.5625f * x*x;
		}
		else if (x < (2.0f / 2.75f)) {
			postFix = x -= (1.5f/2.75f);
			y = 7.5625f*postFix*x + 0.75f;
		}
		else if (x < (2.5f/2.75f)) {
			postFix = x -= (2.25f/2.75f);
			y = 7.5625f*postFix*x + 0.9375f;
		}
		else {
			postFix = x -= (2.625f/2.75f);
			y = 7.5625f*postFix*x + 0.984375f;
		}

		return clamp(y, clamp);
	}
}
