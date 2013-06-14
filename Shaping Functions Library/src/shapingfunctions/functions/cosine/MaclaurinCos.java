package shapingfunctions.functions.cosine;

import processing.core.PConstants;
import shapingfunctions.library.Function;

public class MaclaurinCos extends Function {

	public MaclaurinCos() {
		super();
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// http://blogs.ubc.ca/infiniteseriesmodule/units/unit-3-power-series/taylor-series/the-maclaurin-expansion-of-cosx/

		int nTerms = 6; // anything else is fouled
		
		x *= PConstants.PI;
		float xp = 1.0f;
		float x2 = x*x;
		
		float sig = 1.0f;
		float fact = 1.0f;
		float out = xp;
		
		for (int i=0; i < nTerms; i++) {
			xp *= x2;
			sig = 0.0f-sig;
			fact *= (i*2.0f+1.0f);
			fact *= (i*2.0f+2.0f);
			out += sig * (xp / fact);
		}
		
		float y = (1.0f - out) / 2.0f;
		
		return clamp(y, clamp);
	}

}
