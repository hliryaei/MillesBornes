package cartes;

public class Borne extends Carte {
	private int km;
	public Borne(int km) {
		this.km = km;
	}
	
	@Override
	public String toString() {
		return String.valueOf(km) + "KM";
	}
	
	public int getKm() {
		return this.km;
	}
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof Borne borne) {
			return this.km == borne.getKm();
		}
		return false; 
	}
}