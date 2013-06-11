package shapingfunctions.library;

import processing.core.PApplet;

public abstract class Function {
	protected PApplet applet;
	
	public Function(PApplet applet) {
		this.applet = applet;
	}
	
	public abstract float applyFunction(float x, boolean clamp);
	
	public float applyFunction(float x) {
		return applyFunction(x, false);
	}
	
	protected float clamp(float y, boolean clamp) {
		if (clamp) {
			if (y < 0) return 0;
			if (y > 1) return 1;
		}
		
		return y;
	}
}
