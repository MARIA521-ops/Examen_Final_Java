package model;

public class Soigneur {

	
	 private int id;
	    private String nom;
	    private String specialite;
	    
	    
		public Soigneur(int id, String nom, String specialite) {
			super();
			this.id = id;
			this.nom = nom;
			this.specialite = specialite;
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


		public String getSpecialite() {
			return specialite;
		}


		public void setSpecialite(String specialite) {
			this.specialite = specialite;
		}
	   
	    
	    
}
