package me.mikholskiy.task18.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	private long timerStartPoint;

	@Pointcut("within(me.mikholskiy.task18.services.*.*)")
	public void allServiceMethodsPointCut() {}

	@Before("allServiceMethodsPointCut()")
	public void setTimer(JoinPoint joinPoint) {
		log.info("Method {" + joinPoint.getSignature().getName() + "} called");
		this.timerStartPoint = System.currentTimeMillis();
	}

	@After("allServiceMethodsPointCut()")
	public void getExecutionTime(JoinPoint joinPoint) {
		log.info("Execution time of method {" + joinPoint.getSignature()
														 .getName() + "} is " + (System.currentTimeMillis() - timerStartPoint) + "ms");
	}
}
