package shapingfunctions.functioncontainers;

import shapingfunctions.functions.error.*;
import shapingfunctions.library.FunctionContainer;

public class ErrorFunctionContainer extends FunctionContainer {

	// Normalized Erf
	public float function_normalizedErf(float x, boolean clamp) {
		NormalizedErf normalizedErf = new NormalizedErf();
		return normalizedErf.applyFunction(x, clamp);
	}
	
	public float function_normalizedErf(float x) {
		NormalizedErf normalizedErf = new NormalizedErf();
		return normalizedErf.applyFunction(x);
	}
	
	// Normalized Inverse Erf
	public float function_normalizedInverseErf(float x, boolean clamp) {
		NormalizedInverseErf normalizedInverseErf = new NormalizedInverseErf();
		return normalizedInverseErf.applyFunction(x, clamp);
	}
	
	public float function_normalizedInverseErf(float x) {
		NormalizedInverseErf normalizedInverseErf = new NormalizedInverseErf();
		return normalizedInverseErf.applyFunction(x);
	}
}
