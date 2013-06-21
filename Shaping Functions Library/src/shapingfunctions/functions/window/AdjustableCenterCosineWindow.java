package shapingfunctions.functions.window;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class AdjustableCenterCosineWindow extends Function {
	private float a;
	
	public AdjustableCenterCosineWindow() {
		this(0);
	}
	
	public AdjustableCenterCosineWindow(float a) {
		super();
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float ah = a /2.0f;
		float omah = 1.0f - ah;
		
		float y = 1.0f;
		if (Float.compare(x, a) <= 0) {
			y = 0.5f * (1.0f + PApplet.cos(PConstants.PI * ((x/a) - 1.0f)));
		}
		else if (x > omah) {
			y = 0.5f * (1.0f + PApplet.cos(PConstants.PI * (((x-a)/(1.0f-a)))));
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

}
