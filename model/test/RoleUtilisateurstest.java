package MTGames.model.test;

//import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.RoleUtilisateursDao;
import MTGames.model.pojo.RoleUtilisateurs;

//import java.sql.Date;

/**
 * 
 * @author MAC
 * Here's a POJO!
 *
 */
public class RoleUtilisateurstest {
public static void roleutilisateurtest(String[] args) {
	// TODO Auto-generated method stub
	final DataSource dataSource = createDataSource();
	// Instanciation du data access object image et jeux
	RoleUtilisateursDao RoleUtilisateursDao = new RoleUtilisateursDao(dataSource);

	//Lecture de tous les image et jeux
	Collection<RoleUtilisateurs> RoleUtilisateurs = new ArrayList<>();

	// debut exo
	// Création 

	RoleUtilisateurs newRoleUtilisateurs = new RoleUtilisateurs(1, String.valueOf("Dames"));
	boolean creationResult = RoleUtilisateursDao.create(newRoleUtilisateurs);
	if (creationResult) {
		System.out.println("Nouveau jeux créé avec succès");
	} else {
		System.out.println("La création de jeuxDao a échoué");
	}

	// Mise à jour 

	newRoleUtilisateurs.setnom("Dames");
	boolean updateResult = RoleUtilisateursDao.update(newRoleUtilisateurs);
	if (updateResult) {
		System.out.println("jeux mise à jour avec succès");
	} else {
		System.out.println("La mise à jour du jeux a échoué");
	}

	// Suppression 

	boolean deleteResult = RoleUtilisateursDao.delete(newRoleUtilisateurs);
	if (deleteResult) {
		System.out.println("jeux supprimé avec succès");
	} else {
		System.out.println("La suppression du jeux a échoué");
	}
	
	// fin exo
	RoleUtilisateurs = RoleUtilisateursDao.getAll();
	Iterator<RoleUtilisateurs> iterator =  RoleUtilisateurs.iterator();
	RoleUtilisateurs currentRoleUtilisateurs = null;
	while (iterator.hasNext()) {
		currentRoleUtilisateurs = (RoleUtilisateurs) iterator.next();
		System.out.println(currentRoleUtilisateurs.getId_ProfilUtilisateurs()
				+" / "+currentRoleUtilisateurs.getnom());
	}
	}

	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

}
