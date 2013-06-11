package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class AdjustableCenterEllipticWindow extends Function {
	private float a;
	
	public AdjustableCenterEllipticWindow(PApplet applet) {
		super(applet);

		this.a = 0;
	}
	
	public AdjustableCenterEllipticWindow(PApplet applet, float a) {
		super(applet);
		
		this.a = a;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f + PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		
		float y = 0;
		if (Float.compare(x, fa) <= 0) {
			y = (1.0f/fa) * PApplet.sqrt(PApplet.sq(fa) - PApplet.sq(x-fa));
		}
		else {
			y = (1.0f/(1.0f-fa)) * PApplet.sqrt(PApplet.sq(1.0f-fa) - PApplet.sq(x-fa)); 
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
