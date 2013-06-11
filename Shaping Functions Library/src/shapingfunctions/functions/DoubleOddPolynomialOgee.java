package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class DoubleOddPolynomialOgee extends Function {
	private float a, b;
	private int n;
	
	public DoubleOddPolynomialOgee(PApplet applet) {
		super(applet);

		this.a = this.b = 0;
		this.n = 0;
	}

	public DoubleOddPolynomialOgee(PApplet applet, float a, float b, int n) {
		super(applet);
		
		this.a = a;
		this.b = b;
		this.n = n;
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f;
		float max_param_b = 1.0f;
		
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		int p = 2*n + 1;
		
		float y = 0;
		if (x < fa || ((Float)x).equals(fa)) {
			y = fb - fb*PApplet.pow(1-x/fa, p);
		}
		else {
			y = fb + (1-fb)*PApplet.pow((x-fa)/(1.0f-fa), p);
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

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
