package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public  class PerformanceMonitoringAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		long start=0;
		long end=0;
		Object retVal=null;
		start=System.currentTimeMillis();
		retVal=invocation.proceed();
		end=System.currentTimeMillis();
		System.out.println(invocation.getMethod().getName()+"with args  "+Arrays.toString(invocation.getArguments())+" has taken  "+(end-start)+" ms");
		return retVal;
	}

}
