package com.janbask.training3.xml;

import com.janbask.training3.common.Operation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlExAOP {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xmlBeans.xml");
        Operation e = (Operation) context.getBean("opBean");
        System.out.println("calling msg...");
        e.msg();
        System.out.println("calling m...");
        e.m();
        System.out.println("calling k...");
        e.k();
        System.out.println("calling aroundMethod...");
        e.aroundMethod();
        try{
            e.validate(12);
        }
        catch (Exception exception){System.out.println("There was an exception!");}
    }

}
