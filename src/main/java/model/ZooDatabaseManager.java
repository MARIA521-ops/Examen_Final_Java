package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZooDatabaseManager implements IZooDataAccess{
	
	private static ZooDatabaseManager instance;
	private Connection connection;
	
	

	private ZooDatabaseManager() {
		
		try {
            connection = DriverManager.getConnection("jdbc:sqlite:zoo.db");
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS Animal (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, espece TEXT, age TEXT, regimeAlimentaire TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS Enclos (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, capacite TEXT, typeHabitat TEXT)");
            stmt.execute("CREATE TABLE IF NOT EXISTS Soigneur (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, specialite TEXT, dateEmprunt TEXT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static ZooDatabaseManager getInstance() {
        if (instance == null) {
            instance = new ZooDatabaseManager();
        }
        return instance;
    }

	@Override
	public void ajouterAnimal(Animal animal) {
		
		 try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Animal (nom, espece, age, regimeAlimentaire) VALUES (?, ?, ?, ?)");) {
	            stmt.setString(1, animal.getNom());
	            stmt.setString(2, animal.getEspece());
	            stmt.setString(3, animal.getAge());
	            stmt.setString(4, animal.getRegimeAlimentaire());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void ajouterEnclos(Enclos enclos) {
		try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Enclos (nom, capacite, typeHabitat) VALUES (?, ?, ?)");) {
            stmt.setString(1, enclos.getNom());
            stmt.setString(2, enclos.getCapacite());
            stmt.setString(3, enclos.getTypeHabitat());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void ajouterSoigneur(Soigneur soigneur) {
		try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Soigneur (nom, specialite) VALUES (?, ?)");) {
            stmt.setString(1, soigneur.getNom());
            stmt.setString(2, soigneur.getSpecialite());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Animal> getAnimal() {
		List<Animal> animaux = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM Animal")) {
            while (rs.next()) {
            	animaux.add(new Animal(rs.getInt("id"), rs.getString("nom"), rs.getString("espece"), rs.getString("age"), rs.getString("regimeAlimentaire")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animaux;
	}

	@Override
	public List<Enclos> getEnclos() {
		List<Enclos> enclos = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM Enclos")) {
            while (rs.next()) {
            	enclos.add(new Enclos(rs.getInt("id"), rs.getString("nom"), rs.getString("capacite"), rs.getString("typeHabitat")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enclos;
	}

	@Override
	public List<Soigneur> getSoigneur() {
		List<Soigneur> soigneur = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM Soigneur")) {
            while (rs.next()) {
            	soigneur.add(new Soigneur(rs.getInt("id"), rs.getString("nom"), rs.getString("specialite")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return soigneur;
	}

	@Override
	public void modifierAnimal(Animal animal) {
		
		try (PreparedStatement stmt = connection.prepareStatement("UPDATE Animal SET nom = ?, espece = ?, age = ?, regimeAlimentaire = ? WHERE id = ?")) {
            stmt.setString(1, animal.getNom());
            stmt.setString(2, animal.getEspece());
            stmt.setString(3, animal.getAge());
            stmt.setString(4, animal.getRegimeAlimentaire());
            stmt.setInt(5, animal.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void supprimerAnimal(int id) {
		 try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM Animal WHERE id = ?")) {
	            stmt.setInt(1, id);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	
}
