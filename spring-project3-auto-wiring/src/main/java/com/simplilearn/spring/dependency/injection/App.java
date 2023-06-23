package com.simplilearn.spring.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.simplilearn.spring.dependency.injection.autowiring.byconstructor.Library;
import com.simplilearn.spring.dependency.injection.constructor.Employee;
import com.simplilearn.spring.dependency.injection.constructor.collection.list.Question;
import com.simplilearn.spring.dependency.injection.constructor.collection.map.QuestionAnswerMap;
import com.simplilearn.spring.dependency.injection.setter.Student;


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

        System.out.println();
        
        Student student = (Student) beanFactory.getBean("studentbean");
        student.displayStudentInfo();

        System.out.println();
        
        Employee employee = (Employee) beanFactory.getBean("employeebean");
        employee.displayEmployeeInfor();
        

        
//	another example
        System.out.println();
        System.out.println( "Example with  IOC container - Application context!" );
//      IOC container is Application context
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println();
        
        Student student1 = (Student) applicationContext.getBean("studentbean");
        student1.displayStudentInfo();

        System.out.println();
        
        Employee employee1 = (Employee) applicationContext.getBean("employeebean");
        employee1.displayEmployeeInfor();

        System.out.println();
        
        Question listQuestion = (Question) applicationContext.getBean("listquestionbean");
        System.out.println(listQuestion);
//
        System.out.println();
        
        QuestionAnswerMap listQuestionAnswerMap = (QuestionAnswerMap) applicationContext.getBean("mapquestionanswerbean");
        System.out.println(listQuestionAnswerMap);
        
//        Autowiring
//        System.out.println();
//        System.out.println("Autowiring by name / type");        
//        Library library = (Library) applicationContext.getBean("library");
//        library.display();

//      Autowiring by constructor
        System.out.println();
        System.out.println("Autowiring by constructor");
        Library library2 = (Library) applicationContext.getBean("librarybean");
        library2.display();
//        
    }
}

