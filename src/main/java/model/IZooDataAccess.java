package model;

import java.util.List;

public interface IZooDataAccess {

	void ajouterAnimal(Animal animal);
    void ajouterEnclos(Enclos enclos);
    void ajouterSoigneur(Soigneur soigneur);
    List<Animal> getAnimal();
    List<Enclos> getEnclos();
    List<Soigneur> getSoigneur();
	void modifierAnimal(Animal animal);
	void supprimerAnimal(int id);
}
