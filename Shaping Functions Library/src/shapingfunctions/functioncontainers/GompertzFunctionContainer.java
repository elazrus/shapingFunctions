package shapingfunctions.functioncontainers;

import shapingfunctions.functions.gompertz.*;

public class GompertzFunctionContainer {

	// Gompertz
	public float function_gompertz(float x, float a, boolean clamp) {
		Gompertz gompertz = new Gompertz(a);
		return gompertz.applyFunction(x, clamp);
	}
	
	public float function_gompertz(float x, float a) {
		Gompertz gompertz = new Gompertz(a);
		return gompertz.applyFunction(x);
	}
}
