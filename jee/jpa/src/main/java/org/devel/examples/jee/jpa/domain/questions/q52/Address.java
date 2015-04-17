package org.devel.examples.jee.jpa.domain.questions.q52;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQuery(name = "SelectAllAddresses", query = "SELECT p FROM Address p")
@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(mappedBy = "address")
	protected Person person;

}
