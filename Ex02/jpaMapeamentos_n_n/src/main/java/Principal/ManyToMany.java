package Principal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaMapeamentos_n_n.Department;
import jpaMapeamentos_n_n.Employee;

public class ManyToMany {

	public static void main(String[] args) {
		 // Criação do EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaMapeamentos_n_n");
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();

		// Criando a entidade departamento
		Department department = new Department("Desenvolvedor", null);
		Department department2 = new Department("Informatica", null);
		Department department3 = new Department("Contabilidade", null);

		// Armazenando departamento
		entitymanager.persist(department); // salvar o departamento no bd
		entitymanager.persist(department2); // salvar o departamento2 no bd
		entitymanager.persist(department3); // salvar o departamento3 no bd

		// Criando um grupo de departamentos1
		List<Department> departmentSet1 = new ArrayList();
		departmentSet1.add(department);
		// departmentSet1.add(department2);

		// Criando um grupo de departamentos2
		List<Department> departmentSet2 = new ArrayList();
		departmentSet2.add(department2);

		// Criando um grupo de departamentos3
		List<Department> departmentSet3 = new ArrayList();
		departmentSet3.add(department3);

		// Criando a entidade trabalhador
		Employee employee1 = new Employee();
		employee1.setEnome("Arthur");
		employee1.setSalario(55000.0);
		employee1.setDeg("Escritor técnico");
		employee1.setDepartmentSet(departmentSet1);

		// Criando a entidade trabalhador
		Employee employee2 = new Employee();
		employee2.setEnome("Thiago");
		employee2.setSalario(60000.0);
		employee2.setDeg("Investigador");
		employee2.setDepartmentSet(departmentSet2);

		// Criando a entidade trabalhador
		Employee employee3 = new Employee();
		employee3.setEnome("Marcos");
		employee3.setSalario(40000.0);
		employee3.setDeg("Professor");
		employee3.setDepartmentSet(departmentSet3);

		// Armazenar trabalhador
		entitymanager.persist(employee1);
		entitymanager.persist(employee2); 
		entitymanager.persist(employee3);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emf.close();
	}

}