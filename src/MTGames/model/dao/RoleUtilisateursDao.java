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

import MTGames.model.daointerface.RoleUtilisateursDaoInterface;
import MTGames.model.pojo.RoleUtilisateurs;

/**
 * @author MAC
 *
 */
public class RoleUtilisateursDao implements RoleUtilisateursDaoInterface {
	private DataSource dataSource;
	private Connection connection;
	
	public RoleUtilisateursDao(DataSource dataSource) {
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
	public Collection <RoleUtilisateurs> getAll() {
		// TODO Auto-generated method stub
		List<RoleUtilisateurs> roleUtilisateursList = new ArrayList<>();
		
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM partie");

			while (resultSet.next()) {
				RoleUtilisateurs currentRoleUtilisateurs = new RoleUtilisateurs(resultSet.getInt(1), resultSet.getString(2));
				roleUtilisateursList.add(currentRoleUtilisateurs);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return roleUtilisateursList;
	}

	@Override
	public boolean create(RoleUtilisateurs roleUtilisateurs) {
		
	    if (getOne(roleUtilisateurs.getId_ProfilUtilisateurs()) != null) {
	        System.out.println("You lose ! L'id profil utilisateur numéro " + roleUtilisateurs.getId_ProfilUtilisateurs() + " existe déjà !");
	        return false;
	    }
		
		String insertQuery = null;
		insertQuery = "INSERT INTO partie "
				//+ "(id_ProfilUtilisateurs, nom) "
				+ "VALUES ("+roleUtilisateurs.getId_ProfilUtilisateurs()+",'"+roleUtilisateurs.getnom()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("Profil utilisateurs créée / Id : "+roleUtilisateurs.getId_ProfilUtilisateurs());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    
	    return true;
	}
	
    @Override
    public RoleUtilisateurs getOne(int id_ProfilUtilisateurs) {
        String selectQuery = "SELECT * FROM role_utilisateurs WHERE id_ProfilUtilisateurs = ?";
        try {
            this.connection = getConnection(this.dataSource);
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id_ProfilUtilisateurs);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new RoleUtilisateurs(resultSet.getInt("id_ProfilUtilisateurs"), resultSet.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
	@Override
	public boolean update(RoleUtilisateurs roleUtilisateurs) {
	    String updateQuery = "UPDATE role_utilisateurs SET nom = ? WHERE id_ProfilUtilisateurs = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, roleUtilisateurs.getnom());
	        preparedStatement.setInt(2, roleUtilisateurs.getId_ProfilUtilisateurs());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean delete(RoleUtilisateurs roleUtilisateurs) {
	    String deleteQuery = "DELETE FROM role_utilisateurs WHERE id_ProfilUtilisateurs = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, roleUtilisateurs.getId_ProfilUtilisateurs());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
