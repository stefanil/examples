package org.devel.examples.jee.jpa.domain.orphan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Child {

	@Id
	@GeneratedValue
	private long id;

	/*
	 * orphanRemoval könnte auch hier stehen. Dann wäre das Child das Parent in
	 * der Waisenbeziehung.
	 */
	@OneToOne(mappedBy = "child")
	private Parent1 parent1;

	public Child() {
	}

	public Child(String name) {
		this.name = name;
	}

	public Parent1 getParent1() {
		return parent1;
	}

	public void setParent1(Parent1 parent1) {
		this.parent1 = parent1;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
