package org.devel.examples.jee.jpa.domain.entitymanager.am;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.devel.examples.jee.jpa.domain.Employee;

public class Programmatic {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("EmployeeService");
		EntityManager em = emf.createEntityManager();
		List<Employee> emps = em.createQuery("SELECT e FROM Employee e")
				.getResultList();
		for (Employee e : emps) {
			System.out.println(e.getId() + ", " + e.getName());
		}
		em.close();
		emf.close();
	}
	
}
