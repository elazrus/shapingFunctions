package shapingfunctions.functions.penner;

import shapingfunctions.library.Function;

public class PennerEaseInOutQuartic extends Function {

	public PennerEaseInOutQuartic() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = ((x /= 1.0f / 2.0f) < 1) ? (1.0f / 2.0f * x * x * x * x)
				: (-1.0f / 2.0f * ((x -= 2.0f) * x * x * x - 2.0f));

		return clamp(y, clamp);
	}
}
