package Principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos3.Department;
import jpaMapeamentos3.Employee;

public class OneToOne {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("jpaMapeamentos_1_1");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Entidade departamento criada
		Department department = new Department();
		department.setNome("Desenvolvimento");

		// Persistir uma entidade Department
		entitymanager.persist(department);

		// Entidade Empregado criada
		Employee employee = new Employee();
		employee.setEnome("Marcos");
		employee.setSalario(55000.0);
		employee.setDeg("Desenvolvedor");
		employee.setDepartment(department);

		// Persistir uma entidade Employee
		entitymanager.persist(employee);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}