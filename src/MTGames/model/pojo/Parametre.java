package MTGames.model.pojo;

/**
 * 
 * @authors MAC - SVO - YSA
 * Here's a POJO!
 *
 */

public class Parametre {
	private int id_Parametre;
	private int son;
	private String accessibilite;
	
	public Parametre() {
		super();
	}
	public Parametre(int id_Parametre, int son, String accessibilite) {
		super();
		this.id_Parametre = id_Parametre;
		this.son = son;
		this.accessibilite = accessibilite;
	}
		
	public int getId_Parametre() {
		return id_Parametre;
	}
	public void setId_Parametre(int id_Parametre) {
		this.id_Parametre = id_Parametre;
	}
	
	public int getSon() {
		return son;
	}
	public void setSon(int son) {
		this.son = son;
	}
	
	public String getAccessibilite() {
		return accessibilite;
	}
	public void setAccessibilite(String accessibilite) {
		this.accessibilite = accessibilite;
	}
	
}
