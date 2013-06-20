package shapingfunctions.functioncontainers;

import shapingfunctions.functions.window.*;
import shapingfunctions.library.FunctionContainer;

public class WindowFunctionContainer extends FunctionContainer {

	// Adjustable Center Cosine Window
	public float function_adjustableCenterCosineWindow(float x, float a, boolean clamp) {
		AdjustableCenterCosineWindow adjustableCenterCosineWindow = new AdjustableCenterCosineWindow(a);
		return adjustableCenterCosineWindow.applyFunction(x, clamp);
	}
	
	public float function_adjustableCenterCosineWindow(float x, float a) {
		AdjustableCenterCosineWindow adjustableCenterCosineWindow = new AdjustableCenterCosineWindow(a);
		return adjustableCenterCosineWindow.applyFunction(x);
	}
	
	// Adjustable Center Elliptic Window
	public float function_adjustableCenterEllipticWindow(float x, float a, boolean clamp) {
		AdjustableCenterEllipticWindow adjustableCenterEllipticWindow = new AdjustableCenterEllipticWindow(a);
		return adjustableCenterEllipticWindow.applyFunction(x, clamp);
	}
	
	public float function_adjustableCenterEllipticWindow(float x, float a) {
		AdjustableCenterEllipticWindow adjustableCenterEllipticWindow = new AdjustableCenterEllipticWindow(a);
		return adjustableCenterEllipticWindow.applyFunction(x);
	}
	
	// Adjustable Center Hyperelliptic Window
	public float function_adjustableCenterHyperellipticWindow(float x, float a, int n, boolean clamp) {
		AdjustableCenterHyperellipticWindow adjustableCenterHyperellipticWindow = new AdjustableCenterHyperellipticWindow(a, n);
		return adjustableCenterHyperellipticWindow.applyFunction(x, clamp);
	}
	
	public float function_adjustableCenterHyperellipticWindow(float x, float a, int n) {
		AdjustableCenterHyperellipticWindow adjustableCenterHyperellipticWindow = new AdjustableCenterHyperellipticWindow(a, n);
		return adjustableCenterHyperellipticWindow.applyFunction(x);
	}
	
	// Adjustable Center Squircular Window
	public float function_adjustableCenterSquircularWindow(float x, float a, int n, boolean clamp) {
		AdjustableCenterSquircularWindow adjustableCenterSquircularWindow = new AdjustableCenterSquircularWindow(a, n);
		return adjustableCenterSquircularWindow.applyFunction(x, clamp);
	}
	
	public float function_adjustableCenterSquircularWindow(float x, float a, int n) {
		AdjustableCenterSquircularWindow adjustableCenterSquircularWindow = new AdjustableCenterSquircularWindow(a, n);
		return adjustableCenterSquircularWindow.applyFunction(x);
	}
	
	// Bartlett Hann Window
	public float function_bartlettHannWindow(float x, boolean clamp) {
		BartlettHannWindow bartlettHannWindow = new BartlettHannWindow();
		return bartlettHannWindow.applyFunction(x, clamp);
	}
	
	public float function_bartlettHannWindow(float x) {
		BartlettHannWindow bartlettHannWindow = new BartlettHannWindow();
		return bartlettHannWindow.applyFunction(x);
	}
	
	// Bartlett Window
	public float function_bartlettWindow(float x, boolean clamp) {
		BartlettWindow bartlettWindow = new BartlettWindow();
		return bartlettWindow.applyFunction(x, clamp);
	}
	
	public float function_bartlettWindow(float x) {
		BartlettWindow bartlettWindow = new BartlettWindow();
		return bartlettWindow.applyFunction(x);
	}
	
	// Blackman Harris Window
	public float function_blackmanHarrisWindow(float x, boolean clamp) {
		BlackmanHarrisWindow blackmanHarrisWindow = new BlackmanHarrisWindow();
		return blackmanHarrisWindow.applyFunction(x, clamp);
	}
	
	public float function_blackmanHarrisWindow(float x) {
		BlackmanHarrisWindow blackmanHarrisWindow = new BlackmanHarrisWindow();
		return blackmanHarrisWindow.applyFunction(x);
	}
	
	// Blackman Nuttall Window
	public float function_blackmanNuttallWindow(float x, boolean clamp) {
		BlackmanNuttallWindow blackmanNuttallWindow = new BlackmanNuttallWindow();
		return blackmanNuttallWindow.applyFunction(x, clamp);
	}
	
	public float function_blackmanNuttallWindow(float x) {
		BlackmanNuttallWindow blackmanNuttallWindow = new BlackmanNuttallWindow();
		return blackmanNuttallWindow.applyFunction(x);
	}
	
	// Cosine Window
	public float function_cosineWindow(float x, boolean clamp) {
		CosineWindow cosineWindow = new CosineWindow();
		return cosineWindow.applyFunction(x, clamp);
	}
	
	public float function_cosineWindow(float x) {
		CosineWindow cosineWindow = new CosineWindow();
		return cosineWindow.applyFunction(x);
	}
	
	// Exact Blackman Window
	public float function_exactBlackmanWindow(float x, boolean clamp) {
		ExactBlackmanWindow exactBlackmanWindow = new ExactBlackmanWindow();
		return exactBlackmanWindow.applyFunction(x, clamp);
	}
	
	public float function_exactBlackmanWindow(float x) {
		ExactBlackmanWindow exactBlackmanWindow = new ExactBlackmanWindow();
		return exactBlackmanWindow.applyFunction(x);
	}
	
	// Flat Top Window
	public float function_flatTopWindow(float x, boolean clamp) {
		FlatTopWindow flatTopWindow = new FlatTopWindow();
		return flatTopWindow.applyFunction(x, clamp);
	}
	
	public float function_flatTopWindow(float x) {
		FlatTopWindow flatTopWindow = new FlatTopWindow();
		return flatTopWindow.applyFunction(x);
	}
	
	// Generalized Blackman Window
	public float function_generalizedBlackmanWindow(float x, float a, boolean clamp) {
		GeneralizedBlackmanWindow generalizedBlackmanWindow = new GeneralizedBlackmanWindow(a);
		return generalizedBlackmanWindow.applyFunction(x, clamp);
	}
	
	public float function_generalizedBlackmanWindow(float x, float a) {
		GeneralizedBlackmanWindow generalizedBlackmanWindow = new GeneralizedBlackmanWindow(a);
		return generalizedBlackmanWindow.applyFunction(x);
	}
	
	// Generalized Triangle Window
	public float function_generalizedTriangleWindow(float x, float a, boolean clamp) {
		GeneralizedTriangleWindow generalizedTriangleWindow = new GeneralizedTriangleWindow(a);
		return generalizedTriangleWindow.applyFunction(x, clamp);
	}
	
	public float function_generalziedTriangleWindow(float x, float a) {
		GeneralizedTriangleWindow generalizedTriangleWindow = new GeneralizedTriangleWindow(a);
		return generalizedTriangleWindow.applyFunction(x);
	}
	
	// Half Bartlett Hann Window
	public float function_halfBartlettHannWindow(float x, boolean clamp) {
		HalfBartlettHannWindow halfBartlettHannWindow = new HalfBartlettHannWindow();
		return halfBartlettHannWindow.applyFunction(x, clamp);
	}
	
	public float function_halfBartlettHannWindow(float x) {
		HalfBartlettHannWindow halfBartlettHannWindow = new HalfBartlettHannWindow();
		return halfBartlettHannWindow.applyFunction(x);
	}
	
	// Half Blackman Harris Window
	public float function_halfBlackmanHarrisWindow(float x, boolean clamp) {
		HalfBlackmanHarrisWindow halfBlackmanHarrisWindow = new HalfBlackmanHarrisWindow();
		return halfBlackmanHarrisWindow.applyFunction(x, clamp);
	}
	
	public float function_halfBlackmanHarrisWindow(float x) {
		HalfBlackmanHarrisWindow halfBlackmanHarrisWindow = new HalfBlackmanHarrisWindow();
		return halfBlackmanHarrisWindow.applyFunction(x);
	}
	
	// Half Blackman Nuttall Window
	public float function_halfBlackmanNuttallWindow(float x, boolean clamp) {
		HalfBlackmanNuttallWindow halfBlackmanNuttallWindow = new HalfBlackmanNuttallWindow();
		return halfBlackmanNuttallWindow.applyFunction(x, clamp);
	}
	
	public float function_halfBlackmanNuttallWindow(float x) {
		HalfBlackmanNuttallWindow halfBlackmanNuttallWindow = new HalfBlackmanNuttallWindow();
		return halfBlackmanNuttallWindow.applyFunction(x);
	}
	
	// Half Exact Blackman Window
	public float function_halfExactBlackmanWindow(float x, boolean clamp) {
		HalfExactBlackmanWindow halfExactBlackmanWindow = new HalfExactBlackmanWindow();
		return halfExactBlackmanWindow.applyFunction(x, clamp);
	}
	
	public float function_halfExactBlackmanWindow(float x) {
		HalfExactBlackmanWindow halfExactBlackmanWindow = new HalfExactBlackmanWindow();
		return halfExactBlackmanWindow.applyFunction(x);
	}
	
	// Half Flat Top Window
	public float function_halfFlatTopWindow(float x, boolean clamp) {
		HalfFlatTopWindow halfFlatTopWindow = new HalfFlatTopWindow();
		return halfFlatTopWindow.applyFunction(x, clamp);
	}
	
	public float function_halfFloatTopWindow(float x) {
		HalfFlatTopWindow halfFlatTopWindow = new HalfFlatTopWindow();
		return halfFlatTopWindow.applyFunction(x);
	}
	
	// Half Generalized Blackman Window
	public float function_halfGeneralizedBlackmanWindow(float x, float a, boolean clamp) {
		HalfGeneralizedBlackmanWindow halfGeneralizedBlackmanWindow = new HalfGeneralizedBlackmanWindow(a);
		return halfGeneralizedBlackmanWindow.applyFunction(x, clamp);
	}
	
	public float function_halfGeneralizedBlackmanWindow(float x, float a) {
		HalfGeneralizedBlackmanWindow halfGeneralizedBlackmanWindow = new HalfGeneralizedBlackmanWindow(a);
		return halfGeneralizedBlackmanWindow.applyFunction(x);
	}
	
	// Half Lanczos Sinc Window
	public float function_halfLanczosSincWindow(float x, boolean clamp) {
		HalfLanczosSincWindow halfLanczosSincWindow = new HalfLanczosSincWindow();
		return halfLanczosSincWindow.applyFunction(x, clamp);
	}
	
	public float function_halfLanczosSincWindow(float x) {
		HalfLanczosSincWindow halfLanczosSincWindow = new HalfLanczosSincWindow();
		return halfLanczosSincWindow.applyFunction(x);
	}
	
	// Half Nuttall Window
	public float function_halfNuttallWindow(float x, boolean clamp) {
		HalfNuttallWindow halfNuttallWindow = new HalfNuttallWindow();
		return halfNuttallWindow.applyFunction(x, clamp);
	}
	
	public float function_halfNuttallWindow(float x) {
		HalfNuttallWindow halfNuttallWindow = new HalfNuttallWindow();
		return halfNuttallWindow.applyFunction(x);
	}
	
	// Hamming Window
	public float function_hammingWindow(float x, boolean clamp) {
		HammingWindow hammingWindow = new HammingWindow();
		return hammingWindow.applyFunction(x, clamp);
	}
	
	public float function_hammingWindow(float x) {
		HammingWindow hammingWindow = new HammingWindow();
		return hammingWindow.applyFunction(x);
	}
	
	// Hann Poisson Window
	public float function_hannPoissonWindow(float x, float a, boolean clamp) {
		HannPoissonWindow hannPoissonWindow = new HannPoissonWindow(a);
		return hannPoissonWindow.applyFunction(x, clamp);
	}
	
	public float function_hannPoissonWindow(float x, float a) {
		HannPoissonWindow hannPoissonWindow = new HannPoissonWindow(a);
		return hannPoissonWindow.applyFunction(x);
	}
	
	// Hann Poisson Window Sliding
	public float function_hannPoissonWindowSliding(float x, float a, float b, boolean clamp) {
		HannPoissonWindowSliding hannPoissonWindowSliding = new HannPoissonWindowSliding(a, b);
		return hannPoissonWindowSliding.applyFunction(x, clamp);
	}
	
	public float function_hannPoissonWindowSliding(float x, float a, float b) {
		HannPoissonWindowSliding hannPoissonWindowSliding = new HannPoissonWindowSliding(a, b);
		return hannPoissonWindowSliding.applyFunction(x);
	}
	
	// Hann Window
	public float function_hannWindow(float x, boolean clamp) {
		HannWindow hannWindow = new HannWindow();
		return hannWindow.applyFunction(x, clamp);
	}
	
	public float function_hannWindow(float x) {
		HannWindow hannWindow = new HannWindow();
		return hannWindow.applyFunction(x);
	}
	
	// Lanczos Sinc Window
	public float function_lanczosSincWindow(float x, boolean clamp) {
		LanczosSincWindow lanczosSincWindow = new LanczosSincWindow();
		return lanczosSincWindow.applyFunction(x, clamp);
	}
	
	public float function_lanczosSincWindow(float x) {
		LanczosSincWindow lanczosSincWindow = new LanczosSincWindow();
		return lanczosSincWindow.applyFunction(x);
	}
	
	// Nuttall Window
	public float function_nuttallWindow(float x, boolean clamp) {
		NuttallWindow nuttallWindow = new NuttallWindow();
		return nuttallWindow.applyFunction(x, clamp);
	}
	
	public float function_nuttallWindow(float x) {
		NuttallWindow nuttallWindow = new NuttallWindow();
		return nuttallWindow.applyFunction(x);
	}
	
	// Poisson Window
	public float function_poissonWindow(float x, float a, boolean clamp) {
		PoissonWindow poissonWindow = new PoissonWindow(a);
		return poissonWindow.applyFunction(x, clamp);
	}
	
	public float function_poissonWindow(float x, float a) {
		PoissonWindow poissonWindow = new PoissonWindow(a);
		return poissonWindow.applyFunction(x);
	}
	
	// Tukey Window
	public float function_tukeyWindow(float x, float a, boolean clamp) {
		TukeyWindow tukeyWindow = new TukeyWindow(a);
		return tukeyWindow.applyFunction(x, clamp);
	}
	
	public float function_tukeyWindow(float x, float a) {
		TukeyWindow tukeyWindow = new TukeyWindow(a);
		return tukeyWindow.applyFunction(x);
	}
}
