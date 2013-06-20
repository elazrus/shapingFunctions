package shapingfunctions.functioncontainers;

import shapingfunctions.functions.interpolation.*;
import shapingfunctions.library.FunctionContainer;

public class InterpolationFunctionContainer extends FunctionContainer {

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
