package cartes;

public class Attaque extends Bataille{
	public Attaque(Type type) {
		super(type);
	}
	
	@Override 
	public String toString() {
		return type.getAttaque();
	}
	public Type getType() {
		return this.type;
	}
	
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof Attaque carte) {
			return this.type == carte.getType();
		}
		return false; 
	}
	
}