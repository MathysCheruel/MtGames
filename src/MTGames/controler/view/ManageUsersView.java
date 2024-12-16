/**
 * 
 */
package MTGames.controler.view;

import MTGames.controler.ManageUsersControler;

/**
 * @author MCH
 *
 */
public abstract class ManageUsersView {
	private ManageUsersControler manageUsersControler = null;

	/**
	 * 
	 */
	public ManageUsersView(ManageUsersControler manageUsersControler) {
		super();
		this.manageUsersControler = manageUsersControler;
	}

	public final ManageUsersControler getManageUsersControler() {
		return manageUsersControler;
	}

	public final void setManageUsersControler(ManageUsersControler manageUsersControler) {
		this.manageUsersControler = manageUsersControler;
	}

	public abstract void display();

	public abstract void close();
}
