package canard;

import static org.junit.jupiter.api.Assertions.*;

import javax.net.ssl.SSLPeerUnverifiedException;

import org.junit.jupiter.api.Test;

import canard.model.*;
import canard.model.cancan.*;
import canard.model.vol.*;

import org.junit.jupiter.api.BeforeEach;

class CanardTest {
	private static final String NAGER = "Tous les canards flottent, même les leurres !";

	private static final String VOLER = "Je vole !";
	private static final String NE_PAS_VOLER = "Je ne sais pas voler";

	private static final String CANCAN = "Can-can";
	private static final String COINCOIN = "Coin-coin";
	private static final String SILENCE = "...Silence...";

	Canard colvert;
	Canard leurre;
	Canard mandarin;
	Canard canardPlastique;
	

	@BeforeEach
	private void extracted() {
		colvert = new Colvert("Piero");
		leurre = new Leurre("Danny");
		mandarin = new Mandarin("Oshidori");
		canardPlastique = new CanardEnPlastique("Rubber");
	}

	@Test
	public void test_effectuerVol() {
		String texteVolColvert = colvert.effectuerVol();
		assertEquals(VOLER, texteVolColvert);

		assertEquals(VOLER, mandarin.effectuerVol());

		assertEquals(NE_PAS_VOLER, leurre.effectuerVol());
		assertEquals(NE_PAS_VOLER, canardPlastique.effectuerVol());
		
		mandarin.changerComportementVol(new NePasVoler());
	}

	@Test
	public void test_effectuerCancan() {

		assertEquals(CANCAN, colvert.effectuerCancan());
		assertEquals(CANCAN, mandarin.effectuerCancan());

		assertEquals(SILENCE, leurre.effectuerCancan());
		assertEquals(COINCOIN, canardPlastique.effectuerCancan());
		
		canardPlastique.changerComportementCancan(new Cancan());
	}

	@Test
	public void test_nager() {

		assertEquals(NAGER, colvert.nager());
		assertEquals(NAGER, mandarin.nager());

		assertEquals(NAGER, leurre.nager());
		assertEquals(NAGER, canardPlastique.nager());
	}

	@Test
	public void test_presentation_nom_et_afficher() {
		assertEquals("Piero", colvert.getNom());
		assertEquals("Je suis un vrai colvert", colvert.afficher());

		assertEquals("Oshidori", mandarin.getNom());
		assertEquals("Je suis un vrai mandarin", mandarin.afficher());

		assertEquals("Danny", leurre.getNom());
		assertEquals("Je suis un leurre", leurre.afficher());

		assertEquals("Rubber", canardPlastique.getNom());
		assertEquals("Je suis un canard en plastique", canardPlastique.afficher());
	}
	
	@Test
	public void scénario_test() {
		Canard colvert2 = new Colvert("Jean");
		
		assertEquals("Jean", colvert2.getNom());
		assertEquals("Je suis un vrai colvert", colvert2.afficher());
		assertEquals(NAGER, colvert2.nager());
		assertEquals(CANCAN, colvert2.effectuerCancan());
		assertEquals(VOLER, colvert2.effectuerVol());
		
		Canard prototype = new PrototypeCanard("Canatron");
		
		assertEquals("Canatron", prototype.getNom());
		assertEquals("Je suis un prototype de canard", prototype.afficher());
		assertEquals(NE_PAS_VOLER, prototype.effectuerVol());
		
		prototype.changerComportementVol(new PropulsionAReaction());
		
		assertEquals("Je vole avec un réacteur", prototype.effectuerVol());
	}
}
