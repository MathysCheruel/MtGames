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

import MTGames.model.daointerface.ParametreDaoInterface;
import MTGames.model.pojo.Parametre;

/**
 * @author MAC
 *
 */

public class ParametreDao implements ParametreDaoInterface {
	private DataSource dataSource;
	private Connection connection;
	
	public ParametreDao(DataSource dataSource) {
		super();
		this.dataSource=dataSource;
		// TODO Auto-generated constructor s3253tub
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
	public Collection <Parametre> getAll() {
		// TODO Auto-generated method stub
		List<Parametre> ParametreList = new ArrayList<>();
		
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM parametre");
			//Code à ajouter
			while (resultSet.next()) {
				System.out.println("Alimentation objet jeux avec ligne : "+resultSet.getRow()+":");
				Parametre currentParametre = new Parametre(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3));
				ParametreList.add(currentParametre);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ParametreList;
	}
	
    @Override
    public Parametre getOne(int id_Parametre) {
        String selectQuery = "SELECT * FROM parametre WHERE id_Parametre = ?";
        try {
            this.connection = getConnection(this.dataSource);
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id_Parametre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Parametre(resultSet.getInt("id_Parametre"), resultSet.getInt("son"), resultSet.getString("accessibilite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
	@Override
	public boolean update(Parametre parametre) {
	    String updateQuery = "UPDATE parametre SET son = ?, accessibilite = ? WHERE id_Parametre = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setInt(1, parametre.getSon());
	        preparedStatement.setString(2, parametre.getAccessibilite());
	        preparedStatement.setInt(3, parametre.getId_Parametre());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean create(Parametre Parametre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Parametre Parametre) {
		// TODO Auto-generated method stub
		return false;
	}

}
