package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.ZooService;
import model.Animal;
import model.Enclos;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldEspece;
	private JTextField textFieldAge;
	private JTextField textFieldRegimeAlimentaire;
	private JTable table;
	private JTextField textFieldRechercher;
	
	private ZooService service;
	private DefaultTableModel model;
	
	public void viderChamps() {
		textFieldNom.setText("");
		textFieldEspece.setText("");
		textFieldAge.setText("");
		textFieldRegimeAlimentaire.setText("");
    }
	/**
	 * Launch the application.
	

	
	 * Create the frame.
	 */
	public FramePrincipal() {
		
		service = new ZooService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 410);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION ZOO");
		lblNewLabel.setBounds(140, 11, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel LabelNom = new JLabel("Nom");
		LabelNom.setBounds(43, 54, 46, 14);
		contentPane.add(LabelNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(143, 51, 86, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel LabelEspece = new JLabel("Espece");
		LabelEspece.setBounds(26, 79, 46, 14);
		contentPane.add(LabelEspece);
		
		textFieldEspece = new JTextField();
		textFieldEspece.setBounds(143, 82, 86, 20);
		contentPane.add(textFieldEspece);
		textFieldEspece.setColumns(10);
		
		JLabel LabelAge = new JLabel("Age");
		LabelAge.setBounds(26, 116, 46, 14);
		contentPane.add(LabelAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setBounds(143, 113, 86, 20);
		contentPane.add(textFieldAge);
		textFieldAge.setColumns(10);
		
		JLabel LabelRegimeAlimentaire = new JLabel("Regime Alimentaire");
		LabelRegimeAlimentaire.setBounds(10, 147, 98, 14);
		contentPane.add(LabelRegimeAlimentaire);
		
		textFieldRegimeAlimentaire = new JTextField();
		textFieldRegimeAlimentaire.setBounds(140, 144, 86, 20);
		contentPane.add(textFieldRegimeAlimentaire);
		textFieldRegimeAlimentaire.setColumns(10);
		
		table = new JTable();
		table.setBounds(26, 222, 571, 138);
		contentPane.add(table);
		
		JButton ButtonAjouter = new JButton("Ajouter");
		ButtonAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nom = textFieldNom.getText();
                String espece = textFieldEspece.getText();
                String age = textFieldAge.getText();
                String regimeAlimentaire = textFieldRegimeAlimentaire.getText();
                service.ajouterAnimal(nom, espece, age, regimeAlimentaire);
                JOptionPane.showMessageDialog(null, "Animal ajouté avec succès !");
                viderChamps();
			}
		});
		ButtonAjouter.setBounds(26, 188, 89, 23);
		contentPane.add(ButtonAjouter);
		
		JButton ButtonModifier = new JButton("Modifier");
		ButtonModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  int selectedRow = table.getSelectedRow();
	                if (selectedRow != -1) {
	                    int id = (int) table.getValueAt(selectedRow, 0);
	                    String nom = textFieldNom.getText();
	                    String espece = textFieldEspece.getText();
	                    String age = textFieldAge.getText();
	                    String regimeAlimentaire = textFieldRegimeAlimentaire.getText();
	                    service.modifierAnimal(id, nom, espece, age, regimeAlimentaire);
	                    JOptionPane.showMessageDialog(null, "Animal modifié avec succès !");
	                    viderChamps();
	                    afficherAnimal();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un livre à modifier.");
	                }
			}
		});
		ButtonModifier.setBounds(140, 188, 89, 23);
		contentPane.add(ButtonModifier);
		
		JButton ButtonSupprimer = new JButton("Supprimer");
		ButtonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) table.getValueAt(selectedRow, 0);
                    service.supprimerAnimal(id);
                    JOptionPane.showMessageDialog(null, "Animal supprimé avec succès !");
                    afficherAnimal();
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un animal à supprimer.");
                }
			}
		});
		ButtonSupprimer.setBounds(239, 188, 89, 23);
		contentPane.add(ButtonSupprimer);
		
		JButton ButtonAfficherAnimaux = new JButton("Afficher Animaux");
		ButtonAfficherAnimaux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 afficherAnimal();
			}
			
		});
		ButtonAfficherAnimaux.setBounds(338, 188, 117, 23);
		contentPane.add(ButtonAfficherAnimaux);
		
		JButton ButtonAfficherEnclos = new JButton("Afficher Enclos");
		ButtonAfficherEnclos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 afficherEnclos();
			}
		});
		ButtonAfficherEnclos.setBounds(480, 188, 117, 23);
		contentPane.add(ButtonAfficherEnclos);
		
		JButton ButtonRechercher = new JButton("Rechercher");
		ButtonRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String recherche = textFieldRechercher.getText();
                rechercherAnimal(recherche);
                rechercherEnclos(recherche);
			}
		});
		ButtonRechercher.setBounds(254, 70, 89, 23);
		contentPane.add(ButtonRechercher);
		
		textFieldRechercher = new JTextField();
		textFieldRechercher.setBounds(353, 76, 239, 20);
		contentPane.add(textFieldRechercher);
		textFieldRechercher.setColumns(10);
	}
	
	
	private void afficherAnimal() {
        List<Animal> animaux = service.getAnimal();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nom", "Espece", "Age", "Regime"}, 0);
        for (Animal animal : animaux) {
            model.addRow(new Object[]{animal.getId(), animal.getNom(), animal.getEspece(), animal.getAge(), animal.getRegimeAlimentaire()});
        }
        table.setModel(model);
    }
	
	private void afficherEnclos() {
        List<Enclos> Listenclos = service.getEnclos();
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nom", "capacite", "Habitat"}, 0);
        for (Enclos enclos : Listenclos) {
            model.addRow(new Object[]{enclos.getId(), enclos.getNom(), enclos.getCapacite(), enclos.getTypeHabitat()});
        }
        table.setModel(model);
    }
	
	private void rechercherAnimal(String recherche) {
		List<Animal> animaux = service.getAnimal();
		DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nom", "Espece", "Age", "Regime"}, 0);
		for (Animal animal : animaux) {
            if (animal.getNom().toLowerCase().contains(recherche.toLowerCase()) ||
            		animal.getEspece().toLowerCase().contains(recherche.toLowerCase()) ||
            		animal.getRegimeAlimentaire().toLowerCase().contains(recherche.toLowerCase()) ||
            		animal.getAge().contains(recherche)) {
                model.addRow(new Object[]{animal.getId(), animal.getNom(), animal.getEspece(), animal.getAge(), animal.getRegimeAlimentaire()});
            }
        }
        table.setModel(model);
    }
	
	private void rechercherEnclos(String recherche) {
		 List<Enclos> Listenclos = service.getEnclos();
		 DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nom", "capacite", "Habitat"}, 0);
		 for (Enclos enclos : Listenclos){
            if (enclos.getNom().toLowerCase().contains(recherche.toLowerCase()) ||
            		enclos.getCapacite().toLowerCase().contains(recherche.toLowerCase()) ||
            		enclos.getTypeHabitat().contains(recherche)) {
                model.addRow(new Object[]{enclos.getId(), enclos.getNom(), enclos.getCapacite(), enclos.getTypeHabitat()});
            }
        }
        table.setModel(model);
    }
	
	


}
