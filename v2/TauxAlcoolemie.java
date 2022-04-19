package v2;

public class TauxAlcoolemie {
	
	public enum SEXE {HOMME, FEMME};
	
	private int masse;
	private SEXE genre;
	
	//CE = Conducteur Expérimenté, JC = Jeune Conducteur
	private double tauxLegalCE = 0.5;
	private double tauxLegalJC = 0.2;
	
	//temps moyen d'élimination de l'alcool par heure
	private double dilution = 0.15;
	
	
	//Masse en KG
	public TauxAlcoolemie(int masse, SEXE genre) {
		this.masse = masse;
		this.genre = genre;
	}
	
	public int getMasse() {
		return this.masse;
	}
	
	public SEXE getGenre() {
		return this.genre;
	}
	
	/*
	 * @param : getQuantite pour le Volume en millilitre, getDegres pour le taux d'alcoolémie en pourcentage (ex : 0.12 pour 12°) et la masse (en Kg)
	 * @return : retourne la formule pour un homme
	 * */
	public double tauxAlcoolemie(Alcools alcool, int quantite) {
		if(getGenre() == SEXE.HOMME) {
			double formule = ((alcool.getQuantite()*quantite) * alcool.getDegres() * 0.8) / (0.7 * this.masse);
			return formule;
		}else {
			double formule = (alcool.getQuantite() * alcool.getDegres() * 0.8) / (0.6 * this.masse);
			return formule;
		}
	}
	
	public String tempsRedescente(double tauxAlcoolemie, boolean ventreVide) {
		
		int heure = 0;
		int minute = 0;
		int heureTauxLegalCE = 0;
		int minuteTauxLegalCE = 0;
		int heureTauxLegalJC = 0;
		int minuteTauxLegalJC = 0;
		
		double tauxAlcoolemieCE = tauxAlcoolemie;
		double tauxAlcoolemieJC = tauxAlcoolemie;
		
		double dilutionParMinute = this.dilution/60;
		
		//Temps pour arriver à 0.0 g/ml
		while(tauxAlcoolemie >= this.dilution) {
			tauxAlcoolemie -= this.dilution;
			heure += 1;
		}
		while(tauxAlcoolemie >= dilutionParMinute) {
			tauxAlcoolemie -= dilutionParMinute;
			minute += 1;
		}
		
		//Temps pour arriver à 0.5 g/ml
		while(tauxAlcoolemieCE >= dilutionParMinute && tauxAlcoolemieCE > tauxLegalCE) {
			tauxAlcoolemieCE -= dilutionParMinute;
			minuteTauxLegalCE += 1;
		}
		
		//Temps pour arriver à 0.2 g/ml
		while(tauxAlcoolemieJC >= dilutionParMinute && tauxAlcoolemieJC > tauxLegalJC) {
			tauxAlcoolemieJC -= dilutionParMinute;
			minuteTauxLegalJC += 1;
		}
		
		
		
		/* Pour éviter de compter les secondes et être sûr d'être sobre à l'instant T on ajoute 1 minute
		 * seulement et seulement si il reste des valeurs dans "tauxAlcoolemie"
		 */
		if(minute !=0 && tauxAlcoolemie>0) {
			minute += 1;
		}
		
		
		/* D'après : https://www.bfmtv.com/static/nxt-bfmtv/evenement/auto/taux-alcool%C3%A9mie/index.html
		 * il faut ajouter 30 min si à jeun sinon 1h de plus
		 */
		if(ventreVide) {
			minute += 30;
			minuteTauxLegalCE += 30;
			minuteTauxLegalJC += 30;
		}else {
			heure+=1;
			heureTauxLegalCE+=1;
			heureTauxLegalJC+=1;
		}
		
		//On converti les minutes afin que les minutes ne dépassent pas 60
		while(minute >= 60) {
			heure +=1;
			minute = minute - 60;
		}
		while(minuteTauxLegalCE >= 60) {
			minuteTauxLegalCE -= 60;
			heureTauxLegalCE +=1;
		}
		while(minuteTauxLegalJC >= 60) {
			minuteTauxLegalJC -= 60;
			heureTauxLegalJC +=1;
		}
						
		return "Temps avant d'arriver à 0.0g/ml : " + heure + "h" + minute + "min" + "\n" 
				+ "Temps avant d'arriver à 0.5g/ml (Conducteur expérimenté) : " + heureTauxLegalCE + "h" + minuteTauxLegalCE + "min" + "\n" 
				+ "Temps avant d'arriver à 0.2g/ml (Jeune conducteur) : " + heureTauxLegalJC + "h" + minuteTauxLegalJC + "min";
	}
	
}
