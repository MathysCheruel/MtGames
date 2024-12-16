package MTGames.model.pojo;

//import java.sql.Date;

/**
 * 
 * @author SVO
 * Here's a POJO!
 *
 */
public class jeux {
	private int id_jeux;
	private String nom;
	private int id_image;


	public jeux() {
		super();
	}
	public jeux(int id_jeux, String nom, int id_image) {
		super();
		this.id_jeux = id_jeux;
		this.nom = nom;
		this.id_image = id_image;
	}

	public int getid_jeux() {
		return id_jeux;
	}
	public void setid_jeux(int id_jeux) {
		this.id_jeux = id_jeux;
	}
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public int getid_image() {
		return id_image;
	}
	public void setid_image(int id_image) {
		this.id_image = id_image;
	}


}
