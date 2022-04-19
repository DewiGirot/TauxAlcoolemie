package v2;

import v2.Alcools.NOMALCOOL;
import v2.TauxAlcoolemie.SEXE;

public class Application {

	public static void main(String[] args) {
		TauxAlcoolemie homme1 = new TauxAlcoolemie(70, SEXE.HOMME);
		double tauxHomme1 = homme1.tauxAlcoolemie(new Alcools(NOMALCOOL.SPIRITUEUX), 10);
		System.out.println("Pour un homme de 75 kg ayant bu 24 CL à 12° d'alcool : " + tauxHomme1 + " g/L");
		
		System.out.println(' ');
		
		TauxAlcoolemie femme1 = new TauxAlcoolemie(70, SEXE.FEMME);
		double tauxFemme2 = femme1.tauxAlcoolemie(new Alcools(NOMALCOOL.VIN), 1);
		System.out.println("Pour une femme de 70 kg ayant bu 140 CL à 14° d'alcool : " + tauxFemme2 + " g/L");
		
		System.out.println(' ');
		
		System.out.println(homme1.tempsRedescente(tauxHomme1, false));
	}

}
