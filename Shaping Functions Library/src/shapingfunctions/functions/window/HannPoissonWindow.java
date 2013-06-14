package shapingfunctions.functions.window;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class HannPoissonWindow extends Function {
	private float a;
	
	public HannPoissonWindow() {
		super();
			
		this.a = 0;
	}
	
	public HannPoissonWindow(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		
		float epsilon = 0.00001f;
		float tau = PApplet.max(a, epsilon);
		
		float y = PApplet.exp(0.0f - (PApplet.abs(x - 0.5f)) * (1.0f/tau));
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
