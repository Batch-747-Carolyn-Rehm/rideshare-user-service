package com.revature.aspects;

//import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;


@Aspect
@Component
public class LoggingAspect {
	
  Logger logs = Logger.getRootLogger();
  
  @Before("execution(* com.revature.controllers..*(..))")
  public void logMethodCall(JoinPoint point) {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    logs.info("\033[0;32m" + "The service called is: " + request.getMethod() + 
    		"/" + request.getRequestURI() + "\033[0;34m" + " and method used : " + point.getSignature().getName() + "()" + "\033[0m");
  }  
  
  @AfterThrowing(pointcut="execution(* com.revature.controllers..*(..))", throwing = "ex")
  public void logError(Exception ex) throws Throwable {
	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	logs.error("\033[0;31m" + "The service called is: " + request.getMethod()  +
    		"/" + request.getRequestURI() + " Error exception: " + ex + "\033[0m");
  }
}
