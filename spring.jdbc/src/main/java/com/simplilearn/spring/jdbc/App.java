package com.simplilearn.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeedao");
        
//        int insertResults = employeeDao.saveEmployee(new Employee(112,"John", 100));
//        System.out.println(insertResults);
        
        int updateResults = employeeDao.updateEmployee(new Employee(100,"Johns", 102));
        System.out.println(updateResults);

        int deleteResults = employeeDao.deleteEmployee(new Employee(101,"",0));
        System.out.println(deleteResults);
    }
}
