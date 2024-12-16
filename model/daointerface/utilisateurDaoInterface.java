package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.utilisateur;
public interface utilisateurDaoInterface {

	/**
	 * Get a Collection of all existing image objects
	 * @return
	 */
	Collection <utilisateur> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param utilisateur
	 * @return
	 */
	boolean create(utilisateur utilisateur);
	/**
	 * READ
	 * @param id_utilisateur
	 * @return
	 */
	utilisateur getOne(int id_utilisateur);
	/**
	 * UPDATE
	 * @param utilisateur
	 * @return
	 */
	boolean update(utilisateur utilisateur);
	/**
	 * UPDATE
	 * @param utilisateur
	 * @return
	 */
	boolean delete(utilisateur utilisateur);

}
