package shapingfunctions.functioncontainers;

import shapingfunctions.functions.gaussian.*;

public class GaussianFunctionContainer {

	// Adjustable FWHM Half Gaussian
	public float function_adjustableFwhmHalfGaussian(float x, float a, boolean clamp) {
		AdjustableFwhmHalfGaussian adjustableFwhmHalfGaussian = new AdjustableFwhmHalfGaussian(a);
		return adjustableFwhmHalfGaussian.applyFunction(x, clamp);
	}
	
	public float function_adjustableFwhmHalfGaussian(float x, float a) {
		AdjustableFwhmHalfGaussian adjustableFwhmHalfGaussian = new AdjustableFwhmHalfGaussian(a);
		return adjustableFwhmHalfGaussian.applyFunction(x);
	}
	
	// Adjustable Sigma Gaussian
	public float function_adjustableSigmaGaussian(float x, float a, boolean clamp) {
		AdjustableSigmaGaussian adjustableSigmaGaussian = new AdjustableSigmaGaussian(a);
		return adjustableSigmaGaussian.applyFunction(x, clamp);
	}
	
	public float function_adjustableSigmaGaussian(float x, float a) {
		AdjustableSigmaGaussian adjustableSigmaGaussian = new AdjustableSigmaGaussian(a);
		return adjustableSigmaGaussian.applyFunction(x);
	}
	
	// Adjustable Sigma Half Gaussian
	public float function_adjustableSigmaHalfGaussian(float x, float a, boolean clamp) {
		AdjustableSigmaHalfGaussian adjustableSigmaHalfGaussian = new AdjustableSigmaHalfGaussian(a);
		return adjustableSigmaHalfGaussian.applyFunction(x, clamp);
	}
	
	public float function_adjustableSigmaHalfGaussian(float x, float a) {
		AdjustableSigmaHalfGaussian adjustableSigmaHalfGaussian = new AdjustableSigmaHalfGaussian(a);
		return adjustableSigmaHalfGaussian.applyFunction(x);
	}
	
	// Half Gaussian Through A Point
	public float function_halfGaussianThroughAPoint(float x, float a, float b, boolean clamp) {
		HalfGaussianThroughAPoint halfGaussianThroughAPoint = new HalfGaussianThroughAPoint(a, b);
		return halfGaussianThroughAPoint.applyFunction(x, clamp);
	}
	
	public float function_halfGaussianThroughAPoint(float x, float a, float b) {
		HalfGaussianThroughAPoint halfGaussianThroughAPoint = new HalfGaussianThroughAPoint(a, b);
		return halfGaussianThroughAPoint.applyFunction(x);
	}
	
	// Simple Half Gaussian
	public float function_simpleHalfGaussian(float x, boolean clamp) {
		SimpleHalfGaussian simpleHalfGaussian = new SimpleHalfGaussian();
		return simpleHalfGaussian.applyFunction(x, clamp);
	}
	
	public float function_simpleHalfGaussian(float x) {
		SimpleHalfGaussian simpleHalfGaussian = new SimpleHalfGaussian();
		return simpleHalfGaussian.applyFunction(x);
	}
	
	// Sliding Adjustable Sigma Gaussian
	public float function_slidingAdjustableSigmaGaussian(float x, float a, float b, boolean clamp) {
		SlidingAdjustableSigmaGaussian slidingAdjustableSigmaGaussian = new SlidingAdjustableSigmaGaussian(a, b);
		return slidingAdjustableSigmaGaussian.applyFunction(x, clamp);
	}
	
	public float function_slidingAdjustableSigmaGaussian(float x, float a, float b) {
		SlidingAdjustableSigmaGaussian slidingAdjustableSigmaGaussian = new SlidingAdjustableSigmaGaussian(a, b);
		return slidingAdjustableSigmaGaussian.applyFunction(x);
	}
}
