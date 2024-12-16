/**
 * 
 */
package MTGames.controler;

import java.sql.SQLException;
import java.util.Collection;

import MTGames.controler.view.ManageUsersView;
import MTGames.model.dao.utilisateurDao;
import MTGames.model.pojo.utilisateur;
import MTGames.utilities.AppConstant;
import MTGames.view.screen.ManageScoreScreen;

/**
 * @author MCH
 *
 */
public class ScoreUsersControler {

	private ManageUsersView manageUsersView = null;
	private utilisateurDao userDao = null;

	/**
	 * 
	 */
	public ScoreUsersControler() {
		userDao = new utilisateurDao(AppConstant.dataSource);
	}

	public void showManageUsersView() throws SQLException {
		manageUsersView = new ManageScoreScreen(this);
		manageUsersView.display();
	}

	public Collection<utilisateur> getUsers() throws SQLException {
		Collection<utilisateur> usersList = null;
		usersList = userDao.getAll();
		return usersList;
	}

	public utilisateur getUserById(int id) throws SQLException {
		utilisateur user = null;
		user = userDao.getOne(id);
		return user;
	}

	public boolean deleteUser(utilisateur user) throws SQLException {
		return userDao.delete(user);
	}
}
