package org.devel.examples.jee.jpa.domain.questions.q52;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Q52Test {

	private EntityManager manager;
	private Person person;

	public Q52Test(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		Q52Test test = new Q52Test(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEntities();
			test.runQueries();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
	}

	private void runQueries() {
		int result = manager
				.createNamedQuery("DeleteAllPersonsByStatus", Person.class)
				.setParameter("status", "string").executeUpdate();
		System.out.println("result: " + result);

		System.out.println(manager.createNamedQuery(
				"SelectAllPersons", Person.class).getResultList());
		System.out.println(manager.createNamedQuery(
				"SelectAllAddresses", Address.class).getResultList());
	}

	private void createEntities() {
		person = new Person();
		person.status = "string";
		person.address = new Address();
		manager.persist(person);
	}

}
