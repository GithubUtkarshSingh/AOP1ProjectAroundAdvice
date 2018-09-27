package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object retVal=null;
		Object[] args=null;
		System.out.println("Entering into "+invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		//modifying arg values
		args=invocation.getArguments();
		if(((Float)args[0])<=50000){
			args[1]=((Float)args[1])-0.5f;
		}
		if(((Float)args[0])<=0 || ((Float)args[1])<=0 || ((Float)args[2])<=0 ){
			throw new IllegalArgumentException("Invalid inputs");
		}
		else{
		retVal=invocation.proceed();
		}
		System.out.println("Exiting from "+invocation.getMethod().getName()+" with args "+Arrays.toString(invocation.getArguments()));
		//modifying return values
		retVal=((Float)retVal)+((Float)retVal)*0.01f;
		return retVal;
	}

}
