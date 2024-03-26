package canard.model;

public class Mandarin extends Canard {
	
	public Mandarin(String nom) {
		super(nom);
	}

	@Override
	public String afficher() {
		return "Je suis un vrai mandarin";
	}
}
