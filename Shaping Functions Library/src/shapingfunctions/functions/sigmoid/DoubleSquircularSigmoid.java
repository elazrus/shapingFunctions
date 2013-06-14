package shapingfunctions.functions.sigmoid;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DoubleSquircularSigmoid extends Function {
	private float a;
	private int n;
	
	public DoubleSquircularSigmoid(PApplet applet) {
		super(applet);

		this.a = 0;
		this.n = 0;
	}
	
	public DoubleSquircularSigmoid(PApplet applet, float a, int n) {
		super(applet);
		
		this.a = a;
		this.n = n;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float pwn = PApplet.mag(2.0f, n * 2.0f);
		float y = 0;
		if (Float.compare(x, a) <= 0) {
			y = a - PApplet.pow(PApplet.pow(a, pwn) - PApplet.pow(x, pwn), 1.0f/pwn);
		}
		else {
			y = a + PApplet.pow(PApplet.pow(1.0f-a, pwn) - PApplet.pow(x - 1.0f, pwn), 1.0f/pwn);
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
