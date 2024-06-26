package canard.model;

import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;

public abstract class Canard {
	private final String nom;
	protected ComportementVol comportementVol;
	protected ComportementCancan comportementCancan;
	
	protected Canard (String nom, ComportementVol comportementVol, ComportementCancan comportementCancan) {
		this.nom = nom;
		this.comportementVol = comportementVol;
		this.comportementCancan = comportementCancan;
	}
	
	public String nager() {
		return "Tous les canards flottent, même les leurres !";
	}
	
	public abstract String afficher();

	public String getNom() {
		return this.nom;
	}
	
	public String effectuerVol() {
		return this.comportementVol.voler();
	}
	
	public String effectuerCancan() {
		return this.comportementCancan.cancanner();
	}
	
	public void changerComportementVol(ComportementVol comportementVol) {
		this.comportementVol = comportementVol;
	}
	
	public void changerComportementCancan(ComportementCancan comportementCancan) {
		this.comportementCancan = comportementCancan;
	}
}
