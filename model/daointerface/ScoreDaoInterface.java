package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.Score;
public interface ScoreDaoInterface {

	/**
	 * Get a Collection of all existing Score objects
	 * @return
	 */
	Collection <Score> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param score
	 * @return
	 */
	boolean create(Score score);
	/**
	 * READ
	 * @param id_Score
	 * @return
	 */
	Score getOne(int Id);
	/**
	 * UPDATE
	 * @param score
	 * @return
	 */
	boolean update(Score score);
	/**
	 * UPDATE
	 * @param score
	 * @return
	 */
	boolean delete(Score score);

}
