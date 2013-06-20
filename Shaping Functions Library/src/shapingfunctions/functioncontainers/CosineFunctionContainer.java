package shapingfunctions.functioncontainers;

import shapingfunctions.functions.cosine.*;
import shapingfunctions.library.FunctionContainer;

public class CosineFunctionContainer extends FunctionContainer {

	// Blinn Wyvill Cosine Approximation
	public float function_blinnWyvillCosineApproximation(float x, boolean clamp) {
		BlinnWyvillCosineApproximation blinnWyvillCosineApproximation = new BlinnWyvillCosineApproximation();
		return blinnWyvillCosineApproximation.applyFunction(x, clamp);
	}

	public float function_blinnWyvillCosineApproximation(float x) {
		BlinnWyvillCosineApproximation blinnWyvillCosineApproximation = new BlinnWyvillCosineApproximation();
		return blinnWyvillCosineApproximation.applyFunction(x);
	}

	// Maclaurin Cosine
	public float function_maclaurinCos(float x, boolean clamp) {
		MaclaurinCos maclaurinCos = new MaclaurinCos();
		return maclaurinCos.applyFunction(x, clamp);
	}

	public float function_maclaurinCos(float x) {
		MaclaurinCos maclaurinCos = new MaclaurinCos();
		return maclaurinCos.applyFunction(x);
	}

	// Raised Inverted Cosine
	public float function_raisedInvertedCosine(float x, boolean clamp) {
		RaisedInvertedCosine raisedInvertedCosine = new RaisedInvertedCosine();
		return raisedInvertedCosine.applyFunction(x, clamp);
	}
	
	public float function_raiseInvertedCosine(float x) {
		RaisedInvertedCosine raisedInvertedCosine = new RaisedInvertedCosine();
		return raisedInvertedCosine.applyFunction(x);
	}
}
