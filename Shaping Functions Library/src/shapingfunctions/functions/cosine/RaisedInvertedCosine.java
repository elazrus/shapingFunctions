package shapingfunctions.functions.cosine;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class RaisedInvertedCosine extends Function {

	public RaisedInvertedCosine() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float y = (1.0f - PApplet.cos(PConstants.PI*x)) / 2.0f;
		
		return clamp(y, clamp);
	}

}
