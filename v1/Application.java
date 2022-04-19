package v1;

import v1.TauxAlcoolemie.SEXE;

public class Application {

	public static void main(String[] args) {
		TauxAlcoolemie homme1 = new TauxAlcoolemie(75, SEXE.HOMME);
		System.out.println("Pour un homme de 75 kg ayant bu 12 CL à 12° d'alcool : " + homme1.tauxAlcoolemie(120, 0.12));
		
		System.out.println(' ');
		
		TauxAlcoolemie femme1 = new TauxAlcoolemie(70, SEXE.FEMME);
		System.out.println("Pour une femme de 70 kg ayant bu 140 CL à 14° d'alcool : " + femme1.tauxAlcoolemie(140, 0.14));
		
		System.out.println(' ');
		
		System.out.println(homme1.tempsRedescente(homme1.tauxAlcoolemie(120, 0.12), false));
	}

}
