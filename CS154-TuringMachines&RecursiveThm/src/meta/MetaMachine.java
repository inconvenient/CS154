package meta;

import java.lang.reflect.*;
import java.util.Arrays;

public class MetaMachine {

	public String execute(String... args) throws Exception {

		// [0] = class name, [1] = method name, remaining = param of method
		String className = args[0];
		String methodName = args[1];
		
		// Create new class and create new instance of it at runtime
		Class input = Class.forName(className);
		Object obj = input.newInstance();

		// Find the method in the class
		Method method = obj.getClass().getDeclaredMethod(methodName, String[].class);
		
		// Make a subArray of the params to pass into invoke
		String[] invokeParams = new String[args.length];
		invokeParams = Arrays.copyOfRange(args, 2, args.length);
		
		// Invoke method
		method.invoke(obj, (Object)invokeParams);

		return "done";
	}
}