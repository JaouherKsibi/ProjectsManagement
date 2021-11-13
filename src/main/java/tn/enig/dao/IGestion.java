package tn.enig.dao;

import java.util.List;

import tn.enig.model.Departement;
import tn.enig.model.Employee;
import tn.enig.model.Project;

public interface IGestion {

	public Project getProjectById(int id);
	public Departement getDepartementById(int id);
	public Employee getEmployeeById(int id);
	
	public List<Departement> getAllDepartements();
	public List<Employee> getAllEmployees();
	public List<Project> getAllProjects();
	
	public List<Employee> getEmployeesByIdProject(int id);
	public List<Project> getProjectsByIdDepartement(int id);
	public List<Employee> getEmployeesByIdDepartement(int id);
	
	
	public void addProject(Project p);
	public void addEmployee(Employee e);
	
}
