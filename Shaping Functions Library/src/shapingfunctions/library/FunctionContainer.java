package shapingfunctions.library;

import shapingfunctions.functioncontainers.*;

public class FunctionContainer {
	public BezierFunctionContainer bezierFunctions;
	public CircularFunctionContainer circularFunctions;
	public CosineFunctionContainer cosineFunctions;
	public ErrorFunctionContainer errorFunctions;
	public ExponentFunctionContainer exponentFunctions;
	public GaussianFunctionContainer gaussianFunctions;
	public GompertzFunctionContainer gompertzFunctions;
	public HermiteFunctionContainer hermiteFunctions;
	public InterpolationFunctionContainer interpolationFunctions;
	public LinearFunctionContainer linearFunctions;
	public OgeeFunctionContainer ogeeFunctions;
	public ParabolaFunctionContainer parabolaFunctions;
	public PennerFunctionContainer pennerFunctions;
	public SigmoidFunctionContainer sigmoidFunctions;
	public SinusoidFunctionContainer sinusoidFunctions;
	public SquareRootFunctionContainer squareRootFunctions;
	public StaircaseFunctionContainer staircaseFunctions;
	public StepFunctionContainer stepFunctions;
	public WindowFunctionContainer windowFunctions;
	
	public FunctionContainer() {
		bezierFunctions = new BezierFunctionContainer();
		circularFunctions = new CircularFunctionContainer();
		cosineFunctions = new CosineFunctionContainer();
		errorFunctions = new ErrorFunctionContainer();
		exponentFunctions = new ExponentFunctionContainer();
		gaussianFunctions = new GaussianFunctionContainer();
		gompertzFunctions = new GompertzFunctionContainer();
		hermiteFunctions = new HermiteFunctionContainer();
		interpolationFunctions = new InterpolationFunctionContainer();
		linearFunctions = new LinearFunctionContainer();
		ogeeFunctions = new OgeeFunctionContainer();
		parabolaFunctions = new ParabolaFunctionContainer();
		pennerFunctions = new PennerFunctionContainer();
		sigmoidFunctions = new SigmoidFunctionContainer();
		sinusoidFunctions = new SinusoidFunctionContainer();
		squareRootFunctions = new SquareRootFunctionContainer();
		staircaseFunctions = new StaircaseFunctionContainer();
		stepFunctions = new StepFunctionContainer();
		windowFunctions = new WindowFunctionContainer();
	}
}
