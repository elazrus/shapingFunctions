package shapingfunctions.functioncontainers;

import shapingfunctions.functions.gompertz.*;
import shapingfunctions.library.FunctionContainer;

public class GompertzFunctionContainer extends FunctionContainer {

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
