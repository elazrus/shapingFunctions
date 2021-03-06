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

	public final BezierFunctionContainer bezierFunctions = new BezierFunctionContainer();
	public final CircularFunctionContainer circularFunctions = new CircularFunctionContainer();
	public final CosineFunctionContainer cosineFunctions = new CosineFunctionContainer();
	public final ErrorFunctionContainer errorFunctions = new ErrorFunctionContainer();
	public final ExponentFunctionContainer exponentFunctions = new ExponentFunctionContainer();
	public final GaussianFunctionContainer gaussianFunctions = new GaussianFunctionContainer();
	public final GompertzFunctionContainer gompertzFunctions = new GompertzFunctionContainer();
	public final HermiteFunctionContainer hermiteFunctions = new HermiteFunctionContainer();
	public final InterpolationFunctionContainer interpolationFunctions = new InterpolationFunctionContainer();
	public final LinearFunctionContainer linearFunctions = new LinearFunctionContainer();
	public final OgeeFunctionContainer ogeeFunctions = new OgeeFunctionContainer();
	public final ParabolaFunctionContainer parabolaFunctions = new ParabolaFunctionContainer();
	public final PennerFunctionContainer pennerFunctions = new PennerFunctionContainer();
	public final SigmoidFunctionContainer sigmoidFunctions = new SigmoidFunctionContainer();
	public final SinusoidFunctionContainer sinusoidFunctions = new SinusoidFunctionContainer();
	public final SquareRootFunctionContainer squareRootFunctions = new SquareRootFunctionContainer();
	public final StaircaseFunctionContainer staircaseFunctions = new StaircaseFunctionContainer();
	public final StepFunctionContainer stepFunctions = new StepFunctionContainer();
	public final WindowFunctionContainer windowFunctions = new WindowFunctionContainer();
	
	public final FunctionContainer[] allContainers = {bezierFunctions, circularFunctions, cosineFunctions, errorFunctions,
			exponentFunctions, gaussianFunctions, gompertzFunctions, hermiteFunctions, interpolationFunctions, linearFunctions,
			ogeeFunctions, parabolaFunctions, pennerFunctions, sigmoidFunctions, sinusoidFunctions, squareRootFunctions,
			staircaseFunctions, stepFunctions, windowFunctions}; 
	
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
		for (FunctionContainer fc : allContainers) {
			if (inContainer(fc, funcName))
				return fc;
		}
		
		return null;
	}
	
	public int getNumFunctionArgs(String funcName) {
		FunctionContainer functionContainer = findContainer(funcName);
		
		if (functionContainer == null) 
			return 0;
		
		return functionContainer.getNumFunctionArgs(funcName);
	}
	
	public boolean functionHasIntegerArg(String funcName) {
		FunctionContainer functionContainer = findContainer(funcName);
		
		if (functionContainer == null) 
			return false;
		
		return functionContainer.functionHasIntegerArg(funcName);
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

