package shapingfunctions.functioncontainers;

import shapingfunctions.functions.ogee.*;
import shapingfunctions.library.FunctionContainer;

public class OgeeFunctionContainer extends FunctionContainer {

	// Double Cubic Ogee
	public float function_doubleCubicOgee(float x, float a, float b, boolean clamp) {
		DoubleCubicOgee doubleCubicOgee = new DoubleCubicOgee(a, b);
		return doubleCubicOgee.applyFunction(x, clamp);
	}
	
	public float function_doubleCubicOgee(float x, float a, float b) {
		DoubleCubicOgee doubleCubicOgee = new DoubleCubicOgee(a, b);
		return doubleCubicOgee.applyFunction(x);
	}
	
	// Double Cubic Ogee Simplified
	public float function_doubleCubicOgeeSimplified(float x, float a, float b, boolean clamp) {
		DoubleCubicOgeeSimplified doubleCubicOgeeSimplified = new DoubleCubicOgeeSimplified(a, b);
		return doubleCubicOgeeSimplified.applyFunction(x, clamp);
	}
	
	public float function_doubleCubicOgeeSimplified(float x, float a, float b) {
		DoubleCubicOgeeSimplified doubleCubicOgeeSimplified = new DoubleCubicOgeeSimplified(a, b);
		return doubleCubicOgeeSimplified.applyFunction(x);
	}
	
	// Double Elliptic Ogee
	public float function_doubleEllipticOgee(float x, float a, float b, boolean clamp) {
		DoubleEllipticOgee doubleEllipticOgee = new DoubleEllipticOgee(a, b);
		return doubleEllipticOgee.applyFunction(x, clamp);
	}
	
	public float function_doubleEllipticOgee(float x, float a, float b) {
		DoubleEllipticOgee doubleEllipticOgee = new DoubleEllipticOgee(a, b);
		return doubleEllipticOgee.applyFunction(x);
	}
	
	// Double Exponential Ogee
	public float function_doubleExponentialOgee(float x, float a, boolean clamp) {
		DoubleExponentialOgee doubleExponentialOgee = new DoubleExponentialOgee(a);
		return doubleExponentialOgee.applyFunction(x, clamp);
	}
	
	public float function_doubleExponentialOgee(float x, float a) {
		DoubleExponentialOgee doubleExponentialOgee = new DoubleExponentialOgee(a);
		return doubleExponentialOgee.applyFunction(x);
	}
	
	// Double Odd Polynomial Ogee
	public float function_doubleOddPolynomialOgee(float x, float a, float b, int n, boolean clamp) {
		DoubleOddPolynomialOgee doubleOddPolynomialOgee = new DoubleOddPolynomialOgee(a, b, n);
		return doubleOddPolynomialOgee.applyFunction(x, clamp);
	}
	
	public float function_doubleOddPolynomialOgee(float x, float a, float b, int n) {
		DoubleOddPolynomialOgee doubleOddPolynomialOgee = new DoubleOddPolynomialOgee(a, b, n);
		return doubleOddPolynomialOgee.applyFunction(x);
	}
}
