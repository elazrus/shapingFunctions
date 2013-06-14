package shapingfunctions.functions.penner;

import processing.core.PApplet;
import shapingfunctions.library.Function;

public class PennerEaseInBounce extends Function {

	public PennerEaseInBounce(PApplet applet) {
		super(applet);
	}
	
	@Override
	public float applyFunction(float x, boolean clamp) {
		PennerEaseOutBounce pennerEaseOutBounce = new PennerEaseOutBounce(applet);
		float y = 1.0f - pennerEaseOutBounce.applyFunction(1.0f - x);
		
		return clamp(y, clamp);
	}
}
