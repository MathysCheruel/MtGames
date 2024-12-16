package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.Partie;
public interface PartieDaoInterface {

	/**
	 * Get a Collection of all existing Partie objects
	 * @return
	 */
	Collection <Partie> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param partie
	 * @return
	 */
	boolean create(Partie partie);
	/**
	 * READ
	 * @param Id_Partie
	 * @return
	 */
	Partie getOne(int Id);
	/**
	 * UPDATE
	 * @param partie
	 * @return
	 */
	boolean update(Partie partie);
	/**
	 * UPDATE
	 * @param partie
	 * @return
	 */
	boolean delete(Partie partie);

}
