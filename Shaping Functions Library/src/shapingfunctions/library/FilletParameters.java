package shapingfunctions.library;

import processing.core.PApplet;

public class FilletParameters {
	private float arcStartAngle;
	private float arcEndAngle;
	private float arcStartX, arcStartY;
	private float arcEndX, arcEndY;
	private float arcCenterX, arcCenterY;
	private float arcRadius;
	
	public FilletParameters() {
		this.arcStartAngle = this.arcEndAngle = this.arcStartX = this.arcStartY = 
				this.arcEndX = this.arcEndY = this.arcCenterX = this.arcCenterY = this.arcRadius = 0;
	}
	
	private float linetopoint(float a, float b, float c, float ptx, float pty) {
		// Return signed distance from line Ax + By + C = 0 to point P.

		float lp = 0.0f;
		float d = PApplet.sqrt((a * a) + (b * b));
		if (Float.compare(d, 0) != 0) {
			lp = (a * ptx + b * pty + c) / d;
		}
		return lp;
	}

	public void computeFilletParameters(float p1x, float p1y, float p2x,
			float p2y, float p3x, float p3y, float p4x, float p4y, float r) {
		// Compute the paramters of a circular arc fillet between lines L1 (p1
		// to p2) and L2 (p3 to p4) with radius R.

		float c1 = p2x * p1y - p1x * p2y;
		float a1 = p2y - p1y;
		float b1 = p1x - p2x;
		float c2 = p4x * p3y - p3x * p4y;
		float a2 = p4y - p3y;
		float b2 = p3x - p4x;
		if (Float.compare((a1 * b2), (a2 * b1)) == 0) {
			/* Parallel or coincident lines */
			return;
		}

		float d1, d2;
		float mPx, mPy;
		mPx = (p3x + p4x) / 2.0f;
		mPy = (p3y + p4y) / 2.0f;
		d1 = linetopoint(a1, b1, c1, mPx, mPy); /* Find distance p1p2 to p3 */
		if (Float.compare(d1, 0) == 0) {
			return;
		}
		mPx = (p1x + p2x) / 2.0f;
		mPy = (p1y + p2y) / 2.0f;
		d2 = linetopoint(a2, b2, c2, mPx, mPy); /* Find distance p3p4 to p2 */
		if (Float.compare(d2, 0) == 0) {
			return;
		}

		float c1p, c2p, d;
		float rr = r;
		if (Float.compare(d1, 0) <= 0) {
			rr = -rr;
		}
		c1p = c1 - rr * PApplet.sqrt((a1 * a1) + (b1 * b1)); /* Line parallel l1 at d */
		rr = r;
		if (Float.compare(d2, 0) <= 0) {
			rr = -rr;
		}
		c2p = c2 - rr * PApplet.sqrt((a2 * a2) + (b2 * b2)); /* Line parallel l2 at d */
		d = (a1 * b2) - (a2 * b1);

		float pCx = (c2p * b1 - c1p * b2) / d; /* Intersect constructed lines */
		float pCy = (c1p * a2 - c2p * a1) / d; /* to find center of arc */
		float pAx = 0;
		float pAy = 0;
		float pBx = 0;
		float pBy = 0;
		float dP, cP;

		dP = (a1 * a1) + (b1 * b1); /* Clip or extend lines as required */
		if (Float.compare(dP, 0) != 0) {
			cP = a1 * pCy - b1 * pCx;
			pAx = (-a1 * c1 - b1 * cP) / dP;
			pAy = (a1 * cP - b1 * c1) / dP;
		}
		dP = (a2 * a2) + (b2 * b2);
		if (Float.compare(dP, 0) != 0) {
			cP = a2 * pCy - b2 * pCx;
			pBx = (-a2 * c2 - b2 * cP) / dP;
			pBy = (a2 * cP - b2 * c2) / dP;
		}

		float gv1x = pAx - pCx;
		float gv1y = pAy - pCy;
		float gv2x = pBx - pCx;
		float gv2y = pBy - pCy;

		float arcStart = (float) PApplet.atan2(gv1y, gv1x);
		float arcAngle = 0.0f;
		float dd = (float) PApplet.sqrt(((gv1x * gv1x) + (gv1y * gv1y))
				* ((gv2x * gv2x) + (gv2y * gv2y)));
		if (Float.compare(dd, 0) != 0) {
			arcAngle = (PApplet.acos((gv1x * gv2x + gv1y * gv2y) / dd));
		}
		float crossProduct = (gv1x * gv2y - gv2x * gv1y);
		if (crossProduct < 0.0) {
			arcStart -= arcAngle;
		}

		float arc1 = arcStart;
		float arc2 = arcStart + arcAngle;
		if (crossProduct < 0.0) {
			arc1 = arcStart + arcAngle;
			arc2 = arcStart;
		}

		arcCenterX = pCx;
		arcCenterY = pCy;
		arcStartAngle = arc1;
		arcEndAngle = arc2;
		arcRadius = r;
		arcStartX = arcCenterX + arcRadius * PApplet.cos(arcStartAngle);
		arcStartY = arcCenterY + arcRadius * PApplet.sin(arcStartAngle);
		arcEndX = arcCenterX + arcRadius * PApplet.cos(arcEndAngle);
		arcEndY = arcCenterY + arcRadius * PApplet.sin(arcEndAngle);
	}
	
	public float getArcStartAngle() {
		return this.arcStartAngle;
	}
	
	public float getArcEndAngle() {
		return this.arcEndAngle;
	}

	public float getArcStartX() {
		return this.arcStartX;
	}
	
	public float getArcStartY() {
		return this.arcStartY;
	}
	
	public float getArcEndX() {
		return this.arcEndX;
	}
	
	public float getArcEndY() {
		return this.arcEndY;
	}
	
	public float getArcCenterX() {
		return this.arcCenterX;
	}
	
	public float getArcCenterY() {
		return this.arcCenterY;
	}
	
	public float getArcRadius() {
		return this.arcRadius;
	}
}