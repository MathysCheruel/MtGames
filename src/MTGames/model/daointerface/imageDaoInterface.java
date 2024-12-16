package MTGames.model.daointerface;

import java.util.Collection;
import MTGames.model.pojo.image;
public interface imageDaoInterface {

	/**
	 * Get a Collection of all existing image objects
	 * @return
	 */
	Collection <image> getAll();

	// CRUD methods
	/**
	 * CREATE
	 * @param image
	 * @return
	 */
	boolean create(image image);
	/**
	 * READ
	 * @param id_image
	 * @return
	 */
	image getOne(int id_image);
	/**
	 * UPDATE
	 * @param image
	 * @return
	 */
	boolean update(image image);
	/**
	 * UPDATE
	 * @param image
	 * @return
	 */
	boolean delete(image image);

}
