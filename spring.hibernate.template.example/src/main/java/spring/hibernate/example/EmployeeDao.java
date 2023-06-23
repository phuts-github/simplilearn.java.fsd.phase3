package spring.hibernate.example;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class EmployeeDao {
	
//		DAO = Data Access Object
//	HibernateTemplate hibernateTemplate = new HibernateTemplate();
	HibernateTemplate hibernateTemplate;


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveEmployee(Employee e) {
		hibernateTemplate.save(e);
	}
	
	public void updateEmployee(Employee e) {
		hibernateTemplate.update(e);
	}

	public void deleteEmployee(Employee e) {
		hibernateTemplate.delete(e);
	}
}
