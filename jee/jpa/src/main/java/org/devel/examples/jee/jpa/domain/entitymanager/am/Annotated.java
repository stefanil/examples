package org.devel.examples.jee.jpa.domain.entitymanager.am;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Annotated extends HttpServlet {
	
	@PersistenceUnit(unitName = "EmployeeService")
	EntityManagerFactory emf;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		
		String employeeId = request.getParameter("employee");

		// check valid user
		EntityManager em = emf.createEntityManager();
		try {
			// User user = em.find(User.class, userId);
			// if (user == null) {
			// // return error page
			// // ...
			// }
		} finally {
			em.close();
		}
		// ...
	}
}
