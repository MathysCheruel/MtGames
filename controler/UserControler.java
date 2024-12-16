/**
 * 
 */
package MTGames.controler;

import java.sql.SQLException;
import java.util.Map;

import MTGames.model.dao.utilisateurDao;
import MTGames.model.pojo.utilisateur;
import MTGames.utilities.AppConstant;

/**
 * @author MCH
 * 
 */
public class UserControler {

	private utilisateurDao userDao = null;

	/**
	 * Contructeur par défaut. Initialise userDao avec le datasource configuré
	 */
	public UserControler() {
		userDao = new utilisateurDao(AppConstant.dataSource);
	}

	public boolean createUser(int id_utilisateur, String pseudo,String mail,String mdp,int id_image,int id_parametre ,int id_profil_utilisateur) throws SQLException {
		utilisateur user = new utilisateur(id_utilisateur, pseudo, mail, mdp,id_image,id_parametre ,id_profil_utilisateur);
		return userDao.create(user);
	}

	public boolean updateUser(int id_utilisateur, String pseudo,String mail,String mdp,int id_image,int id_parametre ,int id_profil_utilisateur) throws SQLException {
		utilisateur user = new utilisateur(id_utilisateur, pseudo, mail, mdp,id_image,id_parametre ,id_profil_utilisateur);
		return userDao.update(user);
	}

}
