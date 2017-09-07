package com.janbask.training3.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TrackOperation{
    @Pointcut("execution(* com.janbask.training3.common.Operation.k(..))")
    public void k(){}//pointcut name

    @Pointcut("execution(* com.janbask.training3.common.Operation.m(..))")
    public void m(){}//pointcut name

    @Before("k()")//applying pointcut on before advice
    public void myadviceBefore(JoinPoint jp)//it is advice (before advice)
    {
        System.out.println("additional concern before calling k()");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }

    @After("m()")//applying pointcut on after advice
    public void myadviceAfter(JoinPoint jp)//it is advice (after advice)
    {
        System.out.println("additional concern after m");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }

    @AfterReturning(
            pointcut = "execution(* com.janbask.training3.common.Operation.*(..))",
            returning= "result")
    public void myadviceAfterReturn(JoinPoint jp,Object result)//it is advice (after returning advice)
    {
        System.out.println("*******************\nAfter return of method:\n*******************");
        System.out.println("\tMethod Signature: "  + jp.getSignature());
        System.out.println("\tResult in advice: "+result);
        System.out.println("end of after method returning advice...\n*******************");
    }

    @Pointcut("execution(* com.janbask.training3.common.Operation.aroundMethod(..))")
    public void aroundMethod(){}//pointcut name

    @Around("aroundMethod()")
    public Object myadvice(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("Additional Concern Before calling actual method (around block)");
        Object obj=pjp.proceed();
        System.out.println("Additional Concern After calling actual method (around block)");
        return obj;
    }

    @AfterThrowing(
            pointcut = "execution(* com.janbask.training3.common.Operation.*(..))",
            throwing= "error")

    public void myadvice(JoinPoint jp,Throwable error)//it is advice
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
    }


}
