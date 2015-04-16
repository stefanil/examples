package org.devel.examples.jee.jpa.domain.orphan;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Parent1 {

	@Id
	@GeneratedValue
	private Long id;

	// Owner
	@OneToOne(cascade=CascadeType.PERSIST)
	private Child child;

	private String name;

	public Parent1() {

	}

	public Parent1(String name, Child dep) {
		this.name = name;
		this.child = dep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child dep) {
		this.child = dep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
