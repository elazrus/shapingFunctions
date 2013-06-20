package shapingfunctions.functioncontainers;

import shapingfunctions.functions.squareroot.*;
import shapingfunctions.library.FunctionContainer;

public class SquareRootFunctionContainer extends FunctionContainer {

	// Fast Square Root
	public float function_fastSquareRoot(float x, boolean clamp) {
		FastSquareRoot fastSquareRoot = new FastSquareRoot();
		return fastSquareRoot.applyFunction(x, clamp);
	}
	
	public float function_fastSquareRoot(float x) {
		FastSquareRoot fastSquareRoot = new FastSquareRoot();
		return fastSquareRoot.applyFunction(x);
	}
	
	// Iterative Square Root
	public float function_iterativeSquareRoot(float x, boolean clamp) {
		IterativeSquareRoot iterativeSquareRoot = new IterativeSquareRoot();
		return iterativeSquareRoot.applyFunction(x, clamp);
	}
	
	public float function_iterativeSquareRoot(float x) {
		IterativeSquareRoot iterativeSquareRoot = new IterativeSquareRoot();
		return iterativeSquareRoot.applyFunction(x);
	}
}
