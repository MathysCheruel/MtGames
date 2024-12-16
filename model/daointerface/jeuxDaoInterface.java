package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.jeux;
public interface jeuxDaoInterface {

	/**
	 * Get a Collection of all existing jeux objects
	 * @return
	 */
	Collection <jeux> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param jeux
	 * @return
	 */
	boolean create(jeux jeux);
	/**
	 * READ
	 * @param Id_jeux
	 * @return
	 */
	jeux getOne(int id_jeux);
	/**
	 * UPDATE
	 * @param jeux
	 * @return
	 */
	boolean update(jeux jeux);
	/**
	 * UPDATE
	 * @param jeux
	 * @return
	 */
	boolean delete(jeux jeux);

}
