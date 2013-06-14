package shapingfunctions.functions.circular;

import processing.core.PApplet;
import processing.core.PConstants;
import shapingfunctions.library.Function;

public class CircularArcThroughAPoint extends Function {
	private float a, b;

	private float m_Centerx;
	private float m_Centery;
	private float m_dRadius;

	public CircularArcThroughAPoint() {
		super();

		this.a = this.b = 0;
	}

	public CircularArcThroughAPoint(float a, float b) {
		super();

		this.a = a;
		this.b = b;
	}

	private boolean isPerpendicular(float pt1x, float pt1y, float pt2x,
			float pt2y, float pt3x, float pt3y) {
		// Check the given point are perpendicular to x or y axis
		float yDelta_a = pt2y - pt1y;
		float xDelta_a = pt2x - pt1x;
		float yDelta_b = pt3y - pt2y;
		float xDelta_b = pt3x - pt2x;

		// checking whether the line of the two pts are vertical
		if (Float.compare(PApplet.abs(xDelta_a), PConstants.EPSILON) <= 0
				&& Float.compare(PApplet.abs(yDelta_b), PConstants.EPSILON) <= 0) {
			return false;
		}
		if (Float.compare(PApplet.abs(yDelta_a), PConstants.EPSILON) <= 0) {
			return true;
		}
		if (Float.compare(PApplet.abs(yDelta_b), PConstants.EPSILON) <= 0) {
			return true;
		}
		if (Float.compare(PApplet.abs(xDelta_a), PConstants.EPSILON) <= 0) {
			return true;
		}
		if (Float.compare(PApplet.abs(xDelta_b), PConstants.EPSILON) <= 0) {
			return true;
		}

		return false;
	}

	private void calcCircleFrom3Points(float pt1x, float pt1y, float pt2x,
			float pt2y, float pt3x, float pt3y) {
		float yDelta_a = pt2y - pt1y;
		float xDelta_a = pt2x - pt1x;
		float yDelta_b = pt3y - pt2y;
		float xDelta_b = pt3x - pt2x;

		if (Float.compare(PApplet.abs(xDelta_a), PConstants.EPSILON) <= 0
				&& Float.compare(PApplet.abs(yDelta_b), PConstants.EPSILON) <= 0) {
			m_Centerx = 0.5f * (pt2x + pt3x);
			m_Centery = 0.5f * (pt1y + pt2y);
			m_dRadius = PApplet.sqrt(PApplet.sq(m_Centerx - pt1x)
					+ PApplet.sq(m_Centery) - pt1y);
			return;
		}

		// isPerpendicular() assure that xDelta(s) are not zero
		float aSlope = yDelta_a / xDelta_a;
		float bSlope = yDelta_b / xDelta_b;
		if (Float.compare(PApplet.abs(aSlope - bSlope), PConstants.EPSILON) <= 0) {
			// checking whether the given points are colinear
			return;
		}

		// calc center
		m_Centerx = (aSlope * bSlope * (pt1y - pt3y) + bSlope * (pt1x + pt2x) - aSlope
				* (pt2x + pt3x))
				/ (2 * (bSlope - aSlope));
		m_Centery = -1 * (m_Centerx - (pt1x + pt2x) / 2.0f) / aSlope
				+ (pt1y + pt2y) / 2.0f;
		m_dRadius = PApplet.sqrt(PApplet.sq(m_Centerx - pt1x)
				+ PApplet.sq(m_Centery - pt1y));
	}

	@Override
	public float applyFunction(float x, boolean clamp) {
		// Adapted from Paul Bourke

		float min_param_a = 0.0f + PConstants.EPSILON;
		float max_param_a = 1.0f - PConstants.EPSILON;
		float min_param_b = 0.0f + PConstants.EPSILON;
		float max_param_b = 1.0f - PConstants.EPSILON;
		float fa = PApplet.constrain(a, min_param_a, max_param_a);
		float fb = PApplet.constrain(b, min_param_b, max_param_b);
		x = PApplet
				.constrain(x, 0 + PConstants.EPSILON, 1 + PConstants.EPSILON);

		float pt1x = 0;
		float pt1y = 0;
		float pt2x = fa;
		float pt2y = fb;
		float pt3x = 1;
		float pt3y = 1;

		if (!isPerpendicular(pt1x, pt1y, pt2x, pt2y, pt3x, pt3y))
			calcCircleFrom3Points(pt1x, pt1y, pt2x, pt2y, pt3x, pt3y);
		else if (!isPerpendicular(pt1x, pt1y, pt3x, pt3y, pt2x, pt2y))
			calcCircleFrom3Points(pt1x, pt1y, pt3x, pt3y, pt2x, pt2y);
		else if (!isPerpendicular(pt2x, pt2y, pt1x, pt1y, pt3x, pt3y))
			calcCircleFrom3Points(pt2x, pt2y, pt1x, pt1y, pt3x, pt3y);
		else if (!isPerpendicular(pt2x, pt2y, pt3x, pt3y, pt1x, pt1y))
			calcCircleFrom3Points(pt2x, pt2y, pt3x, pt3y, pt1x, pt1y);
		else if (!isPerpendicular(pt3x, pt3y, pt2x, pt2y, pt1x, pt1y))
			calcCircleFrom3Points(pt3x, pt3y, pt2x, pt2y, pt1x, pt1y);
		else if (!isPerpendicular(pt3x, pt3y, pt1x, pt1y, pt2x, pt2y))
			calcCircleFrom3Points(pt3x, pt3y, pt1x, pt1y, pt2x, pt2y);
		else {
			return 0;
		}
		
		//----------------
		// constrain
		if ((m_Centerx > 0) && (m_Centerx <1)) {
			if (a < m_Centerx) {
				m_Centerx = 1;
				m_Centery = 0;
				m_dRadius = 1;
			}
			else {
				m_Centerx = 0;
				m_Centery = 1;
				m_dRadius = 1;
			}
		}
		
		//----------------
		float y = 0;
		if (Float.compare(x, m_Centerx) >= 0) {
			y = m_Centery - PApplet.sqrt(PApplet.sq(m_dRadius) - PApplet.sq(x-m_Centerx));
		}
		else {
			y = m_Centery + PApplet.sqrt(PApplet.sq(m_dRadius) - PApplet.sq(x-m_Centerx));
		}
		
		return clamp(y, clamp);
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

}
