package shapingfunctions.functioncontainers;

import shapingfunctions.functions.step.*;

public class StepFunctionContainer {
	
	// Smoother Step
	public float function_smootherStep(float x, boolean clamp) {
		SmootherStep smootherStep = new SmootherStep();
		return smootherStep.applyFunction(x, clamp);
	}
	
	public float function_smootherStep(float x) {
		SmootherStep smootherStep = new SmootherStep();
		return smootherStep.applyFunction(x);
	}
	
	// Smooth Step
	public float function_smoothStep(float x, boolean clamp) {
		SmoothStep smoothStep = new SmoothStep();
		return smoothStep.applyFunction(x, clamp);
	}
	
	public float function_smoothStep(float x) {
		SmoothStep smoothStep = new SmoothStep();
		return smoothStep.applyFunction(x);
	}
}
