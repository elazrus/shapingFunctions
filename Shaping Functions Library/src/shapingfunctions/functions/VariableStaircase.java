package shapingfunctions.functions;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class VariableStaircase extends Function {
	private float a;
	private int n;
	
	public VariableStaircase(PApplet applet) {
		super(applet);

		this.a = 0;
		this.n = 0;
	}
	
	public VariableStaircase(PApplet applet, float a, int n) {
		super(applet);
		
		this.a = a;
		this.n = n;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float aa = (a - 0.5f);
		if (Float.compare(aa, 0.0f) == 0) return clamp(x, clamp);
		
		float x0 = (PApplet.floor(x*n)) / (float)n;
		float x1 = (PApplet.ceil(x*n)) / (float)n;
		float y0 = x0;
		float y1 = x1;
		
		float px = 0.5f*(x0+x1) + aa/(float)n;
		float py = 0.5f*(x0+x1) - aa/(float)n;
		
		float y = 0;
		if ((x < px) && (x > x0)) {
			y = PApplet.map(x, x0, px, y0, py);
		}
		else {
			y = PApplet.map(x, px, x1, py, y1);
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
