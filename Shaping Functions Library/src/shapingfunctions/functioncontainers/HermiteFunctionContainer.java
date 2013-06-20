package shapingfunctions.functioncontainers;

import shapingfunctions.functions.hermite.*;
import shapingfunctions.library.FunctionContainer;

public class HermiteFunctionContainer extends FunctionContainer {

	// Hermite
	public float function_hermite(float x, float a, float b, float c, float d, boolean clamp) {
		Hermite hermite = new Hermite(a, b, c, d);
		return hermite.applyFunction(x, clamp);
	}
	
	public float function_hermite(float x, float a, float b, float c, float d) {
		Hermite hermite = new Hermite(a, b, c, d);
		return hermite.applyFunction(x);
	}
	
	// Hermite2
	public float function_hermite2(float x, float a, float b, float c, float d, boolean clamp) {
		Hermite2 hermite2 = new Hermite2(a, b, c, d);
		return hermite2.applyFunction(x, clamp);
	}
	
	public float function_hermite2(float x, float a, float b, float c, float d) {
		Hermite2 hermite2 = new Hermite2(a, b, c, d);
		return hermite2.applyFunction(x);
	}
}
