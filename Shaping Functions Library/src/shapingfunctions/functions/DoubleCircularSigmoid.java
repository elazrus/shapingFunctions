package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DoubleCircularSigmoid extends Function {
	private float a;
	
	public DoubleCircularSigmoid(PApplet applet) {
		super(applet);

		this.a = 0;
	}
	
	public DoubleCircularSigmoid(PApplet applet, float a) {
		super(applet);
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		if (Float.compare(x, a) <= 0) {
			y = a - PApplet.sqrt(a*a - x*x);
		}
		else {
			y = a + PApplet.sqrt(PApplet.sq(1.0f-a) - PApplet.sq(x-1.0f));
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
