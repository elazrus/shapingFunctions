package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class Staircase extends Function {
	private int n;
	
	public Staircase(PApplet applet) {
		super(applet);
		
		this.n = 0;
	}
	
	public Staircase(PApplet applet, int n) {
		super(applet);
		
		this.n = n;
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = PApplet.floor(x*n) / (float)(n-1);
		
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
