package shapingfunctions.library;

public abstract class Function {
	
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
