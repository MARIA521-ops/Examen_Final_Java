package controller;


import java.util.List;

import model.Animal;
import model.Enclos;
import model.IZooDataAccess;
import model.Soigneur;
import model.ZooDatabaseManager;

public class ZooService {
	
	private final IZooDataAccess database;

	public ZooService() {
		
		this.database = ZooDatabaseManager.getInstance();
	}
	
	public void ajouterAnimal(String nom, String espece, String age, String regimAlimentaire) {
        database.ajouterAnimal(new Animal(0, nom, espece, age, regimAlimentaire));
    }
	
	public List<Animal> getAnimal(){
		return database.getAnimal();
		
	}
	
	  public void modifierAnimal(int id, String nom, String espece, String age, String regimAlimentaire) {
	        database.modifierAnimal(new Animal(id, nom, espece, age, regimAlimentaire));
	    }

	    public void supprimerAnimal(int id) {
	        database.supprimerAnimal(id);
	    }
	
	public void ajouterEnclos(String nom, String capacite,  String typeHabitat) {
        database.ajouterEnclos(new Enclos(0, nom, capacite, typeHabitat));
    }
	
	public List<Enclos> getEnclos(){
		return database.getEnclos();
		
	}
	
	public void ajouterSoigneur(String nom, String specialite) {
        database.ajouterSoigneur(new Soigneur(0, nom, specialite));
    }
	
	public List<Soigneur> getSoigneur(){
		return database.getSoigneur();
		
	}
	
}
