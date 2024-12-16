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

import MTGames.model.daointerface.ParticipeDaoInterface;
import MTGames.model.pojo.Participe;

/**
 * @author MAC
 *
 */
public class ParticipeDao implements ParticipeDaoInterface {
	private DataSource dataSource;
	private Connection connection;
	
	public ParticipeDao(DataSource dataSource) {
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
	public Collection <Participe> getAll() {
		// TODO Auto-generated method stub
		List<Participe> participeList = new ArrayList<>();
		
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM participe");

			while (resultSet.next()) {
				Participe currentParticipe = new Participe(resultSet.getInt(1), resultSet.getInt(2));
				participeList.add(currentParticipe);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participeList;
	}

	@Override
	public boolean create(Participe participe) {
		
	    if (getOne(participe.getId_Utilisateur()) != null) {
	        System.out.println("You lose ! L'utilisateur numéro " + participe.getId_Utilisateur() + " existe déjà !");
	        return false;
	    }
		
		String insertQuery = null;
		insertQuery = "INSERT INTO participe "
				//+ "(id_utilisateur, id_partie) "
				+ "VALUES ("+participe.getId_Utilisateur()+",'"+participe.getId_Partie()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("Parapente créé / Id : "+participe.getId_Utilisateur());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    
	    return true;
	}
	
    @Override
    public Participe getOne(int id_Utilisateur) {
        String selectQuery = "SELECT * FROM participe WHERE id_Utilisateur = ?";
        try {
            this.connection = getConnection(this.dataSource);
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id_Utilisateur);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Participe(resultSet.getInt("id_Utilisateur"), resultSet.getInt("id_Partie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
	@Override
	public boolean update(Participe participe) {
	    String updateQuery = "UPDATE participe SET id_Partie = ? WHERE id_Utilisateur = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setInt(1, participe.getId_Partie());
	        preparedStatement.setInt(2, participe.getId_Utilisateur());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean delete(Participe participe) {
	    String deleteQuery = "DELETE FROM participe WHERE id_Utilisateur = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, participe.getId_Utilisateur());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
