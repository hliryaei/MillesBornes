package cartes;

public class Parade extends Bataille{
	public Parade(Type type) {
		super(type);
	}
	
	@Override 
	public String toString() {
		return type.getParade();
	}
	
	public Type getType() {
		return this.type;
	}
	
	@Override
	public boolean equals(Object obj) { 
		if(obj instanceof Parade carte) {
			return this.type == carte.getType();
		}
		return false; 
	}
	
}