package MTGames.model.pojo;

//import java.sql.Date;

/**
 * 
 * @author SVO
 * Here's a POJO!
 *
 */
public class utilisateur {
	private int id_utilisateur;
	private String pseudo;
	private String mail;
	private String mdp;
	private int id_image;
	private int id_parametre;
	private int id_profil_utilisateur;
	

	public utilisateur() {
		super();
	}
	public utilisateur(int id_utilisateur, String pseudo,String mail,String mdp,int id_image,int id_parametre ,int id_profil_utilisateur) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.pseudo = pseudo;
		this.mail = mail;
		this.mdp = mdp;
		this.id_image = id_image;
		this.id_parametre = id_parametre;
		this.id_profil_utilisateur = id_profil_utilisateur;
	}

	public int getid_utilisateur() {
		return id_utilisateur;
	}
	public void setid_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public String getpseudo() {
		return pseudo;
	}
	public void setpseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getmail() {
		return mail;
	}
	public void setmail(String mail) {
		this.mail = mail;
	}
	public String getmdp() {
		return mdp;
	}
	public void setmdp(String mdp) {
		this.mdp = mdp;
	}
	public int getId_image() {
		return id_image;
	}
	public void setId_image(int id_image) {
		this.id_image = id_image;
	}
	public int getid_parametre() {
		return id_parametre;
	}
	public void setid_parametre(int id_parametre) {
		this.id_parametre = id_parametre;
	}
	public void setid_profil_utilisateur(int id_profil_utilisateur) {
		this.id_profil_utilisateur = id_profil_utilisateur;
	}
	public Object getid_profil_utilisateur() {
		return id_profil_utilisateur;
	}
	
	


}
