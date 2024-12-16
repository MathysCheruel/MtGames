package MTGames.model.test;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.ParametreDao;
import MTGames.model.pojo.Parametre;

/**
 * 
 * @authors SVO
 *
 */
public class Parametretest {
public static void parametretest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	ParametreDao ParametreDao = new ParametreDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<Parametre> parametre = new ArrayList<>();

	// debut exo
	// Création 

	Parametre newparametre = new Parametre(1, 3, "oui");
	boolean creationResult = ParametreDao.create(newparametre);
	if (creationResult) {
		System.out.println("Nouveau jeux créé avec succès");
	} else {
		System.out.println("La création de jeuxDao a échoué");
	}

	// Mise à jour 

	newparametre.setAccessibilite("non");
	boolean updateResult = ParametreDao.update(newparametre);
	if (updateResult) {
		System.out.println("jeux mise à jour avec succès");
	} else {
		System.out.println("La mise à jour du jeux a échoué");
	}

	// Suppression 

	boolean deleteResult = ParametreDao.delete(newparametre);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	
	// fin exo
	parametre = ParametreDao.getAll();
	Iterator<Parametre> iterator =  parametre.iterator();
	Parametre currentparametre = null;
	while (iterator.hasNext()) {
		currentparametre = (Parametre) iterator.next();
		System.out.println(currentparametre.getId_Parametre()
				+" / "+currentparametre.getSon()
				+" / "+currentparametre.getAccessibilite());
	}
	}

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
