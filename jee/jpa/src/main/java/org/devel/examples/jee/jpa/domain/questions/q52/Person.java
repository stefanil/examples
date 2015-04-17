package org.devel.examples.jee.jpa.domain.questions.q52;

import static javax.persistence.CascadeType.ALL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({ @NamedQuery(name = "DeleteAllPersonsByStatus",
							query = "DELETE FROM Person p WHERE p.status = :status"),
				@NamedQuery(name = "SelectAllPersons",
							query = "SELECT p FROM Person p")
})
@Entity
// @Access(AccessType.FIELD)
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	protected String status;

	@OneToOne(cascade = ALL)
	protected Address address;

}
