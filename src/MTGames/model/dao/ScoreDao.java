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

import MTGames.model.daointerface.ScoreDaoInterface;
import MTGames.model.pojo.Score;

/**
 * @author MAC
 *
 */
public class ScoreDao implements ScoreDaoInterface {
	private DataSource dataSource;
	private Connection connection;
	
	public ScoreDao(DataSource dataSource) {
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
	public Collection <Score> getAll() {
		// TODO Auto-generated method stub
		List<Score> scoreList = new ArrayList<>();
		
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * FROM partie");

			while (resultSet.next()) {
				Score currentScore = new Score(resultSet.getInt(1), resultSet.getInt(2));
				scoreList.add(currentScore);
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return scoreList;
	}

	@Override
	public boolean create(Score score) {
		
	    if (getOne(score.getId_Score()) != null) {
	        System.out.println("You lose ! La partie numéro " + score.getId_Score() + " existe déjà !");
	        return false;
	    }
		
		String insertQuery = null;
		insertQuery = "INSERT INTO partie "
				//+ "(id_partie, id_utilisateur, id_jeux) "
				+ "VALUES ("+score.getId_Score()+",'"+score.getId_Partie()+"')";
		System.out.println(insertQuery);
		try {
			this.connection = getConnection(this.dataSource);
			Statement statement = connection.createStatement();
			statement.execute(insertQuery);
			System.out.println("Score créé / Id : "+score.getId_Score());
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	    
	    return true;
	}
	
    @Override
    public Score getOne(int id_Score) {
        String selectQuery = "SELECT * FROM score WHERE id_Score = ?";
        try {
            this.connection = getConnection(this.dataSource);
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id_Score);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Score(resultSet.getInt("id_Score"), resultSet.getInt("id_Partie"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return null;
    }
    
	@Override
	public boolean update(Score score) {
	    String updateQuery = "UPDATE score SET id_Partie = ? WHERE id_Score = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setInt(1, score.getId_Partie());
	        preparedStatement.setInt(2, score.getId_Score());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	@Override
	public boolean delete(Score score) {
	    String deleteQuery = "DELETE FROM score WHERE id_Score = ?";
	    try {
	        this.connection = getConnection(this.dataSource);
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, score.getId_Score());
	        int rowsAffected = preparedStatement.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
