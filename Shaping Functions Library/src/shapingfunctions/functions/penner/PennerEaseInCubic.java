package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInCubic extends Function {

	public PennerEaseInCubic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = x*x*x;

		return clamp(y, clamp);
	}
}
