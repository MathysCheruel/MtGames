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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import MTGames.model.daointerface.utilisateurDaoInterface;
import MTGames.model.pojo.utilisateur;

/**
 * @author SVO
 *
 */
public class utilisateurDao implements utilisateurDaoInterface {
	private DataSource dataSource;
	private Connection connection;

	public utilisateurDao(DataSource dataSource) {
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
	public Collection <utilisateur> getAll() {
		// TODO Auto-generated method stub
		List<utilisateur> utilisateurList = new ArrayList<>();

		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM utilisateur");

			while (resultSet.next()) {
				System.out.println("Alimentation objet utilisateur avec ligne : "+resultSet.getRow()+":");
				utilisateur currentutilisateur = new utilisateur(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7));
				utilisateurList.add(currentutilisateur);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utilisateurList;
	}

	@Override
	public boolean create(utilisateur utilisateur) {

		if (getOne(utilisateur.getid_utilisateur()) != null) {
			System.out.println("You lose ! L'utilisateur id " + utilisateur.getid_utilisateur() + " existe déjà !");
			return false;
		}

		String insertQuery = null;
		insertQuery = "INSERT INTO Utilisateur "
				//+ "(numero, date_mise_en_service, couleur_principale) "
				+ "VALUES ("+utilisateur.getid_utilisateur()+",'"+utilisateur.getpseudo()+"','"+utilisateur.getmail()+"','"+utilisateur.getmdp()+"','"+utilisateur.getId_image()+"','"+utilisateur.getid_parametre()+"','"+utilisateur.getid_profil_utilisateur()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("Utilisateur créé / Id : "+utilisateur.getid_utilisateur());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public utilisateur getOne(int id_Utilisateur) {
		String selectQuery = "SELECT * FROM Utilisateur WHERE Id_Utilisateur = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, id_Utilisateur);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return new utilisateur(resultSet.getInt("id_Utilisateur"), resultSet.getString("pseudo"), resultSet.getString("mail"), resultSet.getString("mdp"), resultSet.getInt("id_image"), resultSet.getInt("id_parametre"), resultSet.getInt("id_profil_utilisateur"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean update(utilisateur utilisateur) {
		String updateQuery = "UPDATE Utilisateur SET pseudo = ?, mail = ?, mdp = ?, id_image = ?, id_parametre = ?, id_profil_utilisateur = ?, WHERE Id_Utilisateur = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setInt(1, utilisateur.getid_utilisateur());
			preparedStatement.setString(2, utilisateur.getpseudo());
			preparedStatement.setString(3, utilisateur.getmail());
			preparedStatement.setString(4, utilisateur.getmdp());
			preparedStatement.setInt(5, utilisateur.getId_image());
			preparedStatement.setInt(6, utilisateur.getid_parametre());
			preparedStatement.setObject(7, utilisateur.getid_profil_utilisateur());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(utilisateur utilisateur) {
		String deleteQuery = "DELETE FROM utilisateur WHERE Id_Utilisateur = ?";
		try {
			this.connection = getConnection(this.dataSource);
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, utilisateur.getid_utilisateur());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public utilisateur getByLoginAndPaswword(String login, String password) throws SQLException {
		String selectQuery = null;
		selectQuery = "SELECT * FROM USERS " + "WHERE LOGIN ='" + login + "' AND PASSWORD ='" + password + "';";
		System.out.println(selectQuery);
		Statement statement = null;
		utilisateur currentUser = null;
		try {
			this.connection = getConnection(this.dataSource);
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			if (resultSet.next()) {
				System.out.println("Alimentation objet avec ligne : " + resultSet.getRow());
				currentUser = new utilisateur (resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7) /*,new HashMap<String, Boolean>()*/);
				// Completer avec les profils associés
				selectQuery = "select u.USER_ID, p.LIBELLE from USERS u \r\n"
						+ "				INNER JOIN USERS_PROFIL up ON u.USER_ID = up.USER_ID\r\n"
						+ "				INNER JOIN PROFIL p on up.PROFIL_ID = p.PROFIL_ID\r\n" + "WHERE u.USER_ID = "
						+ currentUser.getid_utilisateur() + ";";
				System.out.println(selectQuery);
				resultSet = statement.executeQuery(selectQuery);
				while (resultSet.next()) {
					System.out.println("Alimentation objet avec ligne : " + resultSet.getRow());
				}
			}
				closeConnection();

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				if (statement != null) {
					statement.close();
				}
			}

			return currentUser;
		}
	}

	//L'utilisation de PreparedStatement pour éviter les injections SQL et manipuler les requêtes de manière plus sûre.
	//La méthode getOne est utilisée pour vérifier l'existence d'un parapente avant la création, et la méthode create renvoie un booléen indiquant le succès ou l'échec de l'opération.
	//La gestion des exceptions avec des blocs try-catch pour attraper les erreurs SQL.

	
