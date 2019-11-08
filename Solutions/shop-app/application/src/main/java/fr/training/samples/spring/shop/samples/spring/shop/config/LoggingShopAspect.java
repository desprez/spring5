package fr.training.samples.spring.shop.samples.spring.shop.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingShopAspect {

	private static final Log LOGGER = LogFactory.getLog(LoggingShopAspect.class);

	@Pointcut("execution( * fr.training.samples.spring.shop.application..*(..))")
	private void profilingApplicationLayer() {
	}

	@Around("profilingApplicationLayer()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		StringBuilder toLog = new StringBuilder("logging ").append(pjp.getSignature().toLongString());
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		LOGGER.info(toLog + " execution time: " + elapsedTime + " milliseconds.");
		return output;
	}
}