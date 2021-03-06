package shapingfunctions.functions.staircase;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class ExponentialSmoothedStaircase extends Function {
	private float a;
	private int n;
	
	public ExponentialSmoothedStaircase() {
		this(0, 0);
	}
	
	public ExponentialSmoothedStaircase(float a, int n)  {
		super();
		
		this.a = a;
		this.n = n;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// See http://web.mit.edu/fnl/volume/204/winston.html
		
		float fa = PApplet.sq(PApplet.map(a, 0, 1, 5, 30));
		float y = 0;
		for (int i=0; i < n; i++) {
			y += (1.0f/((float)n-1.0f)) / (1.0f + PApplet.exp(fa * ((((float)i + 1.0f) / (float)n) - x)));
		}
		y = PApplet.constrain(y, 0, 1);
		
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
