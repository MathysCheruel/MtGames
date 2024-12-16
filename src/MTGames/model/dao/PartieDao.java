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

import MTGames.model.daointerface.PartieDaoInterface;
import MTGames.model.pojo.Partie;

/**
 * @author MAC
 *
 */
public class PartieDao implements PartieDaoInterface {
	private DataSource dataSource;
	private Connection connection;
	
	public PartieDao(DataSource dataSource) {
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
	public Collection <Partie> getAll() {
		// TODO Auto-generated method stub
		List<Partie> partieList = new ArrayList<>();
		
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM partie");

			while (resultSet.next()) {
				Partie currentPartie = new Partie(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
				partieList.add(currentPartie);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return partieList;
	}

	@Override
	public boolean create(Partie partie) {
		
	    if (getOne(partie.getId_Partie()) != null) {
	        System.out.println("You lose ! La partie numéro " + partie.getId_Partie() + " existe déjà !");
	        return false;
	    }
		
		String insertQuery = null;
		insertQuery = "INSERT INTO partie "
				//+ "(id_partie, id_utilisateur, id_jeux) "
				+ "VALUES ("+partie.getId_Partie()+",'"+partie.getId_Utilisateur()+"','"+partie.getId_Jeux()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("Partie créée / Id : "+partie.getId_Partie());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    
	    return true;
	}
	
    @Override
    public Partie getOne(int id_Partie) {
        String selectQuery = "SELECT * FROM participe WHERE id_Partie = ?";
        try {
            this.connection = getConnection(this.dataSource);
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id_Partie);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Partie(resultSet.getInt("id_Partie"), resultSet.getInt("id_Utilisateur"), resultSet.getInt("id_Jeux"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
	@Override
	public boolean update(Partie partie) {
	    String updateQuery = "UPDATE partie SET id_Utilisateur = ?, id_Jeux = ? WHERE id_Partie = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setInt(1, partie.getId_Utilisateur());
	        preparedStatement.setInt(2, partie.getId_Jeux());
	        preparedStatement.setInt(3, partie.getId_Partie());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean delete(Partie partie) {
	    String deleteQuery = "DELETE FROM partie WHERE id_Partie = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, partie.getId_Partie());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
