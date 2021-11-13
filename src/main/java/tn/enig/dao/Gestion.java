package tn.enig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tn.enig.model.Departement;
import tn.enig.model.Employee;
import tn.enig.model.Project;
@Repository
public class Gestion implements IGestion{
	@Autowired 
	@Qualifier("dataSource")
	DataSource dataSource;
	public void setG(DataSource g) {
		this.dataSource = g;
	}

	public Project getProjectById(int id) {
		try {
			Connection con=dataSource.getConnection();
			String req="select * from projet where id = ?";
			PreparedStatement prst=con.prepareStatement(req);
			prst.setInt(1, id);
			ResultSet rs= prst.executeQuery();
			if(rs.next()) {
				return new Project(rs.getInt(1),rs.getString(2),getDepartementById(rs.getInt(4)),rs.getString(3));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Departement getDepartementById(int id) {
		try {
			Connection con=dataSource.getConnection();
			String req="select * from departement where id = ?";
			PreparedStatement prst=con.prepareStatement(req);
			prst.setInt(1, id);
			ResultSet rs= prst.executeQuery();
			if(rs.next()) {
				return new Departement(rs.getInt(1),rs.getString(2));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Employee getEmployeeById(int id) {
		try {
			Connection con=dataSource.getConnection();
			String req="select * from employee where id = ?";
			PreparedStatement prst=con.prepareStatement(req);
			prst.setInt(1, id);
			ResultSet rs= prst.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),getDepartementById(rs.getInt(4)),getProjectById(rs.getInt(5)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Departement> getAllDepartements() {
		List<Departement> ls=new ArrayList<Departement>();
		try {
			Connection con=dataSource.getConnection();
			System.out.println("ok2");
			String req="select * from departement";
			PreparedStatement prst=con.prepareStatement(req);
			ResultSet rs= prst.executeQuery();
			while(rs.next()) {
				ls.add(new Departement(rs.getInt(1),rs.getString(2)));
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> ls=new ArrayList<Employee>();
		try {
			Connection con=dataSource.getConnection();
			String req="select * from employee";
			PreparedStatement prst=con.prepareStatement(req);
			ResultSet rs= prst.executeQuery();
			while(rs.next()) {
				ls.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),getDepartementById(rs.getInt(4)),getProjectById(rs.getInt(5))));
			}
			return ls;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Project> getAllProjects() {
		List<Project> ls=new ArrayList<Project>();
		try {
			Connection con=dataSource.getConnection();
			String req="select * from projet";
			PreparedStatement prst=con.prepareStatement(req);
			ResultSet rs= prst.executeQuery();
			while(rs.next()) {
				ls.add(new Project(rs.getInt(1),rs.getString(2),getDepartementById(rs.getInt(4)),rs.getString(3)));
			}
			return ls;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Employee> getEmployeesByIdProject(int id) {
		List<Employee> ls=new ArrayList<Employee>();
		try {
			Connection con=dataSource.getConnection();
			String req="select * from employee where projectid = ?";
			PreparedStatement prst=con.prepareStatement(req);
			prst.setInt(1, id);
			ResultSet rs= prst.executeQuery();
			while(rs.next()) {
				ls.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),getDepartementById(rs.getInt(4)),getProjectById(rs.getInt(5))));
			}
			return ls;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Project> getProjectsByIdDepartement(int id) {
		List<Project> ls=new ArrayList<Project>();
		try {
			Connection con=dataSource.getConnection();
			String req="select * from projet where iddep = ?";
			PreparedStatement prst=con.prepareStatement(req);
			prst.setInt(1, id);
			ResultSet rs= prst.executeQuery();
			while(rs.next()) {
				ls.add(new Project(rs.getInt(1),rs.getString(2),getDepartementById(rs.getInt(4)),rs.getString(3)));
			}
			return ls;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Employee> getEmployeesByIdDepartement(int id) {
		List<Employee> ls=new ArrayList<Employee>();
		try {
			Connection con=dataSource.getConnection();
			String req="select * from employee where departementid = ?";
			PreparedStatement prst=con.prepareStatement(req);
			prst.setInt(1, id);
			ResultSet rs= prst.executeQuery();
			while(rs.next()) {
				ls.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),getDepartementById(rs.getInt(4)),getProjectById(rs.getInt(5))));
			}
			return ls;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void addProject(Project p) {
		try {
			String req="insert into projet(titre,etat,iddep) values(?,?,?)";
			Connection con =dataSource.getConnection();
			PreparedStatement prst =con.prepareStatement(req);
			prst.setString(1, p.getTitre());
			prst.setString(2, p.getEtat());
			prst.setInt(3, p.getDepartement().getId());
			
			prst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void addEmployee(Employee e) {
		try {
			String req="insert into employee(nom1,fn,departementid,projectid) values(?,?,?,?)";
			Connection con =dataSource.getConnection();
			PreparedStatement prst =con.prepareStatement(req);
			prst.setString(1, e.getNom());
			prst.setString(2, e.getFunction());
			prst.setInt(3, e.getDep().getId());
			prst.setInt(4, e.getProject().getId());
			
			prst.executeUpdate();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
