package MTGames;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.imageDao;
import MTGames.model.pojo.image;

import MTGames.model.dao.jeuxDao;
import MTGames.model.pojo.jeux;

import MTGames.model.dao.utilisateurDao;
import MTGames.model.pojo.utilisateur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class Main {

	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//		// TODO Auto-generated method stub
	//		JOptionPane.showMessageDialog(null, "Gestion du garage / gestion des Utilisateurs");
	//		
	//		System.out.println("////////////////////////////////////");
	//		System.out.println("Test de la connexion Ã  la base MySQL");
	//		try {
	//			//Class.forName("com.mysql.jdbc");
	//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mtgames","root","");
	//			System.out.println("Connexion rÃ©ussie !!");
	//			System.out.println("////////////////////////////////////");
	//			int id_Utilisateurs = -1;
	//			String Pseudo;
	//			String Mail;
	//			String Mdp;
	//			
	//			String[] listeUtilisateursAAfficher = new String[100];
	//			int noUtilisateurs = 0;
	//			
	//			System.out.println("LECTURE TABLE Uutilisateur");
	//			Statement statementUtilisateur = con.createStatement();
	//			ResultSet resultSetUtilisateur = statementUtilisateur.executeQuery("select * FROM utilisateur");
	//			while (resultSetUtilisateur.next()) {
	//				System.out.println("LIGNE "+resultSetUtilisateur.getRow()+":");
	//				id_Utilisateurs = resultSetUtilisateur.getInt(1);
	//				Pseudo = resultSetUtilisateur.getString(2);
	//				Mail = resultSetUtilisateur.getString(3);
	//				Mdp = resultSetUtilisateur.getString(4);
	//				System.out.println(id_Utilisateurs+" / "+Mail+" / "+Mdp);
	//				System.out.println("LECTURE TABLE utilisateur");
	//				listeUtilisateursAAfficher[noUtilisateurs]=Pseudo;
	//				Statement statementChoixUtilisateur = con.createStatement();
	//				ResultSet resultSetChoixUtilisateur = statementChoixUtilisateur.executeQuery("select * FROM utilisateur where id_Utilisateurs = "+id_Utilisateurs);					
	//				}
	//				noUtilisateurs++;
	//			
	//			
	//			///// CREATION DE LA FENETRE - DEBUT
	//		    FenetreUtilisateurs laFenetreUtilisateurs = new FenetreUtilisateurs(listeUtilisateursAAfficher,noUtilisateurs);
	//	        // Ajouter un bouton de validation
	//	        JButton leBoutonValider = new JButton("--OK");
	//	        leBoutonValider.setBounds(270, 130, 70, 20);
	//	        laFenetreUtilisateurs.add(leBoutonValider);
	//	        
	//	        leBoutonValider.addActionListener(new ActionListener()
	//	        {
	//	          public void actionPerformed(ActionEvent e)
	//	          {
	//	            //afficher le Jdialog lorsque le bouton est cliquÃ©
	//	            JDialog dialog = new JDialog(laFenetreUtilisateurs, "C'es ValidÃ©", true);
	//	            dialog.setLocationRelativeTo(laFenetreUtilisateurs);
	//	            dialog.setVisible(true);
	//	          }
	//	        });
	//		    ///// CREATION DE LA FENETRE - FIN
	//		    
	//			System.out.println("////////////////////////////////////");
	//		} catch (Exception e) {
	//			// TODO: handle exception
	//			System.out.println(e);
	//		}
	//	}
	//	
	//	static void afficherResultat(String Pseudo) {
	//		JOptionPane.showMessageDialog(null, "L'Utilisateur "+ Pseudo);
	//	}
	//}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final DataSource dataSource = createDataSource();
		// Instanciation du data access object image et jeux
		imageDao imageDao = new imageDao(dataSource);
		jeuxDao jeuxDao = new jeuxDao(dataSource);
		utilisateurDao utilisateurDao = new utilisateurDao(dataSource);

		//Lecture de tous les image et jeux
		Collection<image> image = new ArrayList<>();
		Collection<jeux> jeux = new ArrayList<>();
		Collection<utilisateur> utilisateur = new ArrayList<>();

		// debut exo
		// Création 
		image newimage = new image(1,"Dames" ,"18px" ,"html" ,"url://");
		boolean creationResult = imageDao.create(newimage);
		if (creationResult) {
			System.out.println("Nouvelle image créé avec succès");
		} else {
			System.out.println("La création de l'imageDao a échoué");
		}

		jeux newjeux = new jeux(1, String.valueOf("Dames"), 1);
		creationResult = jeuxDao.create(newjeux);
		if (creationResult) {
			System.out.println("Nouveau jeux créé avec succès");
		} else {
			System.out.println("La création de jeuxDao a échoué");
		}
		
		utilisateur newutilisateur = new utilisateur(1 ,"u" ,"u" ,"u",1,1,1);
		creationResult = utilisateurDao.create(newutilisateur);
		if (creationResult) {
			System.out.println("Nouvelle image créé avec succès");
		} else {
			System.out.println("La création de l'imageDao a échoué");
		}

		// Mise à jour 
		newimage.setnom("icone_Dames");
		boolean updateResult = imageDao.update(newimage);
		if (updateResult) {
			System.out.println("image mise à jour avec succès");
		} else {
			System.out.println("La mise à jour de l'image a échoué");
		}

		newjeux.setnom("Dames");
		updateResult = jeuxDao.update(newjeux);
		if (updateResult) {
			System.out.println("jeux mise à jour avec succès");
		} else {
			System.out.println("La mise à jour du jeux a échoué");
		}
		
		newutilisateur.setpseudo("Dames");
		updateResult = utilisateurDao.update(newutilisateur);
		if (updateResult) {
			System.out.println("utilisateur mise à jour avec succès");
		} else {
			System.out.println("La mise à jour de l'utilisateur a échoué");
		}

		// Suppression 
		boolean deleteResult = imageDao.delete(newimage);
		if (deleteResult) {
			System.out.println("image supprimé avec succès");
		} else {
			System.out.println("La suppression de l'image a échoué");
		}

		deleteResult = jeuxDao.delete(newjeux);
		if (deleteResult) {
			System.out.println("jeux supprimé avec succès");
		} else {
			System.out.println("La suppression du jeux a échoué");
		}
		
		deleteResult = utilisateurDao.delete(newutilisateur);
		if (deleteResult) {
			System.out.println("jeux supprimé avec succès");
		} else {
			System.out.println("La suppression du jeux a échoué");
		}
		// fin exo

		image = imageDao.getAll();
		Iterator<image> iterator =  image.iterator();
		image currentimage = null;
		while (iterator.hasNext()) {
			currentimage = (image) iterator.next();
			System.out.println(currentimage.getId_image()
					+" / "+currentimage.getnom()
					+" / "+currentimage.gettaille()
					+" / "+currentimage.gettype()
					+" / "+currentimage.getblob());

		jeux = jeuxDao.getAll();
		Iterator<jeux> iterator1 =  jeux.iterator();
		jeux currentjeux = null;
		while (iterator1.hasNext()) {
			currentjeux = (jeux) iterator1.next();
			System.out.println(currentjeux.getid_jeux()
					+" / "+currentjeux.getnom()
					+" / "+currentjeux.getid_image());
				
		utilisateur = utilisateurDao.getAll();
		Iterator<utilisateur> iterator2 =  utilisateur.iterator();
		utilisateur currentutilisateur = null;
			while (iterator2.hasNext()) {
				currentutilisateur = (utilisateur) iterator2.next();
				System.out.println(currentutilisateur.getid_utilisateur()
						+" / "+currentutilisateur.getpseudo()
						+" / "+currentutilisateur.getmail()
						+" / "+currentutilisateur.getmdp()
						+" / "+currentutilisateur.getId_image()
						+" / "+currentutilisateur.getid_parametre()
						+" / "+currentutilisateur.getid_profil_utilisateur());
				}
		}
		}

		}

		private static DataSource createDataSource() {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setURL("jdbc:mysql://localhost:3306/mtgames");
			return dataSource;
		}

	}
