package canard.application;

import canard.model.*;
import canard.model.vol.*;
public class Client {

	public static void main(String[] args) {
		Canard colvert2 = new Colvert("Jean");
		Canard prototype = new PrototypeCanard("Canatron");
		
		System.out.println(colvert2.afficher());
		System.out.println(colvert2.nager());
		System.out.println(colvert2.effectuerCancan());
		System.out.println(colvert2.effectuerVol());
		System.out.println(prototype.afficher());
		System.out.println(prototype.effectuerVol());
		
		prototype.changerComportementVol(new PropulsionAReaction());
		
		System.out.println(prototype.effectuerVol());
	}

}
