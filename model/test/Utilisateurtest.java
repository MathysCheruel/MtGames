package MTGames.model.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.utilisateurDao;
import MTGames.model.pojo.utilisateur;

/**
 * 
 * @author SVO
 *
 */
public class Utilisateurtest {
public static void utilisateurtest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	utilisateurDao utilisateurDao = new utilisateurDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<utilisateur> utilisateur = new ArrayList<>();

	// debut exo
	// Création	
	utilisateur newutilisateur = new utilisateur(1 ,"u" ,"u" ,"u",1,1,1);
	boolean creationResult = utilisateurDao.create(newutilisateur);
	if (creationResult) {
		System.out.println("Nouvelle image créé avec succès");
	} else {
		System.out.println("La création de l'imageDao a échoué");
	}

	// Mise à jour 
	newutilisateur.setpseudo("Dames");
	boolean updateResult = utilisateurDao.update(newutilisateur);
	if (updateResult) {
		System.out.println("utilisateur mise à jour avec succès");
	} else {
		System.out.println("La mise à jour de l'utilisateur a échoué");
	}

	// Suppression 
	boolean deleteResult = utilisateurDao.delete(newutilisateur);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	// fin exo		
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

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
