package MTGames.model.pojo;

//import java.sql.Date;

/**
 * 
 * @author SVO
 * Here's a POJO!
 *
 */
public class Score {
	private int id_Score;
	private int id_Partie;


	public Score() {
		super();
	}
	public Score(int id_Score, int id_Partie) {
		super();
		this.id_Score = id_Score;
		this.id_Partie = id_Partie;
	}

	public int getId_Score() {
		return id_Score;
	}
	public void setId_Score(int id_Score) {
		this.id_Score = id_Score;
	}
	
	public int getId_Partie() {
		return id_Partie;
	}
	public void setId_Partie(int id_Partie) {
		this.id_Partie = id_Partie;
	}

}
