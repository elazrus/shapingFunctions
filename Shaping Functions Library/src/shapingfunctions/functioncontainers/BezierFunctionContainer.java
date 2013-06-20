package shapingfunctions.functioncontainers;

import shapingfunctions.functions.bezier.*;
import shapingfunctions.library.FunctionContainer;

public class BezierFunctionContainer extends FunctionContainer {

	// Cubic Bezier
	public float function_cubicBezier(float x, float a, float b, float c, float d, boolean clamp) {
		CubicBezier cubicBezier = new CubicBezier(a, b, c, d);
		return cubicBezier.applyFunction(x, clamp);
	}

	public float function_cubicBezier(float x, float a, float b, float c,
			float d) {
		CubicBezier cubicBezier = new CubicBezier(a, b, c, d);
		return cubicBezier.applyFunction(x);
	}

	// Cubic Bezier Through 2 Points
	public float function_cubicBezierThrough2Points(float x, float a, float b, float c, float d, boolean clamp) {
		CubicBezierThrough2Points cubicBezierThrough2Points = new CubicBezierThrough2Points(
				a, b, c, d);
		return cubicBezierThrough2Points.applyFunction(x, clamp);
	}

	public float function_cubicBezierThrough2Points(float x, float a, float b, float c, float d) {
		CubicBezierThrough2Points cubicBezierThrough2Points = new CubicBezierThrough2Points(
				a, b, c, d);
		return cubicBezierThrough2Points.applyFunction(x);
	}

	// Double Quadratic Bezier
	public float function_doubleQuadraticBezier(float x, float a, float b, float c, float d, boolean clamp) {
		DoubleQuadraticBezier doubleQuadraticBezier = new DoubleQuadraticBezier(
				a, b, c, d);
		return doubleQuadraticBezier.applyFunction(x, clamp);
	}

	public float function_doubleQuadraticBezier(float x, float a, float b, float c, float d) {
		DoubleQuadraticBezier doubleQuadraticBezier = new DoubleQuadraticBezier(
				a, b, c, d);
		return doubleQuadraticBezier.applyFunction(x);
	}

	// Quadratic Bezier
	public float function_quadraticBezier(float x, float a, float b, boolean clamp) {
		QuadraticBezier quadraticBezier = new QuadraticBezier(a, b);
		return quadraticBezier.applyFunction(x, clamp);
	}

	public float function_quadraticBezier(float x, float a, float b) {
		QuadraticBezier quadraticBezier = new QuadraticBezier(a, b);
		return quadraticBezier.applyFunction(x);
	}
}
