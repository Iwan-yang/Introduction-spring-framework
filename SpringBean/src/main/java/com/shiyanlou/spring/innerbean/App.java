package com.shiyanlou.spring.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shiyanlou.spring.innerbean.Customer;

public class App
{
     private static ApplicationContext context;

        public static void main( String[] args )
        {
            context = new ClassPathXmlApplicationContext("SpringBeans.xml");

            Customer obj = (Customer) context.getBean("CustomerBean");

            System.out.println(obj.toString());
        }
}