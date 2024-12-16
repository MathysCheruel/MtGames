package MTGames.model.pojo;

/**
 * 
 * @authors MAC - SVO - YSA
 * Here's a POJO!
 *
 */

public class Participe {
	private int id_Utilisateur;
	private int id_Partie;
	
	public Participe() {
		super();
	}
	public Participe(int id_Utilisateur, int id_Partie) {
		super();
		this.id_Utilisateur = id_Utilisateur;
		this.id_Partie = id_Partie;
	}
		
	public int getId_Utilisateur() {
		return id_Utilisateur;
	}
	public void setId_Utilisateur(int id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}
	
	public int getId_Partie() {
		return id_Partie;
	}
	public void setId_Partie(int id_Partie) {
		this.id_Partie = id_Partie;
	}
	
}
