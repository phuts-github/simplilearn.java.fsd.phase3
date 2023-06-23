package spring.hibernate.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/hibernate/example/applicationContext.xml");
		EmployeeDao employeeDao = (EmployeeDao) applicationContext.getBean("employeedao");
		
		Employee e=new Employee();
		e.setId(12);
		e.setName("pete");
		e.setSalary(120);
		
		employeeDao.saveEmployee(e);

	}
	

}
