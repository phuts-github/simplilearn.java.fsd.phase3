package com.simplilearn.spring.constructor.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Example with  IOC container - BeanFactoryd!" );
        
        Resource resource = new ClassPathResource("ApplicationContext.xml");
        
//        IOC container is BeanFactory
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        
        Student student = (Student) beanFactory.getBean("studentbean");
        student.displayStudentInfo();
        
        Employee employee = (Employee) beanFactory.getBean("employeebean");
        employee.displayEmployeeInfor();
        

        
//	another example
        System.out.println();
        System.out.println( "Example with  IOC container - Application context!" );
//      IOC container is Application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
      
        Student student1 = (Student) applicationContext.getBean("studentbean");
        student.displayStudentInfo();
        
        Employee employee1 = (Employee) applicationContext.getBean("employeebean");
        employee.displayEmployeeInfor();

        
        
    }
}

