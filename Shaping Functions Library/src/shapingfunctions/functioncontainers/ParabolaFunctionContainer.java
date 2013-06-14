package shapingfunctions.functioncontainers;

import shapingfunctions.functions.parabola.*;

public class ParabolaFunctionContainer {

	// Parabola Through A Point
	public float function_parabolaThroughAPoint(float x, float a, float b, boolean clamp) {
		ParabolaThroughAPoint parabolaThroughAPoint = new ParabolaThroughAPoint(a, b);
		return parabolaThroughAPoint.applyFunction(x, clamp);
	}
	
	public float function_parabolaThroughAPoint(float x, float a, float b) {
		ParabolaThroughAPoint parabolaThroughAPoint = new ParabolaThroughAPoint(a, b);
		return parabolaThroughAPoint.applyFunction(x);
	}
}
