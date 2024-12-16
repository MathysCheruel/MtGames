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

import MTGames.model.daointerface.jeuxDaoInterface;
import MTGames.model.pojo.jeux;

/**
 * @author SVO
 *
 */
public class jeuxDao implements jeuxDaoInterface {
	private DataSource dataSource;
	private Connection connection;

	public jeuxDao(DataSource dataSource) {
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
	public Collection <jeux> getAll() {
		// TODO Auto-generated method stub
		List<jeux> jeuxList = new ArrayList<>();

		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM jeux");

			while (resultSet.next()) {
				System.out.println("Alimentation objet jeux avec ligne : "+resultSet.getRow()+":");
				jeux currentjeux = new jeux(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
				jeuxList.add(currentjeux);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jeuxList;
	}

	@Override
	public boolean create(jeux jeux) {

		if (getOne(jeux.getid_jeux()) != null) {
			System.out.println("You lose ! Le jeux id " + jeux.getid_jeux() + " existe déjà !");
			return false;
		}

		String insertQuery = null;
		insertQuery = "INSERT INTO jeux "
				//+ "(numero, date_mise_en_service, couleur_principale) "
				+ "VALUES ("+jeux.getid_jeux()+",'"+jeux.getnom()+"','"+jeux.getid_image()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("jeux créé / Id : "+jeux.getid_jeux());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public jeux getOne(int id_jeux) {
		String selectQuery = "SELECT * FROM jeux WHERE Id_Jeux = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, id_jeux);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new jeux(resultSet.getInt("id_jeux"), resultSet.getString("nom"), resultSet.getInt("id_image"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean update(jeux jeux) {
		String updateQuery = "UPDATE jeux SET nom = ?, id_image = ? WHERE id_jeux = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(2, jeux.getnom());
			preparedStatement.setInt(3, jeux.getid_image());
			preparedStatement.setInt(1, jeux.getid_jeux());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(jeux jeux) {
		String deleteQuery = "DELETE FROM jeux WHERE Id_Jeux = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, jeux.getid_jeux());
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
