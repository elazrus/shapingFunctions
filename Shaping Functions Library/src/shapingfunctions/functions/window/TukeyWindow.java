package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class TukeyWindow extends Function {
	private float a;
	
	public TukeyWindow() {
		super();
			
		this.a = 0;
	}
	
	public TukeyWindow(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Window_function 
		// The Tukey window, also known as the tapered cosine window, 
		// can be regarded as a cosine lobe of width \tfrac{\alpha N}{2} 
		// that is convolved with a rectangle window of width \left(1 -\tfrac{\alpha}{2}\right)N.  
		// At alpha=0 it becomes rectangular, and at alpha=1 it becomes a Hann window.
		
		float ah = a / 2.0f;
		float omah = 1.0f - ah;
		
		float y = 1.0f;
		if (Float.compare(x, ah) <= 0) {
			y = 0.5f * (1.0f + PApplet.cos(PConstants.PI * ((2*x / a) - 1.0f)));
		}
		else if (x > omah) {
			y = 0.5f * (1.0f + PApplet.cos((PConstants.PI * (2*x / a) - (2.0f/a) + 1.0f)));
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
