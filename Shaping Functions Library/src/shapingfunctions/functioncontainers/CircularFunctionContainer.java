package shapingfunctions.functioncontainers;

import shapingfunctions.functions.circular.*;

public class CircularFunctionContainer {

	// Circular Arc Through A Point
	public float function_circularArcThroughAPoint(float x, float a, float b, boolean clamp) {
		CircularArcThroughAPoint circularArcThroughAPoint = new CircularArcThroughAPoint(a, b);
		return circularArcThroughAPoint.applyFunction(x, clamp);
	}

	public float function_circularArcThroughAPoint(float x, float a, float b) {
		CircularArcThroughAPoint circularArcThroughAPoint = new CircularArcThroughAPoint(a, b);
		return circularArcThroughAPoint.applyFunction(x);
	}

	// Circular Ease In
	public float function_circularEaseIn(float x, boolean clamp) {
		CircularEaseIn circularEaseIn = new CircularEaseIn();
		return circularEaseIn.applyFunction(x, clamp);
	}

	public float function_circularEaseIn(float x) {
		CircularEaseIn circularEaseIn = new CircularEaseIn();
		return circularEaseIn.applyFunction(x);
	}

	// Circular Ease In Out
	public float function_circularEaseInOut(float x, boolean clamp) {
		CircularEaseInOut circularEaseInOut = new CircularEaseInOut();
		return circularEaseInOut.applyFunction(x, clamp);
	}

	public float function_circularEaseInOut(float x) {
		CircularEaseInOut circularEaseInOut = new CircularEaseInOut();
		return circularEaseInOut.applyFunction(x);
	}

	// Circular Ease Out
	public float function_circularEaseOut(float x, boolean clamp) {
		CircularEaseOut circularEaseOut = new CircularEaseOut();
		return circularEaseOut.applyFunction(x, clamp);
	}

	public float function_circularEaseOut(float x) {
		CircularEaseOut circularEaseOut = new CircularEaseOut();
		return circularEaseOut.applyFunction(x);
	}

	// Circular Fillet
	public float function_circularFillet(float x, float a, float b, float c, boolean clamp) {
		CircularFillet circularFillet = new CircularFillet(a, b, c);
		return circularFillet.applyFunction(x, clamp);
	}

	public float function_circularFillet(float x, float a, float b, float c) {
		CircularFillet circularFillet = new CircularFillet(a, b, c);
		return circularFillet.applyFunction(x);
	}
}
