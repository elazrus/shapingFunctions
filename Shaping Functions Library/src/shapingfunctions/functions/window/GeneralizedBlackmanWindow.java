package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class GeneralizedBlackmanWindow extends Function {
	private float a;
	
	public GeneralizedBlackmanWindow() {
		super();
			
		this.a = 0;
	}
	
	public GeneralizedBlackmanWindow(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		float a0 = (1.0f - a) / 2.0f;
		float a1 = 0.5f;
		float a2 = a / 2.0f;
		
		float pix = PConstants.PI*x;
		float y = a0 - a1*PApplet.cos(2*pix) + a2*PApplet.cos(4*pix);
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
