package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class GeneralizedTriangleWindow extends Function {
	private float a;
	
	public GeneralizedTriangleWindow(PApplet applet) {
		super(applet);
			
		this.a = 0;
	}
	
	public GeneralizedTriangleWindow(PApplet applet, float a) {
		super(applet);
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		float y = 0 ;
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		
		if (x < fa) {
			y = (x / fa);
		}
		else {
			y = 1.0f - ((x-fa)/(1.0f-fa));
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
