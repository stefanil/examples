package org.devel.examples.jee.jpa.domain.orphan;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Parent2 {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(orphanRemoval = true, cascade=CascadeType.PERSIST)
	private Child dep;

	private String name;

	public Parent2() {

	}

	public Parent2(String name, Child dep) {
		this.name = name;
		this.dep = dep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Child getDep() {
		return dep;
	}

	public void setDep(Child dep) {
		this.dep = dep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
