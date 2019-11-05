package fr.training.spring;

import java.io.Serializable;
import java.util.stream.Stream;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author par Gauthier Peel
 */
public class TraceInterceptor implements MethodInterceptor, Serializable {

	/**
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(MethodInvocation)
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = invocation.getMethod().getName();

		Object[] objects = invocation.getArguments();
		Stream.of(objects).forEach(item -> System.out.println("args are: " + item));

		System.out.println("ENTERING " + methodName + "()");
		long debut = System.currentTimeMillis();
		Object rval = invocation.proceed();
		System.out.println("time =" + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("EXITING " + methodName + "()");
		return rval;
	}
}