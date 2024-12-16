package MTGames.utilities;

import MTGames.model.pojo.utilisateur;

/**
 * 
 * @author MCH Classe permettant de stocker un ensemble de données contextuelles
 *         nécessaires à la mise en oeuvre de l'application (ex: le user
 *         connecté) Il s'agit d'un Singleton : une seule instance existe au
 *         maximum
 */
public final class AppSession {
	private static AppSession instance;

	private String userLogin = "";
	private utilisateur currentUser = null;
	private utilisateur userToModify = null;
	private String messageToDisplay = "Appelez le support";

	// Contructeur private appelé dans méthode(s) getInstance
	private AppSession() {

	}

	/**
	 * 
	 * @return single instance of AppSession
	 */
	public static AppSession getInstance() {
		if (instance == null) {
			// Instancier la classe
			instance = new AppSession();
		}
		return instance;
	}
	
	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String user) {
		this.userLogin = user;
	}

	public utilisateur getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(utilisateur currentUser) {
		this.currentUser = currentUser;
	}

	public final utilisateur getUserToModify() {
		return userToModify;
	}

	public final void setUserToModify(utilisateur userToModify) {
		this.userToModify = userToModify;
	}

	public String getMessageToDisplay() {
		return messageToDisplay;
	}

	public void setMessageToDisplay(String messageToDisplay) {
		this.messageToDisplay = messageToDisplay;
	}
}
