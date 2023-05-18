package jpaMapeamentos_n_n;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity /* criacao da tabela */
public class Employee {

	@Id /* chave primaria */
	@GeneratedValue(strategy = GenerationType.IDENTITY) /* auto incrementa por responsabilidade do bd */
	private int eid;
	private String enome;
	private double salario;
	private String deg;

	@ManyToMany(targetEntity = Department.class)
	@JoinColumn(name = "eid", referencedColumnName = "id")
	// private Set departmentSet;
	private List departmentSet;

	public Employee(int eid, String enome, double salario, String deg, List departmentSet) {
		super();
		this.eid = eid;
		this.enome = enome;
		this.salario = salario;
		this.deg = deg;
		this.departmentSet = departmentSet;
	}

	public Employee() {
		super();
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEnome() {
		return enome;
	}

	public void setEnome(String enome) {
		this.enome = enome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public List getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(List departmentSet) {
		this.departmentSet = departmentSet;
	}

}