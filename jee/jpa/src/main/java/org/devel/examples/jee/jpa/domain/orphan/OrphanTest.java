package org.devel.examples.jee.jpa.domain.orphan;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrphanTest {

	private EntityManager manager;
	private Child child;
	private Parent1 parent1;
	private Parent1 parent2;

	public OrphanTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		OrphanTest test = new OrphanTest(manager);

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

		EntityTransaction tx1 = manager.getTransaction();
		tx1.begin();
		try {
			test.remove();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx1.commit();

		System.out.println("After removal:");

		test.listEmployees();

		System.out.println(".. done");
	}

	private void remove() {
//		manager.remove(child);
//		manager.remove(parent1);
//		manager.remove(parent1);
		parent1.setChild(null);
//		child.setParent1(null);
		manager.flush();
	}

	private void createEmployees() {
		child = new Child("java");
		parent1 = new Parent1("Sebastian", child);
		child.setParent1(parent1);
		// will work
//		parent2 = new Parent1("Stefan", child);
		manager.persist(parent1);
//		manager.persist(parent2);
		manager.flush();
	}

	private void listEmployees() {
		List<Parent1> resultList = manager.createQuery("Select a From Parent1 a",
				Parent1.class).getResultList();
		System.out.println("num of parents:" + resultList.size());
		for (Parent1 next : resultList) {
			System.out.println("next parents: " + next);
		}
		List<Child> resultList1 = manager.createQuery("Select c From Child c", Child.class).getResultList();
		System.out.println("num of children:" + resultList1.size());
		for (Child next : resultList1) {
			System.out.println("next children: " + next);
		}
	}

}
