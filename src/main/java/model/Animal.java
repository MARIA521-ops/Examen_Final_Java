package model;

public class Animal {

	 private int id;
	    private String nom;
	    private String espece;
	    private String age;
	    private String regimeAlimentaire;
	    
	    
		public Animal(int id, String nom, String espece, String age, String regimeAlimentaire) {
			super();
			this.id = id;
			this.nom = nom;
			this.espece = espece;
			this.age = age;
			this.regimeAlimentaire = regimeAlimentaire;
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


		public String getEspece() {
			return espece;
		}


		public void setEspece(String espece) {
			this.espece = espece;
		}


		public String getAge() {
			return age;
		}


		public void setAge(String age) {
			this.age = age;
		}


		public String getRegimeAlimentaire() {
			return regimeAlimentaire;
		}


		public void setRegimeAlimentaire(String regimeAlimentaire) {
			this.regimeAlimentaire = regimeAlimentaire;
		}
	    
		
		
	    
}
