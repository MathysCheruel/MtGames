package MTGames.model.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

import MTGames.model.dao.imageDao;
import MTGames.model.pojo.image;


/**
 * 
 * @author SVO
 *
 */
public class imagetest {
	public static void Imagetest (String[] args) {
		// TODO Auto-generated method stub
		final DataSource dataSource = createDataSource();
		// Instanciation du data access object image
		imageDao imageDao = new imageDao(dataSource);

		//Lecture de tous les image et jeux
		Collection<image> image = new ArrayList<>();

		// debut exo
		// Création 
		image newimage = new image(1,"Dames" ,"18px" ,"html" ,"url://");
		boolean creationResult = imageDao.create(newimage);
		if (creationResult) {
			System.out.println("Nouvelle image créé avec succès");
		} else {
			System.out.println("La création de l'imageDao a échoué");
		}

	// Mise à jour 
	newimage.setnom("icone_Dames");
	boolean updateResult = imageDao.update(newimage);
	if (updateResult) {
		System.out.println("image mise à jour avec succès");
	} else {
		System.out.println("La mise à jour de l'image a échoué");
	}

	// Suppression 
	boolean deleteResult = imageDao.delete(newimage);
	if (deleteResult) {
		System.out.println("image supprimé avec succès");
	} else {
		System.out.println("La suppression de l'image a échoué");
	}
	// fin exo

	image = imageDao.getAll();
	Iterator<image> iterator =  image.iterator();
	image currentimage = null;
	while (iterator.hasNext()) {
		currentimage = (image) iterator.next();
		System.out.println(currentimage.getId_image()
				+" / "+currentimage.getnom()
				+" / "+currentimage.gettaille()
				+" / "+currentimage.gettype()
				+" / "+currentimage.getblob());

	}
	}
	private static DataSource createDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/stage8");
		return dataSource;
	}

	
}
