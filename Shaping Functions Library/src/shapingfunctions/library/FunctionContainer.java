package shapingfunctions.library;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

public abstract class FunctionContainer {
	protected HashMap<String, Method> functions;
	protected int numFunctions;

	public FunctionContainer() {
		functions = new HashMap<String, Method>();
		numFunctions = 0;

		try {
			String fullClassName = this.getClass().getName();
			Class<?> myClassName = Class.forName(fullClassName);

			Method[] methods = myClassName.getMethods();

			if (methods.length > 0) {
				for (int i = 0; i < methods.length; i++) {
					Method m = methods[i];
					Type[] paramTypes = m.getGenericExceptionTypes();
					if (paramTypes.length > 0) {
						Type lastParamType = paramTypes[paramTypes.length - 1];
						if (lastParamType.toString().equals("boolean")) {
							functions.put(m.getName(), m);
						}
					}
				}
				numFunctions = functions.size();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private int getNumFunctionArgs(Method method) {
		Type[] params = method.getGenericParameterTypes();
		return params.length;
	}

	private boolean functionHasIntegerArg(Method method) {
		Type[] params = method.getGenericParameterTypes();
		int nParams = params.length;

		for (int i = 0; i < nParams; i++) {
			if (params[i].toString().equals("int")) {
				return true;
			}
		}

		return false;
	}
	
	public float function(String funcName, boolean clamp, float x, float a, float b, float c, float d, int n) {
		float out = 0;

		Method func = functions.get(funcName);
		
		if (func == null) {
			System.out.println("Function '" + funcName + "' not found in " + this.getClass().getName());
		}

		if (func != null) {

			int numParams = getNumFunctionArgs(func) - 1;
			boolean hasIntArg = functionHasIntegerArg(func);

			try {
				Float F = 0.0f;

				if (hasIntArg) {
					switch (numParams) {
					case 2:
						F = (Float) func.invoke(this, x, n, clamp);
						break;
					case 3:
						F = (Float) func.invoke(this, x, a, n, clamp);
						break;
					case 4:
						F = (Float) func.invoke(this, x, a, b, n, clamp);
						break;
					case 5:
						F = (Float) func.invoke(this, x, a, b, c, n, clamp);
						break;
					case 6:
						F = (Float) func.invoke(this, x, a, b, c, d, n, clamp);
						break;
					}
				} else {
					switch (numParams) {
					case 1:
						F = (Float) func.invoke(this, x, clamp);
						break;
					case 2:
						F = (Float) func.invoke(this, x, a, clamp);
						break;
					case 3:
						F = (Float) func.invoke(this, x, a, b, clamp);
						break;
					case 4:
						F = (Float) func.invoke(this, x, a, b, c, clamp);
						break;
					case 5:
						F = (Float) func.invoke(this, x, a, b, c, d, clamp);
						break;
					}
				}

				out = F.floatValue();
			} catch (Exception e) {
				System.out.println("Problem calling method: " + func.getName());
				System.out.println(e + ": " + e.getMessage());
				e.printStackTrace();
				System.out.println(e.getCause().getMessage());
			}
		}
		
		return out;
	}
	
	public float function(String funcName, float x, float a, float b, float c, float d, int n) {
		return function(funcName, false, x, a, b, c, d, n);
	}
}
