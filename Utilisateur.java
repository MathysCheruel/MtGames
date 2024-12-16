package MTGames;

public class Utilisateur {
	String PseudoUtilisateur = "";

	public void Utilisateurs(String leNom) {
		PseudoUtilisateur = leNom;
	}

	public void affecteNomUtilisateur(String leNom) {
		PseudoUtilisateur = leNom;
	}

	public boolean compareNomUtilisateur(String leNom) {
		boolean resultatComparaison = false;
		if (leNom.compareTo(PseudoUtilisateur) == 0) {
			resultatComparaison = true;
		} else {
			resultatComparaison  = false;
		}
		return resultatComparaison;
	}

}