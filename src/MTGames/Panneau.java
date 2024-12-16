package MTGames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panneau extends JPanel { 
	JPanel cePanel = this;
	String texteAAfficher = "";
	public Panneau(String[] listeUtilisateursAAfficher, int nombreUtilisateurs) {
		//Parametrer le JPanel
		this.setBackground(Color.red);
		this.setBounds(20, 20, 360, 160);
		//CrÃ©er le liste de JLabel qui vont afficher les noms de Utilisateurs
		JLabel[] listeLabels = new JLabel[100];
		for (int noUtilisateurs = 0; noUtilisateurs < nombreUtilisateurs; noUtilisateurs++) {
			listeLabels[noUtilisateurs] = new JLabel(listeUtilisateursAAfficher[noUtilisateurs],JLabel.CENTER);
			listeLabels[noUtilisateurs].setBounds(20, 20 + noUtilisateurs*15, 200, 10);
			listeLabels[noUtilisateurs].setForeground(Color.red);
			this.add(listeLabels[noUtilisateurs]);
		}

		JLabel labelCaseACocher = new JLabel("Valider la liste?");
		labelCaseACocher.setBounds(100, 100, 100, 20);
		this.add(labelCaseACocher);
		//CrÃ©er une case Ã  cocher
		JCheckBox caseACocher = new JCheckBox("Test");
		caseACocher.setBounds(200, 100, 20, 20);
		this.add(caseACocher);
		caseACocher.setSelected(true);

		String listeUtilisateurs[] = { "Samuel VONTHRON", "Mathys CHERUEL", "Thomas CAMBOULAS", "Ethan CHAMDEBOIS" }; 
		// crÃ©er une listeDeroulante
		JComboBox listeDeroulante = new JComboBox(listeUtilisateurs); 
		listeDeroulante.setBounds(200, 40, 150, 20);
		this.add(listeDeroulante);

	}
	public void paintComponent(Graphics g){
		g.fillOval(20, 130, 25, 25); 
	}               
}