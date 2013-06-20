package shapingfunctions.library;

public class ShapingFunctionsConstants {
	// bezier
	public static final String BEZIER_CUBIC = "function_cubicBezier";
	public static final String BEZIER_CUBIC2POINTS = "function_cubicBezierThrough2Points";
	public static final String BEZIER_DOUBLEQUAD = "function_doubleQuadraticBezier";
	public static final String BEZIER_QUAD = "function_quadraticBezier";
	
	// circular
	public static final String CIRCULAR_ARCTHRUPOINT = "function_circularArcThroughAPoint";
	public static final String CIRCULAR_EASEIN = "function_circularEaseIn";
	public static final String CIRCULAR_EASEINOUT = "function_circularEaseInOut";
	public static final String CIRCULAR_EASEOUT = "function_circularEaseOut";
	public static final String CIRCULAR_FILLET = "function_circularFillet";
	
	// cosine
	public static final String COSINE_BLINNWYVILLAPPROX = "function_blinnWyvillCosineApproximation";
	public static final String COSINE_MACLAURIN = "function_maclaurinCos";
	public static final String COSINE_RAISEDINVERTED = "function_raisedInvertedCosine";
	
	// error
	public static final String ERROR_NORM = "function_normalizedErf";
	public static final String ERROR_NORMINVERSE = "function_normalizedInverseErf";
	
	// exponent
	public static final String EXPONENT_EMPHASIS = "function_exponentialEmphasis";
	
	// gaussian
	public static final String GAUSSIAN_ADJUSTFWHMHALF = "function_adjustableFwhmHalfGaussian";
	public static final String GAUSSIAN_ADJUSTSIGMA = "function_adjustableSigmaGaussian";
	public static final String GAUSSIAN_ADJUSTSIGMAHALF = "function_adjustableSigmaHalfGaussian";
	public static final String GAUSSIAN_HALFTHRUPOINT = "function_halfGaussianThroughAPoint";
	public static final String GAUSSIAN_SIMPLEHALF = "function_simpleHalfGaussian";
	public static final String GAUSSIAN_SLIDINGADJUSTSIGMA = "function_slidingAdjustableSigmaGaussian";
	
	// gompertz
	public static final String GOMPERTZ = "function_gompertz";
	
	// hermite
	public static final String HERMITE = "function_hermite";
	public static final String HERMITE2 = "function_hermite2";
	
	// interpolation 
	public static final String INTERP_CATMULLROM = "function_catmullRomInterpolate";
	
	// linear
	public static final String LINEAR_DOUBLE = "function_doubleLinear";
	public static final String LINEAR_GENERALMAP = "function_generalizedLinearMap";
	public static final String LINEAR_TRIPLE = "function_tripleLinear";
	
	// ogee
	public static final String OGEE_DOUBLECUBIC = "function_doubleCubicOgee";
	public static final String OGEE_DOUBLECUBICSIMP = "function_doubleCubicOgeeSimplified";
	public static final String OGEE_DOUBLEELLIPTIC = "function_doubleEllipticOgee";
	public static final String OGEE_DOUBLEEXPO = "function_doubleExponentialOgee";
	public static final String OGEE_DOUBLEODDPOLY = "function_doubleOddPolynomialOgee";
	
	// parabola
	public static final String PARABOLA_THRUPOINT = "function_parabolaThroughAPoint";
	
	// penner
	public static final String PENNER_EASEINBACK = "function_pennerEaseInBack";
	public static final String PENNER_EASEINBOUNCE = "function_pennerEaseInBounce";
	public static final String PENNER_EASEINCUBIC = "function_pennerEaseInCubic";
	public static final String PENNER_EASEINELASTIC = "function_pennerEaseInElastic";
	public static final String PENNER_EASEINEXPO = "function_pennerEaseInExpo";
	public static final String PENNER_EASEINOUTBACK = "function_pennerEaseInOutBack";
	public static final String PENNER_EASEINOUTBOUNCE = "function_pennerEaseInOutBounce";
	public static final String PENNER_EASEINOUTCUBIC = "function_pennerEaseInOutCubic";
	public static final String PENNER_EASEINOUTELASTIC = "function_pennerEaseInOutElastic";
	public static final String PENNER_EASEINOUTEXPO = "function_pennerEaseInOutExpo";
	public static final String PENNER_EASEINOUTQUAD = "function_pennerEaseInOutQuadratic";
	public static final String PENNER_EASEINOUTQUART = "function_pennerEaseInOutQuartic";
	public static final String PENNER_EASEINOUTQUINT = "function_pennerEaseInOutQuintic";
	public static final String PENNER_EASEINOUTSINE = "function_pennerEaseInOutSine";
	public static final String PENNER_EASEINQUAD = "function_pennerEaseInQuadratic";
	public static final String PENNER_EASEINQUART = "function_pennerEaseInQuartic";
	public static final String PENNER_EASEINQUINT = "function_pennerEaseInQuintic";
	public static final String PENNER_EASEINSINE = "function_pennerEaseInSine";
	public static final String PENNER_EASEOUTBACK = "function_pennerEaseOutBack";
	public static final String PENNER_EASEOUTBOUNCE = "function_pennerEaseOutBounce";
	public static final String PENNER_EASEOUTCUBIC = "function_pennerEaseOutCubic";
	public static final String PENNER_EASEOUTELASTIC = "function_pennerEaseOutElastic";
	public static final String PENNER_EASEOUTEXPO = "function_pennerEaseOutExpo";
	public static final String PENNER_EASEOUTQUAD = "function_pennerEaseOutQuadratic";
	public static final String PENNER_EASEOUTQUART = "function_pennerEaseOutQuartic";
	public static final String PENNER_EASEOUTQUINT = "function_pennerEaseOutQuintic";
	public static final String PENNER_EASEOUTSINE = "function_pennerEaseOutSine";
	
	// sigmoid
	public static final String SIGMOID_ADJUSTCENTERDOUBLEEXPO = "function_adjustableCenterDoubleExponentialSigmoid";
	public static final String SIGMOID_DOUBLECIRCULAR = "function_doubleCircularSigmoid";
	public static final String SIGMOID_DOUBLEELLIPTIC = "function_doubleEllipticSigmoid";
	public static final String SIGMOID_DOUBLEEXPO = "function_doubleExponentialSigmoid";
	public static final String SIGMOID_DOUBLEPOLY = "function_doublePolynomialSigmoid";
	public static final String SIGMOID_DOUBLEQUAD = "function_doubleQuadraticSigmoid";
	public static final String SIGMOID_DOUBLESQUIRCULAR = "function_doubleSquircularSigmoid";
	
	// sinusoid
	public static final String SINUSOID_DAMPED = "function_dampedSinusoid";
	public static final String SINUSOID_DAMPEDREVERSE = "function_dampedSinusoidReverse";
	
	// square root
	public static final String SQROOT_FAST = "function_fastSquareRoot";
	public static final String SQROOT_ITERATIVE = "function_iterativeSquareRoot";
	
	// staircase
	public static final String STAIRCASE_EXPOSMOOTHED = "function_exponentialSmoothedStaircase";
	public static final String STAIRCASE_QUADBEZIER = "function_quadraticBezierStaircase";
	public static final String STAIRCASE = "function_staircase";
	public static final String STAIRCASE_VARIABLE = "function_variableStaircase";
	
	// step
	public static final String STEP_SMOOTHER = "function_smootherStep";
	public static final String STEP_SMOOTH = "function_smoothStep";
	
	// window
	public static final String WINDOW_ADJUSTCENTERCOS = "function_adjustableCenterCosineWindow";
	public static final String WINDOW_ADJUSTCENTERELLIPTIC = "function_adjustableCenterEllipticWindow";
	public static final String WINDOW_ADJUSTCENTERHYPERELLIPTIC = "function_adjustableCenterHyperellipticWindow";
	public static final String WINDOW_ADJUSTCENTERSQUIRCULAR = "function_adjustableCenterSquircularWindow";
	public static final String WINDOW_BARTLETTHANN = "function_bartlettHannWindow";
	public static final String WINDOW_BARTLETT = "function_bartlettWindow";
	public static final String WINDOW_BLACKMANHARRIS = "function_blackmanHarrisWindow";
	public static final String WINDOW_BLACKMANNUTTALL = "function_blackmanNuttallWindow";
	public static final String WINDOW_COS = "function_cosineWindow";
	public static final String WINDOW_EXACTBLACKMAN = "function_exactBlackmanWindow";
	public static final String WINDOW_FLATTOP = "function_flatTopWindow";
	public static final String WINDOW_GENERALBLACKMAN = "function_generalizedBlackmanWindow";
	public static final String WINDOW_GENERALTRIANGLE = "function_generalizedTriangleWindow";
	public static final String WINDOW_HALFBARTLETTHANN = "function_halfBartlettHannWindow";
	public static final String WINDOW_HALFBLACKMANHARRIS = "function_halfBlackmanHarrisWindow";
	public static final String WINDOW_HALFBLACKMANNUTTALL = "function_halfBlackmanNuttallWindow";
	public static final String WINDOW_HALFEXACTBLACKMAN = "function_halfExactBlackmanWindow";
	public static final String WINDOW_HALFFLATTOP = "function_halfFlatTopWindow";
	public static final String WINDOW_HALFGENERALBLACKMAN = "function_halfGeneralizedBlackmanWindow";
	public static final String WINDOW_HALFLANCZOSINC = "function_halfLanczosSincWindow";
	public static final String WINDOW_HALFNUTTALL = "function_halfNuttallWindow";
	public static final String WINDOW_HAMMING = "function_hammingWindow";
	public static final String WINDOW_HANNPOISSON = "function_hannPoissonWindow";
	public static final String WINDOW_HANNPOISSONSLIDING = "function_hannPoissionWindowSliding";
	public static final String WINDOW_HANN = "function_hannWindow";
	public static final String WINDOW_LANCZOSSINC = "function_lanczosSincWindow";
	public static final String WINDOW_NUTTALL = "function_nuttallWindow";
	public static final String WINDOW_POISSON = "function_poissonWindow";
	public static final String WINDOW_TUKEY = "function_tukeyWindow";
}
