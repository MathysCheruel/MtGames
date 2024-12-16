package MTGames.utilities;

import com.mysql.cj.jdbc.MysqlDataSource;

public interface AppConstant {
	public final String APP_DATABASE_USER = "root";
	public final String APP_DATABASE_USER_PASSWORD = "";
	public final String APP_DATABASE_URL = "jdbc:mysql://localhost:3306/sakila";
	public final MysqlDataSource dataSource = new MysqlDataSource();

	public final String APP_TITLE = "MyDemoSwingApp - Utilisateur connecté : ";
	public final String APP_TITLE_V2 = "MyDemoSwingApp - V2 - Utilisateur connecté : ";
	public final String APP_DEFAULT_USER = "aucun user connecté";

	public final String APP_PROFIL_ADMIN = "Administrateur";
	public final String APP_PROFIL_STANDARD = "Standard";
	public final int APP_PROFIL_STANDARD_ID = 1;
	public final int APP_PROFIL_ADMIN_ID = 2;

	public final String APP_MESSAGE_LOGIN_EXISTS = "LOGIN déjà existant, merci de modifier votre saisie!";
	public final String APP_MESSAGE_USER_INEXISTANT = "L'utilisateur que vous tentez de modifier/supprimer n'existe plus!";
	public final String APP_MESSAGE_TECHNICAL_ERROR = "Une erreur technique est survenue!!!!";

	public final String LIST_SEPARATOR = " / ";

	public final String USER_PANEL_MODE_CONSULTATION = "C";
	public final String USER_PANEL_MODE_MODIFICATION = "U";
}
