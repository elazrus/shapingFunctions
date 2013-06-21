package shapingfunctions.functions.sigmoid;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class DoublePolynomialSigmoid extends Function {
	private int n;
	
	public DoublePolynomialSigmoid() {
		this(0);
	}
	
	public DoublePolynomialSigmoid(int n) {
		super();
		
		this.n = n;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = 0;
		if (n%2 == 0) {
			// even polynomial
			if (Float.compare(x, 0.5f) <= 0) {
				y = PApplet.pow(2.0f*x, n) / 2.0f;
			}
			else {
				y = 1.0f - PApplet.pow(2.0f*(x-1.0f), n) / 2.0f;
			}
		}
		else {
			// odd polynomial
			if (Float.compare(x, 0.5f) <= 0) {
				y = PApplet.pow(2.0f*x, n) / 2.0f;
			}
			else {
				y = 1.0f + PApplet.pow(2.0f*(x-1.0f), n) / 2.0f;
			}
		}
		
		return clamp(y, clamp);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
