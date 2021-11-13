package tn.enig.model;

public class Employee {
	private int id;
	private String nom;
	private String function;
	private Departement dep;
	private Project project;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String nom, String function, Departement dep, Project project) {
		super();
		this.id = id;
		this.nom = nom;
		this.function = function;
		this.dep = dep;
		this.project = project;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public Departement getDep() {
		return dep;
	}
	public void setDep(Departement dep) {
		this.dep = dep;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	

}
