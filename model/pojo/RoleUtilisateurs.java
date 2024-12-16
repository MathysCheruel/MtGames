package MTGames.model.pojo;

//import java.sql.Date;

/**
 * 
 * @author MAC
 * Here's a POJO!
 *
 */
public class RoleUtilisateurs {
	private int id_ProfilUtilisateurs;
	private String nom;


	public RoleUtilisateurs() {
		super();
	}
	public RoleUtilisateurs(int id_ProfilUtilisateurs, String nom) {
		super();
		this.id_ProfilUtilisateurs = id_ProfilUtilisateurs;
		this.nom = nom;
	}

	public int getId_ProfilUtilisateurs() {
		return id_ProfilUtilisateurs;
	}
	public void setId_ProfilUtilisateurs(int id_ProfilUtilisateurs) {
		this.id_ProfilUtilisateurs = id_ProfilUtilisateurs;
	}
	
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
}
