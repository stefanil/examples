package org.devel.examples.jee.jpa.domain.entitymanager.cm.extended;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.devel.examples.jee.jpa.domain.Department;
import org.devel.examples.jee.jpa.domain.Employee;

/*
 * PersitenceContext + EntityManager besitzt SessionScope einer 
 * korrelierenden stateful SessionBean (Start: 1te Verwendung; Ende: 
 * @Remove-markierte Methode wird aufgerufen)
 */
@Stateful
public class DepartmentManager {

	/*
	 * Verwendung des PC-Typen EXTENDED f�hrt dazu, dass derseleb EM
	 * w�hrend der gesammten Sitzung verwended wird. 
	 * 
	 * Default-Typ ist TRANSACTIONAL. Hier w�rde der EM (inkl. PC)
	 * mit jedem Aufruf einer Methode aufgebaut und zerst�rt.
	 */
	@PersistenceContext(unitName = "EmployeeService", type = PersistenceContextType.EXTENDED)
	EntityManager em;
	Department dept;

	public void init(int deptId) {
		dept = em.find(Department.class, deptId);
	}

	public void setName(String name) {
		dept.setName(name);
	}

	public void addEmployee(int empId) {
		Employee emp = em.find(Employee.class, empId);
		dept.getEmployees().add(emp);
		emp.setDepartment(dept);
	}

	@Remove
	public void finished() {
	}

}
