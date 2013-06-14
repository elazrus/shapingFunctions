package shapingfunctions.functioncontainers;

import shapingfunctions.functions.interpolation.*;

public class InterpolationFunctionContainer {

	// Catmull Rom Interpolate
	public float function_catmullRomInterpolate(float x, float a, float b, boolean clamp) {
		CatmullRomInterpolate catmullRomInterpolate = new CatmullRomInterpolate(a, b);
		return catmullRomInterpolate.applyFunction(x, clamp);
	}
	
	public float function_catmullRomInterpolate(float x, float a, float b) {
		CatmullRomInterpolate catmullRomInterpolate = new CatmullRomInterpolate(a, b);
		return catmullRomInterpolate.applyFunction(x);
	}
}
