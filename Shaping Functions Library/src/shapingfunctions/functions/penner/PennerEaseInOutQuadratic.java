package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInOutQuadratic extends Function {

	public PennerEaseInOutQuadratic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = ((x /= 1.0f / 2f) < 1f) ? (1.0f / 2f * x * x)
				: (-1.0f / 2f * ((--x) * (x - 2) - 1));

		return clamp(y, clamp);
	}
}
