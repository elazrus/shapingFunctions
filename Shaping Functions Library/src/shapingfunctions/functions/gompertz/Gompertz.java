package shapingfunctions.functions.gompertz;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class Gompertz extends Function {
	private float a;
	
	public Gompertz() {
		super();
		
		this.a = 0;
	}
	
	public Gompertz(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://en.wikipedia.org/wiki/Gompertz_curve
		float min_param_a = 0.0f + PConstants.EPSILON;
		a = PApplet.max(a, min_param_a);
		
		float b = -8.0f;
		float c = 0 - a*16.0f;
		float y = PApplet.exp(b * PApplet.exp(c * x));
		
		float maxVal = PApplet.exp((b * PApplet.exp(c)));
		float minVal = PApplet.exp(b);
		y = PApplet.map(y, minVal, maxVal, 0, 1);
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
