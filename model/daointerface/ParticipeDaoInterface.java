package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.Participe;
public interface ParticipeDaoInterface {

	/**
	 * Get a Collection of all existing Participe objects
	 * @return
	 */
	Collection <Participe> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param participe
	 * @return
	 */
	boolean create(Participe participe);
	/**
	 * READ
	 * @param Id_Participe
	 * @return
	 */
	Participe getOne(int Id);
	/**
	 * UPDATE
	 * @param participe
	 * @return
	 */
	boolean update(Participe participe);
	/**
	 * UPDATE
	 * @param participe
	 * @return
	 */
	boolean delete(Participe participe);

}
