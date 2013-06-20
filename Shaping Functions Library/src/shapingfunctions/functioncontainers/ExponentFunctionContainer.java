package shapingfunctions.functioncontainers;

import shapingfunctions.functions.exponent.*;
import shapingfunctions.library.FunctionContainer;

public class ExponentFunctionContainer extends FunctionContainer {

	// Exponential Emphasis
	public float function_exponentialEmphasis(float x, float a, boolean clamp) {
		ExponentialEmphasis exponentialEmphasis = new ExponentialEmphasis(a);
		return exponentialEmphasis.applyFunction(x, clamp);
	}
	
	public float function_exponentialEmphasis(float x, float a) {
		ExponentialEmphasis exponentialEmphasis = new ExponentialEmphasis(a);
		return exponentialEmphasis.applyFunction(x);
	}
}
