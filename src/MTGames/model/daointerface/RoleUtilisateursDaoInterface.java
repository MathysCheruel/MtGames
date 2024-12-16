package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.RoleUtilisateurs;
public interface RoleUtilisateursDaoInterface {

	/**
	 * Get a Collection of all existing Partie objects
	 * @return
	 */
	Collection <RoleUtilisateurs> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param role_utilisateurs
	 * @return
	 */
	boolean create(RoleUtilisateurs roleutilisateurs);
	/**
	 * READ
	 * @param id_ProfilUtilisateurs
	 * @return
	 */
	RoleUtilisateurs getOne(int Id);
	/**
	 * UPDATE
	 * @param role_utilisateurs
	 * @return
	 */
	boolean update(RoleUtilisateurs roleutilisateurs);
	/**
	 * UPDATE
	 * @param role_utilisateurs
	 * @return
	 */
	boolean delete(RoleUtilisateurs roleutilisateurs);

}
