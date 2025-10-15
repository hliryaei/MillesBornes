package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;


public class Jeu {

    private Sabot sabot;

    public Jeu() {
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        Carte[] toutesLesCartes = jeuDeCartes.donnerCartes();

        List<Carte> listeCartes = new ArrayList<>();
        Collections.addAll(listeCartes, toutesLesCartes);

        listeCartes = GestionCartes.melanger(listeCartes);

        Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);

        sabot = new Sabot(cartesMelangees);
    }

    public Sabot getSabot() {
        return sabot;
    }

    @Override
    public String toString() {
        return "Jeu avec " + sabot.getNbCartes() + " cartes dans le sabot.";
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        System.out.println(jeu);
        System.out.println("Pioche de quelques cartes :");
        for (int i = 0; i < 5; i++) {
            System.out.println("→ " + jeu.getSabot().piocher());
        }
        System.out.println("Cartes restantes : " + jeu.getSabot().getNbCartes());
    }
}
