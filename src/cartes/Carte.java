package cartes;

public abstract class Carte {
	
	@Override
    public abstract String toString();
	
	@Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
	
}



/*@Override
public boolean equals(Object obj) {
    return obj != null && obj.getClass() == this.getClass();
}*/