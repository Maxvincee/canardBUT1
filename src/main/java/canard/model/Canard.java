package canard.model;

public class Canard {
	private final String nom;
	
	public Canard (String nom) {
		this.nom = nom;
	}
	
	public String nager() {
		return "Tous les canards flottent , même les leurres !";
	}
	
	public String afficher() {
		return this.nom + " : Je suis un vrai canard";
	}

	public String getNom() {
		return this.nom;
	}
	
	
}
