package com.janbask.training3.xml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TrackOperation{

    public void k(){}//pointcut name

    public void m(){}//pointcut name

    public void myadviceBefore(JoinPoint jp)//it is advice (before advice)
    {
        System.out.println("additional concern before calling k()");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }


    public void myadviceAfter(JoinPoint jp)//it is advice (after advice)
    {
        System.out.println("additional concern after m");
        //System.out.println("Method Signature: "  + jp.getSignature());
    }


    public void myadviceAfterReturn(JoinPoint jp,Object result)//it is advice (after returning advice)
    {
        System.out.println("*******************\nAfter return of method:\n*******************");
        System.out.println("\tMethod Signature: "  + jp.getSignature());
        System.out.println("\tResult in advice: "+result);
        System.out.println("end of after method returning advice...\n*******************");
    }


    public void aroundMethod(){}//pointcut name

    public Object myadviceAroundMethod(ProceedingJoinPoint pjp) throws Throwable
    {
        System.out.println("Additional Concern Before calling actual method (around block)");
        Object obj=pjp.proceed();
        System.out.println("Additional Concern After calling actual method (around block)");
        return obj;
    }

    public void myadviceAfterThrow(JoinPoint jp,Throwable error)//it is advice
    {
        System.out.println("additional concern");
        System.out.println("Method Signature: "  + jp.getSignature());
        System.out.println("Exception is: "+error);
        System.out.println("end of after throwing advice...");
    }


}