package MTGames.model.test;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.ParticipeDao;
import MTGames.model.pojo.Participe;

/**
 * 
 * @authors MAC - SVO - YSA
 * Here's a POJO!
 *
 */
public class Participetest {
public static void participetest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	ParticipeDao participeDao = new ParticipeDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<Participe> participe = new ArrayList<>();

	// debut exo
	// Création 

	Participe newparticipe = new Participe(1, 1);
	boolean creationResult = participeDao.create(newparticipe);
	if (creationResult) {
		System.out.println("Nouveau jeux créé avec succès");
	} else {
		System.out.println("La création de jeuxDao a échoué");
	}

	// Mise à jour 

	newparticipe.setId_Utilisateur(16);
	boolean updateResult = participeDao.update(newparticipe);
	if (updateResult) {
		System.out.println("jeux mise à jour avec succès");
	} else {
		System.out.println("La mise à jour du jeux a échoué");
	}

	// Suppression 

	boolean deleteResult = participeDao.delete(newparticipe);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	
	// fin exo
	participe = participeDao.getAll();
	Iterator<Participe> iterator =  participe.iterator();
	Participe currentParticipe = null;
	while (iterator.hasNext()) {
		currentParticipe = (Participe) iterator.next();
		System.out.println(currentParticipe.getId_Utilisateur()
				+" / "+currentParticipe.getId_Partie());
	}
	}

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
