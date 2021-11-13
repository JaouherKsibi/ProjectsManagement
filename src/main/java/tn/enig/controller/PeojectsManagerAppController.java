package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.dao.IGestion;
import tn.enig.model.Departement;
import tn.enig.model.Employee;
import tn.enig.model.Project;

@Controller
public class PeojectsManagerAppController {
	@Autowired
	IGestion g;
	public void setG(IGestion g) {
		this.g = g;
	}
	
	/******************************Welcome page ***************************/
	@GetMapping("home")
	public String home (Model m) {
		List<Departement> ls= g.getAllDepartements();
		m.addAttribute("liste", ls);
		return "home";
	}
	
	
	/*********************add Project********************/
	
	@GetMapping("addProject")
	public String goToAddProject(Model m) {
		Project p=new Project();
		List<Departement> ls= g.getAllDepartements();
		System.out.println(ls);
		m.addAttribute("p", p);
		m.addAttribute("liste", ls);
		return "addProject";
	}
	@PostMapping("addProject1")
	public String addProject(Model m,@ModelAttribute("p") Project p) {
		g.addProject(p);
		return "redirect:/home";
	}
	
	
/*********************add Employee********************/
	
	@GetMapping("addEmployee")
	public String goToAddEmployee(Model m) {
		Employee e=new Employee();
		List<Departement> ls= g.getAllDepartements();
		List<Project> l=g.getAllProjects();
		m.addAttribute("e", e);
		m.addAttribute("listeDepartement", ls);
		m.addAttribute("listeProjects", l);
		return "addEmployee";
	}
	@PostMapping("addEmployee1")
	public String addEmployee(Model m,@ModelAttribute("e") Employee e) {
		g.addEmployee(e);
		return "redirect:/home";
	}
	
	
	
	
	@RequestMapping(value = "projectsByDepartement/{departementId}", method=RequestMethod.GET)
	public String getProjectsById(Model m,@PathVariable int departementId){
	
		List<Project> l=g.getProjectsByIdDepartement(departementId);
		m.addAttribute("listeProjects", l);
		return "projectsById";
	}
	
	
	
	@RequestMapping(value = "employeeByDepartement/{departementId}", method=RequestMethod.GET)
	public String getEmployeesById(Model m,@PathVariable int departementId){
	
		List<Employee> l=g.getEmployeesByIdDepartement(departementId);
		m.addAttribute("listeEmplyees", l);
		return "employeesById";
	}
	@RequestMapping(value = "employeeByProject/{projectId}", method=RequestMethod.GET)
	public String getEmployeesByIdProjet(Model m,@PathVariable int projectId){
	
		List<Employee> l=g.getEmployeesByIdProject(projectId);
		Project p=g.getProjectById(projectId);
		m.addAttribute("listeEmplyees", l);
		m.addAttribute("p", p);
		return "employeesByIdProjet";
	}
	
}
