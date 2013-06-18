package shapingfunctions.functioncontainers;

import shapingfunctions.functions.staircase.*;

public class StaircaseFunctionContainer {

	// Exponential Smoothed Staircase
	public float function_exponentialSmoothedStaircase(float x, float a, int n, boolean clamp) {
		ExponentialSmoothedStaircase exponentialSmoothedStaircase = new ExponentialSmoothedStaircase(a, n);
		return exponentialSmoothedStaircase.applyFunction(x, clamp);
	}
	
	public float function_exponentialSmoothedStaircase(float x, float a, int n) {
		ExponentialSmoothedStaircase exponentialSmoothedStaircase = new ExponentialSmoothedStaircase(a, n);
		return exponentialSmoothedStaircase.applyFunction(x);
	}
	
	// Quadratic Bezier Staircase
	public float function_quadraticBezierStaircase(float x, float a, int n, boolean clamp) {
		QuadraticBezierStaircase quadraticBezierStaircase = new QuadraticBezierStaircase(a, n);
		return quadraticBezierStaircase.applyFunction(x, clamp);
	}
	
	public float function_quadraticBezierStaircase(float x, float a, int n) {
		QuadraticBezierStaircase quadraticBezierStaircase = new QuadraticBezierStaircase(a, n);
		return quadraticBezierStaircase.applyFunction(x);
	}
	
	// Staircase
	public float function_staircase(float x, int n, boolean clamp) {
		Staircase staircase = new Staircase(n);
		return staircase.applyFunction(x, clamp);
	}
	
	public float function_staircase(float x, int n) {
		Staircase staircase = new Staircase(n);
		return staircase.applyFunction(x);
	}
	
	// Variable Staircase
	public float function_variableStaircase(float x, float a, int n, boolean clamp) {
		VariableStaircase variableStaircase = new VariableStaircase(a, n);
		return variableStaircase.applyFunction(x, clamp);
	}
	
	public float function_variableStaircase(float x, float a, int n) {
		VariableStaircase variableStaircase = new VariableStaircase(a, n);
		return variableStaircase.applyFunction(x);
	}
}
