package MTGames.model.test;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.PartieDao;
import MTGames.model.pojo.Partie;

/**
 * 
 * @authors MAC - SVO - YSA
 * Here's a POJO!
 *
 */
public class Partietest {
public static void partietest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	PartieDao PartieDao = new PartieDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<Partie> Partie = new ArrayList<>();

	// debut exo
	// Création 

	Partie newPartie = new Partie(1, 1, 1);
	boolean creationResult = PartieDao.create(newPartie);
	if (creationResult) {
		System.out.println("Nouveau jeux créé avec succès");
	} else {
		System.out.println("La création de jeuxDao a échoué");
	}

	// Mise à jour 

	newPartie.setId_Utilisateur(2);
	boolean updateResult = PartieDao.update(newPartie);
	if (updateResult) {
		System.out.println("jeux mise à jour avec succès");
	} else {
		System.out.println("La mise à jour du jeux a échoué");
	}

	// Suppression 

	boolean deleteResult = PartieDao.delete(newPartie);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	
	// fin exo
	Partie = PartieDao.getAll();
	Iterator<Partie> iterator = Partie.iterator();
	Partie currentPartie = null;
	while (iterator.hasNext()) {
		currentPartie = (Partie) iterator.next();
		System.out.println(currentPartie.getId_Partie()
				+" / "+currentPartie.getId_Utilisateur()
				+" / "+currentPartie.getId_Jeux());
	}
	}

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
