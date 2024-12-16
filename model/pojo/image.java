package MTGames.model.pojo;

//import java.sql.Date;

/**
 * 
 * @author SVO
 * Here's a POJO!
 *
 */
public class image {
	private int id_image;
	private String nom;
	private String taille;
	private String type;
	private String img_blob;



	public image() {
		super();
	}
	public image(int id_image, String nom,String taille,String type,String img_blob) {
		super();
		this.id_image = id_image;
		this.nom = nom;
		this.taille = taille;
		this.type = type;
		this.img_blob = img_blob;
	}

	public int getId_image() {
		return id_image;
	}
	public void setId_image(int id_image) {
		this.id_image = id_image;
	}
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public String gettaille() {
		return taille;
	}
	public void settaille(String taille) {
		this.taille = taille;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
	public String getblob() {
		return img_blob;
	}
	public void setblob(String img_blob) {
		this.img_blob = img_blob;
	}
	


}
