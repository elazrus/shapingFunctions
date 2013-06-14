package shapingfunctions.functions.ogee;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class DoubleEllipticOgee extends Function {
	private float a, b;
	
	public DoubleEllipticOgee() {
		super();

		this.a = this.b = 0;
	}
	
	public DoubleEllipticOgee(float a, float b) {
		super();
		
		this.a = a;
		this.b = b;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		
		float y = 0;
		if (Float.compare(x, fa) <= 0) {
			y = (b / fa) * PApplet.sqrt(PApplet.sq(fa) - PApplet.sq(x-fa));
		}
		else {
			y = 1.0f - ((1.0f-b)/(1.0f-fa))*PApplet.sqrt(PApplet.sq(1.0f-fa) - PApplet.sq(x-fa));
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

}
