package shapingfunctions.functions.staircase;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class Staircase extends Function {
	private int n;
	
	public Staircase() {
		this(0);
	}
	
	public Staircase(int n) {
		super();
		
		this.n = n;
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = PApplet.floor(x*n) / (float)(n-1);
		
		return clamp(y, clamp);
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
