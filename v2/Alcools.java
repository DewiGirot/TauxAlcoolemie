package v2;

public class Alcools {
	
	public enum NOMALCOOL{VIN, BIERE, SPIRITUEUX, PASTIS, CHAMPAGNE};
	
	private NOMALCOOL nomAlcool;
	
	public Alcools (NOMALCOOL nomAlcool) {
		this.nomAlcool = nomAlcool;
	}
	
	public NOMALCOOL getNomAlcool() {
		return this.nomAlcool;
	}
	
	public double getQuantite() {
		switch(this.nomAlcool) {
		case VIN:
			return 100;
		case BIERE:
			return 250;
		case SPIRITUEUX:
			return 30;
		case PASTIS:
			return 20;
		case CHAMPAGNE:
			return 125;
		default:
			return 0;
		}
	}
	
	public double getDegres() {
		switch(this.nomAlcool) {
		case VIN:
			return 0.12;
		case BIERE:
			return 0.05;
		case SPIRITUEUX:
			return 0.40;
		case PASTIS:
			return 0.45;
		case CHAMPAGNE:
			return 0.11;
		default:
			return 0;
		}
	}

}
