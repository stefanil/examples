package org.devel.examples.jee.jpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.devel.examples.jee.jpa.domain.Employee;
import org.devel.examples.jee.jpa.domain.Department;

public class JpaTest {

	private EntityManager manager;
	private Department department;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		System.out.println("After creation:");

		test.listEmployees();

		test.removeDepartment();

		System.out.println("After removal:");

		test.listEmployees();

		System.out.println(".. done");
	}

	private void removeDepartment() {
		manager.remove(department);
	}

	private void createEmployees() {
		int numOfEmployees = manager
				.createQuery("Select a From Employee a", Employee.class)
				.getResultList().size();

		department = new Department("java");

		if (numOfEmployees == 0) {
			// manager.persist(department);
			//
			// manager.persist(new Employee("Jakab Gipsz", department));
			// manager.persist(new Employee("Captain Nemo", department));

			department.setEmployees(new ArrayList<Employee>() {
				private static final long serialVersionUID = -8176928234769627446L;
				{
					add(new Employee("Jakab Gipsz", department));
					add(new Employee("Captain Nemo", department));
				}
			});
			
			manager.persist(department);
		}
	}

	private void listEmployees() {
		List<Employee> resultList = manager.createQuery(
				"Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}

}
