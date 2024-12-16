package MTGames;

import java.awt.Color;

import javax.swing.JFrame;

public class FenetreUtilisateurs extends JFrame{

	public FenetreUtilisateurs(String[] listeUtilisateursAAfficher,int nombreUtilisateurs) {
		//titre de la fenÃªtre
		this.setTitle("Liste des Utilisateurs intÃ©ressÃ©s");
		//taille : 400 pixels de large , 200 pixels de haut
		this.setSize(400, 200);
		//positionnemenyt de la fenÃªtre au centre de l'Ã©cran
		this.setLocationRelativeTo(null);
		//Definir l'action Ã  effectuer lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//DÃ©finition de sa couleur de fond
		this.setBackground(Color.blue);

		//CrÃ©er le panneau qui va porter les objets graphiques
		Panneau panneau = new Panneau(listeUtilisateursAAfficher,nombreUtilisateurs);
		//On prÃ©vient notre JFrame que notre JPanel sera son content pane
		this.setContentPane(panneau);               

		this.setLayout(null);
		//rendre visible la fenÃªtre
		this.setVisible(true);
	}
}
