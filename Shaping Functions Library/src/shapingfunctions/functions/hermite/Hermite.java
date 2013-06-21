package shapingfunctions.functions.hermite;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class Hermite extends Function {
	private float a, b, c, d;
	
	public Hermite() {
		this(0, 0, 0, 0);
	}
	
	public Hermite(float a, float b, float c, float d) {
		super();
		
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float fa = PApplet.map(a, 0.0f, 1.0f, -1.0f, 1.0f);
		float fc = PApplet.map(c, 0.0f, 1.0f, -1.0f, 1.0f);
		
		float hC = (fc- fa) * 0.5f;
		float hV = (b - d);
		float hW = hC + hV;
		float hA = hW + hV + (fc - b) * 0.5f;
		float hB = hW + hA;
		
		float y = ((((hA*x) - hB) * x + hC) * x + b);
		
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

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}

}
