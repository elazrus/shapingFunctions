package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInOutBounce extends Function {

	public PennerEaseInOutBounce(PApplet applet) {
		super(applet);
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		float y;
		
		if (x < 0.5f) {
			PennerEaseInBounce pennerEaseInBounce = new PennerEaseInBounce(applet);
			y = pennerEaseInBounce.applyFunction(x*2) * 0.5f;
		}
		else {
			PennerEaseOutBounce pennerEaseOutBounce = new PennerEaseOutBounce(applet);
			y = pennerEaseOutBounce.applyFunction(x*2-1) * 0.5f + 0.5f;
		}
		
		return clamp(y, clamp);
	}
}
