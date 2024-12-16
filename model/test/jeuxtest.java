package MTGames.model.test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.jeuxDao;
import MTGames.model.pojo.jeux;


//import java.sql.Date;

/**
 * 
 * @author SVO
 *
 */
public class jeuxtest {
public static void Jeuxtest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	jeuxDao jeuxDao = new jeuxDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<jeux> jeux = new ArrayList<>();

	// debut exo
	// Création 

	jeux newjeux = new jeux(1, String.valueOf("Dames"), 1);
	boolean creationResult = jeuxDao.create(newjeux);
	if (creationResult) {
		System.out.println("Nouveau jeux créé avec succès");
	} else {
		System.out.println("La création de jeuxDao a échoué");
	}

	// Mise à jour 

	newjeux.setnom("Dames");
	boolean updateResult = jeuxDao.update(newjeux);
	if (updateResult) {
		System.out.println("jeux mise à jour avec succès");
	} else {
		System.out.println("La mise à jour du jeux a échoué");
	}

	// Suppression 

	boolean deleteResult = jeuxDao.delete(newjeux);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	
	// fin exo
	jeux = jeuxDao.getAll();
	Iterator<jeux> iterator =  jeux.iterator();
	jeux currentjeux = null;
	while (iterator.hasNext()) {
		currentjeux = (jeux) iterator.next();
		System.out.println(currentjeux.getid_jeux()
				+" / "+currentjeux.getnom()
				+" / "+currentjeux.getid_image());
	}
	}

	

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
