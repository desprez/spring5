package spring.interceptor;

import java.io.Serializable;

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
		System.out.println("ENTERING " + methodName + "()");
		Object rval = invocation.proceed();
		System.out.println("EXITING " + methodName + "()");
		return rval;
	}
}