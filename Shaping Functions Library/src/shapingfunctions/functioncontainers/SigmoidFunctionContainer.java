package shapingfunctions.functioncontainers;

import shapingfunctions.functions.sigmoid.*;
import shapingfunctions.library.FunctionContainer;

public class SigmoidFunctionContainer extends FunctionContainer {

	// Adjustable Center Double Exponential Sigmoid
	public float function_adjustableCenterDoubleExponentialSigmoid(float x, float a, float b, boolean clamp) {
		AdjustableCenterDoubleExponentialSigmoid adjustableCenterDoubleExponentialSigmoid = new AdjustableCenterDoubleExponentialSigmoid(a, b);
		return adjustableCenterDoubleExponentialSigmoid.applyFunction(x, clamp);
	}
	
	public float function_adjustableCenterDoubleExponentialSigmoid(float x, float a, float b) {
		AdjustableCenterDoubleExponentialSigmoid adjustableCenterDoubleExponentialSigmoid = new AdjustableCenterDoubleExponentialSigmoid(a, b);
		return adjustableCenterDoubleExponentialSigmoid.applyFunction(x);
	}
	
	// Double Circular Sigmoid
	public float function_doubleCircularSigmoid(float x, float a, boolean clamp) {
		DoubleCircularSigmoid doubleCircularSigmoid = new DoubleCircularSigmoid(a);
		return doubleCircularSigmoid.applyFunction(x, clamp);
	}
	
	public float function_doubleCircularSigmoid(float x, float a) {
		DoubleCircularSigmoid doubleCircularSigmoid = new DoubleCircularSigmoid(a);
		return doubleCircularSigmoid.applyFunction(x);
	}
	
	// Double Elliptic Sigmoid
	public float function_doubleEllipticSigmoid(float x, float a, float b, boolean clamp) {
		DoubleEllipticSigmoid doubleEllipticSigmoid = new DoubleEllipticSigmoid(a, b);
		return doubleEllipticSigmoid.applyFunction(x, clamp);
	}
	
	public float function_doubleEllipticSigmoid(float x, float a, float b) {
		DoubleEllipticSigmoid doubleEllipticSigmoid = new DoubleEllipticSigmoid(a, b);
		return doubleEllipticSigmoid.applyFunction(x);
	}
	
	// Double Exponential Sigmoid
	public float function_doubleExponentialSigmoid(float x, float a, boolean clamp) {
		DoubleExponentialSigmoid doubleExponentialSigmoid = new DoubleExponentialSigmoid(a);
		return doubleExponentialSigmoid.applyFunction(x, clamp);
	}
	
	public float function_doubleExponentialSigmoid(float x, float a) {
		DoubleExponentialSigmoid doubleExponentialSigmoid = new DoubleExponentialSigmoid(a);
		return doubleExponentialSigmoid.applyFunction(x);
	}
	
	// Double Polynomial Sigmoid
	public float function_doublePolynomialSigmoid(float x, int n, boolean clamp) {
		DoublePolynomialSigmoid doublePolynomialSigmoid = new DoublePolynomialSigmoid(n);
		return doublePolynomialSigmoid.applyFunction(x, clamp);
	}
	
	public float function_doublePolynomialSigmoid(float x, int n) {
		DoublePolynomialSigmoid doublePolynomialSigmoid = new DoublePolynomialSigmoid(n);
		return doublePolynomialSigmoid.applyFunction(x);
	}
	
	// Double Quadratic Sigmoid
	public float function_doubleQuadraticSigmoid(float x, boolean clamp) {
		DoubleQuadraticSigmoid doubleQuadraticSigmoid = new DoubleQuadraticSigmoid();
		return doubleQuadraticSigmoid.applyFunction(x, clamp);
	}
	
	public float function_doubleQuadraticSigmoid(float x) {
		DoubleQuadraticSigmoid doubleQuadraticSigmoid = new DoubleQuadraticSigmoid();
		return doubleQuadraticSigmoid.applyFunction(x);
	}
	
	// Double Squircular Sigmoid
	public float function_doubleSquircularSigmoid(float x, float a, int n, boolean clamp) {
		DoubleSquircularSigmoid doubleSquircularSigmoid = new DoubleSquircularSigmoid(a, n);
		return doubleSquircularSigmoid.applyFunction(x, clamp);
	}
	
	public float function_doubleSquircularSigmoid(float x, float a, int n) {
		DoubleSquircularSigmoid doubleSquircularSigmoid = new DoubleSquircularSigmoid(a, n);
		return doubleSquircularSigmoid.applyFunction(x);
	}
}
