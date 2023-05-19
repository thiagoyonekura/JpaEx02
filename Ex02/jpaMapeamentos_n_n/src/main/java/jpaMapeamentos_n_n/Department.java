package jpaMapeamentos_n_n;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;

	@ManyToMany(mappedBy = "departmentSet")
	private List<Employee> employeeSet;

	public Department() {
		super();
	}

	public Department(String nome, List<Employee> employeeSet) {
		super();
		this.id = id;
		this.nome = nome;
		this.employeeSet = employeeSet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Employee> getEmployeeSet() {
		return employeeSet;
	}

	public void setEmployeeSet(List<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}

}