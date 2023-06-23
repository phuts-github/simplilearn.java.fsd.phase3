package spring.hibernate.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
@Transactional(readOnly = false)
public class EmployeeDao {
	
//		DAO = Data Access Object
	HibernateTemplate hibernateTemplate = new HibernateTemplate();
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	public void saveEmployee(Employee e) {
		hibernateTemplate.update(e);
	}
	
//	public void updateEmployee(Employee e) {
//		hibernateTemplate.update(e);
//	}
//
//	public void deleteEmployee(Employee e) {
//		hibernateTemplate.delete(e);
//	}
}
