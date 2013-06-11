package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class AdjustableCenterHyperellipticWindow extends Function {
	private float a;
	private int n;
	
	public AdjustableCenterHyperellipticWindow(PApplet applet) {
		super(applet);

		this.a = 0;
		this.n = 0;
	}
	
	public AdjustableCenterHyperellipticWindow(PApplet applet, float a, int n) {
		super(applet);
		
		this.a = a;
		this.n = n;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		
		float y = 0;
		float pwn = n * 2.0f;
		
		if (Float.compare(x, fa) <= 0) {
			y = (1.0f/fa) * PApplet.pow(PApplet.pow(fa, pwn) - PApplet.pow(x-fa, pwn), 1.0f/pwn);
		}
		else {
			y = (1.0f / (1.0f - fa)) * PApplet.pow(PApplet.pow(1.0f-fa, pwn) - PApplet.pow(x-fa, pwn), 1.0f/pwn);
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
