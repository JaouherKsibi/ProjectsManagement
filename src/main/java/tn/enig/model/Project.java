package tn.enig.model;

public class Project {
	private int id;
	private String titre;
	private String etat ;
	private Departement departement;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String titre, Departement departement,String etat) {
		super();
		this.id = id;
		this.titre = titre;
		this.etat = etat;
		this.departement = departement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	

}
