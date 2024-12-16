package MTGames.model.pojo;

/**
 * 
 * @authors MAC - SVO - YSA
 * Here's a POJO!
 *
 */

public class Partie {
	private int id_Partie;
	private int id_Utilisateur;
	private int id_Jeux;
	
	public Partie() {
		super();
	}
	public Partie(int id_Partie, int id_Utilisateur, int id_Jeux) {
		super();
		this.id_Partie = id_Partie;
		this.id_Utilisateur = id_Utilisateur;
		this.id_Jeux = id_Jeux;
	}
		
	public int getId_Partie() {
		return id_Partie;
	}
	public void setId_Partie(int id_Partie) {
		this.id_Partie = id_Partie;
	}
	
	public int getId_Utilisateur() {
		return id_Utilisateur;
	}
	public void setId_Utilisateur(int id_Utilisateur) {
		this.id_Utilisateur = id_Utilisateur;
	}
	
	public int getId_Jeux() {
		return id_Jeux;
	}
	public void setId_Jeux(int id_Jeux) {
		this.id_Jeux = id_Jeux;
	}
	
}
