package spring.hibernate.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"spring/hibernate/example/applicationContext.xml");
//		EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeedao");
//
//		Employee e = new Employee();
//		e.setId(12);
//		e.setName("pete");
//		e.setSalary(120);
//
//		employeeDao.saveEmployee(e);
	}
}
