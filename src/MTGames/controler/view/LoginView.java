package MTGames.controler.view;

import MTGames.controler.LoginControler;

/**
 * 
 * @author MCH Objet : couche d'abstraction pour séparer la couche vue de la
 *         couche controler Classe abstraite manipulée par le controler et dont
 *         l'écran correspondant LoginScreen hérite
 */
public abstract class LoginView {
	private LoginControler loginControler = null;

	public LoginView(LoginControler loginControler) {
		super();
		this.loginControler = loginControler;
	}

	public final LoginControler geLoginControler() {
		return loginControler;
	}

	public abstract void display();

	public abstract void close();
}
