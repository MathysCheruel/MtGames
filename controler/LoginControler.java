/**
 * 
 */
package MTGames.controler;

import java.sql.SQLException;

import MTGames.controler.view.LoginView;
import MTGames.model.dao.utilisateurDao;
import MTGames.model.pojo.utilisateur;
import MTGames.utilities.AppConstant;
import MTGames.utilities.AppSession;
import MTGames.view.screen.LoginScreen;

/**
 * @author MCH Controler associé à l'écran de login LoginScreen
 */
public class LoginControler {
	private LoginView loginView = null;
	private utilisateurDao userDao = null;

	/**
	 * Contructeur par défaut. Initialise userDao avec le datasource configuré
	 */
	public LoginControler() {
		userDao = new utilisateurDao(AppConstant.dataSource);
	}

	/**
	 * Objet : afficher l'écran LoginScreen via une instance de LoginView (classe
	 * abstraite permettant de découpler les couches view et controler)
	 * 
	 */
	public void showLoginView() {
		loginView = new LoginScreen(this);
		loginView.display();
	}

	/**
	 * Objet : vérifier les credentials renseignés par l'utilisateur Return : true
	 * si les credentials sont OK, false si KO.
	 * 
	 */
	public boolean doLogin(String login, String password) {
		boolean isCredentialsOk = false;
		try {
			utilisateur userFound = userDao.getByLoginAndPaswword(login, password);
			if (userFound != null && userFound.getpseudo().equals(login) && userFound.getmdp().equals(password)) {
				System.out.println("LOGIN SUCESSFULL");
				// Stockage User en session
				AppSession.getInstance().setCurrentUser(userFound);
				isCredentialsOk = true;
			} else {
				System.out.println("USER OU PASSWORD KO");
			}
			return isCredentialsOk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return isCredentialsOk;
		}
	}

}
