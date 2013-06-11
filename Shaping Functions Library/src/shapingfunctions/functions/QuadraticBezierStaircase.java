package shapingfunctions.functions;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class QuadraticBezierStaircase extends Function {
	private float a;
	private int n;
	
	public QuadraticBezierStaircase(PApplet applet) {
		super(applet);

		this.a = 0;
		this.n = 0;
	}
	
	public QuadraticBezierStaircase(PApplet applet, float a, int n) {
		super(applet);
		
		this.a = a;
		this.n = n;
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		float aa = (a - 0.5f);
		if (((Float)x).equals(0)) {
			return clamp(x, clamp);
		}
		
		float x0 = (PApplet.floor(x*n)) / (float)n;
		float x1 = (PApplet.ceil(x*n)) / (float)n;
		float y0 = x0;
		float y1 = x1;
		
		float px = 0.5f*(x0+x1) + aa/(float)n;
		float py = 0.5f*(x0+x1) - aa/(float)n;
		
		float p0x = (x0 + px) / 2.0f;
		float p0y = (y0 + py) / 2.0f;
		float p1x = (x1 + px) / 2.0f;
		float p1y = (y1 + py) / 2.0f;
		
		float y = 0;
		float denom = (1.0f/(float)n) * 0.5f;
		
		if ((x < p0x || ((Float)x).equals(p0x)) &&
				(x > x0 || ((Float)x).equals(x0))) {
			// left side
			if (PApplet.floor(x*n) <= 0) {
				y = PApplet.map(x, x0, px, y0, py);
			}
			else {
				
				if (PApplet.abs(x - x0) < PConstants.EPSILON) {
					// problem when x == x0!
				}
				
				float za = (x0 - (p1x - 1.0f/(float)n)) / denom;
				float zb = (y0 - (p1y - 1.0f/(float)n)) / denom;
				float zx = (x - (p1x - 1.0f/(float)n)) / denom;
				float om2a = 1.0f - 2.0f*za;
				
				float interior = PApplet.max(0, za*za + om2a*zx);
				float t = (PApplet.sqrt(interior) - za) / om2a;
				float zy = (1.0f-2.0f*zb)*(t*t) + (2.0f*zb)*t;
				zy *= (p1y - p0y);
				zy += p1y;
				if (x > x0) {
					zy -= 1.0f/(float)n;
				}
				
				y = zy;
			}
		}
		else if ((x > p1x || ((Float)x).equals(p1x)) &&
				(x < x1 || ((Float)x).equals(x1))) {
			// right side
			if (PApplet.ceil(x*n) >= n) {
				y = PApplet.map(x, px, x1, py, y1);
			}
			else {
				
				if (PApplet.abs(x - x1) < PConstants.EPSILON) {
					// problem when x == x1 !
				}
				
				float za = (x1 - p1x) / denom;
				float zb = (y1 - p1y) / denom;
				float zx = (x - p1x) / denom;
				if (((Float)za).equals(0.5f)) {
					za += PConstants.EPSILON;
				}
				
				float om2a = 1.0f - 2.0f*za;
				if (PApplet.abs(om2a) < PConstants.EPSILON) {
					om2a = ((om2a < 0) ? -1 : 1) * PConstants.EPSILON;
				}
				
				float interior = PApplet.max(0, za*za + om2a*zx);
				float t = (PApplet.sqrt(interior) - za) / om2a;
				float zy = (1.0f-2.0f*zb)*(t*t) + (2*zb)*t;
				zy *= (p1y - p0y);
				zy += p1y;
				y = zy;
			}
		}
		else {
			// center
			float za = (px - p0x) / denom;
			float zb = (py - p0y) / denom;
			float zx = (x - p0x) / denom;
			if (((Float)za).equals(0.5f)) {
				za += PConstants.EPSILON;
			}
			
			float om2a = 1.0f - 2.0f*za;
			float t = (PApplet.sqrt(za*za + om2a*zx) - za) / om2a;
			float zy = (1.0f-2.0f*zb)*(t*t) + (2.0f*zb)*t;
			zy *= (p1y - p0y);
			zy += p0y;
			y = zy;
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
