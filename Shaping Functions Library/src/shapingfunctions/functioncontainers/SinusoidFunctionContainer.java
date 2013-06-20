package shapingfunctions.functioncontainers;

import shapingfunctions.functions.sinusoid.*;
import shapingfunctions.library.FunctionContainer;

public class SinusoidFunctionContainer extends FunctionContainer {

	// Damped Sinusoid
	public float function_dampedSinusoid(float x, float a, boolean clamp) {
		DampedSinusoid dampedSinusoid = new DampedSinusoid(a);
		return dampedSinusoid.applyFunction(x, clamp);
	}
	
	public float function_dampedSinusoid(float x, float a) {
		DampedSinusoid dampedSinusoid = new DampedSinusoid(a);
		return dampedSinusoid.applyFunction(x);
	}
	
	// Damped Sinusoid Reverse
	public float function_dampedSinusoidReverse(float x, float a, boolean clamp) {
		DampedSinusoidReverse dampedSinusoidReverse = new DampedSinusoidReverse(a);
		return dampedSinusoidReverse.applyFunction(x, clamp);
	}
	
	public float function_dampedSinusoidReverse(float x, float a) {
		DampedSinusoidReverse dampedSinusoidReverse = new DampedSinusoidReverse(a);
		return dampedSinusoidReverse.applyFunction(x);
	}
}
