package MTGames.model.test;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.ScoreDao;
import MTGames.model.pojo.Score;

//import java.sql.Date;

/**
 * 
 * @author SVO
 *
 */
public class Scoretest {
public static void scoretest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	ScoreDao ScoreDao = new ScoreDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<Score> Score = new ArrayList<>();

	// debut exo
	// Création 

	Score newScore = new Score(1, 1);
	boolean creationResult = ScoreDao.create(newScore);
	if (creationResult) {
		System.out.println("Nouveau jeux créé avec succès");
	} else {
		System.out.println("La création de jeuxDao a échoué");
	}

	// Mise à jour 

	newScore.setId_Score(3);
	boolean updateResult = ScoreDao.update(newScore);
	if (updateResult) {
		System.out.println("jeux mise à jour avec succès");
	} else {
		System.out.println("La mise à jour du jeux a échoué");
	}

	// Suppression 

	boolean deleteResult = ScoreDao.delete(newScore);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	
	// fin exo
	Score = ScoreDao.getAll();
	Iterator<Score> iterator =  Score.iterator();
	Score currentjeux = null;
	while (iterator.hasNext()) {
		currentjeux = (Score) iterator.next();
		System.out.println(currentjeux.getId_Score()
				+" / "+currentjeux.getId_Partie());
	}
	}

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
