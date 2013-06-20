/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package shapingfunctions.library;


import processing.core.*;
import shapingfunctions.functioncontainers.*;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * @example Hello 
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class ShapingFunctionsContainer {
	
	// myParent is a reference to the parent sketch
	PApplet myParent;

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
	
	public final static String VERSION = "##library.prettyVersion##";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public ShapingFunctionsContainer(PApplet theParent) {
		myParent = theParent;
		
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
		
		welcome();
	}
	
	
	private void welcome() {
		System.out.println("##library.name## ##library.prettyVersion## by ##author##");
	}
	
	
	public String sayHello() {
		return "hello library.";
	}
	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}
	
	private boolean inContainer(FunctionContainer functionContainer, String funcName) {
		return functionContainer.functions.containsKey(funcName);
	}
	
	private FunctionContainer findContainer(String funcName) {
		if (inContainer(bezierFunctions, funcName))
			return bezierFunctions;
		
		if (inContainer(circularFunctions, funcName))
			return circularFunctions;
		
		if (inContainer(cosineFunctions, funcName))
			return cosineFunctions;
		
		if (inContainer(errorFunctions, funcName))
			return errorFunctions;
		
		if (inContainer(exponentFunctions, funcName))
			return exponentFunctions;
		
		if (inContainer(gaussianFunctions, funcName))
			return gaussianFunctions;
		
		if (inContainer(gompertzFunctions, funcName))
			return gompertzFunctions;
		
		if (inContainer(hermiteFunctions, funcName))
			return hermiteFunctions;
		
		if (inContainer(interpolationFunctions, funcName))
			return interpolationFunctions;
		
		if (inContainer(linearFunctions, funcName))
			return linearFunctions;
		
		if (inContainer(ogeeFunctions, funcName))
			return ogeeFunctions;
		
		if (inContainer(parabolaFunctions, funcName))
			return parabolaFunctions;
		
		if (inContainer(pennerFunctions, funcName))
			return pennerFunctions;
		
		if (inContainer(sigmoidFunctions, funcName))
			return sigmoidFunctions;
		
		if (inContainer(sinusoidFunctions, funcName))
			return sinusoidFunctions;
		
		if (inContainer(squareRootFunctions, funcName))
			return squareRootFunctions;
		
		if (inContainer(staircaseFunctions, funcName))
			return staircaseFunctions;
		
		if (inContainer(stepFunctions, funcName))
			return stepFunctions;
		
		if (inContainer(windowFunctions, funcName))
			return windowFunctions;
		
		return null;
	}
	
	public float function(String funcName, boolean clamp, float x, float a, float b, float c, float d, int n) {
		FunctionContainer functionContainer = findContainer(funcName);
		
		if (functionContainer == null)
			return 0;
		
		return functionContainer.function(funcName, clamp, x, a, b, c, d, n);
	}
	
	public float function(String funcName, float x, float a, float b, float c, float d, int n) {
		return function(funcName, false, x, a, b, c, d, n);
	}
}

