package cartes;

public class Botte extends Probleme {
	
	public Botte(Type type) {
		super(type);
	}
	
	@Override 
	public String toString() {
		return type.getBotte();
	}
	
	@Override
	public Type getType() {
		return this.type;
	}
	
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof Botte carte) {
			return this.type == carte.getType();
		}
		return false; 
	}
}