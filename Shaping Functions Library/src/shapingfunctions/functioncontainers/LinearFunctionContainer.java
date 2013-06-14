package shapingfunctions.functioncontainers;

import shapingfunctions.functions.linear.*;

public class LinearFunctionContainer {

	// Double Linear
	public float function_doubleLinear(float x, float a, float b, boolean clamp) {
		DoubleLinear doubleLinear = new DoubleLinear(a, b);
		return doubleLinear.applyFunction(x, clamp);
	}
	
	public float function_doubleLinear(float x, float a, float b) {
		DoubleLinear doubleLinear = new DoubleLinear(a, b);
		return doubleLinear.applyFunction(x);
	}
	
	// Generalized Linear Map
	public float function_generalizedLinearMap(float x, float a, float b, float c, float d, boolean clamp) {
		GeneralizedLinearMap generalizedLinearMap = new GeneralizedLinearMap(a, b, c, d);
		return generalizedLinearMap.applyFunction(x, clamp);
	}
	
	public float function_generalizedLinearMap(float x, float a, float b, float c, float d) {
		GeneralizedLinearMap generalizedLinearMap = new GeneralizedLinearMap(a, b, c, d);
		return generalizedLinearMap.applyFunction(x);
	}
	
	// Triple Linear
	public float function_tripleLinear(float x, float a, float b, float c, float d, boolean clamp) {
		TripleLinear tripleLinear = new TripleLinear(a, b, c, d);
		return tripleLinear.applyFunction(x, clamp);
	}
	
	public float function_tripleLinear(float x, float a, float b, float c, float d) {
		TripleLinear tripleLinear = new TripleLinear(a, b, c, d);
		return tripleLinear.applyFunction(x);
	}
}
