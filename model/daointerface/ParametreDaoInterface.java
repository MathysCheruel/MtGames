package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.Parametre;
public interface ParametreDaoInterface {

	/**
	 * Get a Collection of all existing Parametre objects
	 * @return
	 */
	Collection <Parametre> getAll();

	// CRUD methods
	/**
	 * READ
	 * @param Parametre
	 * @return
	 */
	boolean create(Parametre Parametre);
	/**
	 * READ
	 * @param Id_jeux
	 * @return
	 */
	Parametre getOne(int Id);
	/**
	 * UPDATE
	 * @param parametre
	 * @return
	 */
	boolean update(Parametre Parametre);
	/**
	 * UPDATE
	 * @param jeux
	 * @return
	 */
	boolean delete(Parametre Parametre);

	}
