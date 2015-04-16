package org.devel.examples.jee.jpa.domain.entitymanager.cm.ta;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.devel.examples.jee.jpa.domain.Department;
import org.devel.examples.jee.jpa.domain.Employee;

@Stateless
public class EmployeeService {

	@PersistenceContext(unitName = "EmployeeService")
	EntityManager em;

	public void assignEmployeeToDepartment(int empId, int departmentId) {
		/*
		 * Beim ersten Aufruf des EntityManagers, sucht dieser nach einem
		 * PersistenceContext. Ist keiner vorhanden, wird dieser erzeugt und für
		 * das Finden benutzt.
		 */
		Department department = em.find(Department.class, departmentId);
		Employee employee = em.find(Employee.class, empId);
		department.getEmployees().add(employee);
		employee.setDepartment(department);
		/* 
		 * automatischer TA-Commit beim verlassen der Methode
		 */
	}

}
