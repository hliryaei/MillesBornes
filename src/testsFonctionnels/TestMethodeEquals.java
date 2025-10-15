package testsFonctionnels;

import cartes.*;  

public class TestMethodeEquals {

    public static void main(String[] args) {

        Carte borne1 = new Borne(25);
        Carte borne2 = new Borne(25);
        System.out.println("Deux cartes 25KM sont identiques ? " + borne1.equals(borne2));

        Carte feuRouge1 = new Attaque(Type.FEU);
        Carte feuRouge2 = new Attaque(Type.FEU);
        System.out.println("Deux cartes Feu Rouge sont identiques ? " + feuRouge1.equals(feuRouge2));

        Carte feuRouge = new Attaque(Type.FEU);
        Carte feuVert = new Parade(Type.FEU);
        System.out.println("Feu Rouge et Feu Vert sont identiques ? " + feuRouge.equals(feuVert));
    }
}
