package com.epsilon.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggerAspect {

	public LoggerAspect() {
//		log.info("LoggerAspect instantiated");
	}
	
	@Pointcut("execution (* com.epsilon..ProductDao.*(..))")
	public void pc1() {}
	
	@Pointcut("execution (* com.epsilon..ProductController.*(..))")
	public void pc2() {}
	// before advice
	@Before("pc1() || pc2()") //pointcut
	public void logBefore(JoinPoint jp) {
//		log.info("Entering {}, {} method with arguments.. {}",jp.getSignature().getDeclaringType,jp.getSignature().getName(), jp.getArgs(), jp.getKind());
	}
	
	@After("pc1() || pc2()")
	public void logAfter(JoinPoint jp) {
//		log.info("Exiting {} method ", jp.getSignature().getName());
	}
	
	// after advice
}
