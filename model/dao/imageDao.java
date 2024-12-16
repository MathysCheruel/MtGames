/**
 * 
 */
package MTGames.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import MTGames.model.daointerface.imageDaoInterface;
import MTGames.model.pojo.image;

/**
 * @author SVO
 *
 */
public class imageDao implements imageDaoInterface {
	private DataSource dataSource;
	private Connection connection;

	public imageDao(DataSource dataSource) {
		super();
		this.dataSource=dataSource;
		// TODO Auto-generated constructor stub
	}

	// Gestion de la connexion
	private Connection getConnection(DataSource dataSource) throws SQLException {
		return this.dataSource.getConnection("root","");
	}

	private void closeConnection() throws SQLException {
		this.connection.close();
	}

	// Implémentation des méthodes de l'interface
	@Override
	public Collection <image> getAll() {
		// TODO Auto-generated method stub
		List<image> imageList = new ArrayList<>();

		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM image");

			while (resultSet.next()) {
				System.out.println("Alimentation objet image avec ligne : "+resultSet.getRow()+":");
				image currentimage = new image(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5) );
				imageList.add(currentimage);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageList;
	}

	@Override
	public boolean create(image image) {

		if (getOne(image.getId_image()) != null) {
			System.out.println("You lose ! L' image id " + image.getId_image() + " existe déjà !");
			return false;
		}

		String insertQuery = null;
		insertQuery = "INSERT INTO image "
				//+ "(numero, date_mise_en_service, couleur_principale) "
				+ "VALUES ("+image.getId_image()+",'"+image.getnom()+"','"+image.gettaille()+"','"+image.gettype()+"','"+image.getblob()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("image créé / Id : "+image.getId_image());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public image getOne(int id) {
		String selectQuery = "SELECT * FROM image WHERE Id_Image = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new image(resultSet.getInt("id_image"), resultSet.getString("nom"), resultSet.getString("taille"), resultSet.getString("type"), resultSet.getString("blob"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean update(image image) {
		String updateQuery = "UPDATE image SET Nom = ?, Taille = ?, Type = ?, Img_Blob = ? WHERE Id_Image";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, image.getId_image());
			preparedStatement.setString(2, image.getnom());
			preparedStatement.setString(3, image.gettaille());
			preparedStatement.setString(4, image.gettype());
			preparedStatement.setString(5, image.getblob());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(image image) {
		String deleteQuery = "DELETE FROM image WHERE Id_Image = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, image.getId_image());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	//L'utilisation de PreparedStatement pour éviter les injections SQL et manipuler les requêtes de manière plus sûre.
	//La méthode getOne est utilisée pour vérifier l'existence d'un parapente avant la création, et la méthode create renvoie un booléen indiquant le succès ou l'échec de l'opération.
	//La gestion des exceptions avec des blocs try-catch pour attraper les erreurs SQL.

}
