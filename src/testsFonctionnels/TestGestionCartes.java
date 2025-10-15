package testsFonctionnels;

import cartes.*;
import utils.GestionCartes;

import java.util.*;

public class TestGestionCartes {

    public static <T> boolean memeFrequences(List<T> a, List<T> b) {
        if (a.size() != b.size()) return false;
        Set<T> universe = new HashSet<>(a);
        universe.addAll(b);
        for (T x : universe) {
            if (Collections.frequency(a, x) != Collections.frequency(b, x)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();

        List<Carte> listeCarteNonMelangee = new LinkedList<>();
        for (Carte c : jeu.donnerCartes()) {
            listeCarteNonMelangee.add(c);     
        }

        List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
        System.out.println("Avant mélange (taille=" + listeCartes.size() + "): " + listeCartes);

        // --- b) 
        List<Carte> melangee = GestionCartes.melanger(listeCartes);
        System.out.println("Après mélange (taille=" + melangee.size() + "): " + melangee);
        System.out.println("Source vidée ? " + listeCartes.isEmpty());

        // --- c) 
        boolean ok1 = GestionCartes.verifierMelange(listeCarteNonMelangee, melangee);
        boolean ok1b = memeFrequences(listeCarteNonMelangee, melangee);
        System.out.println("liste mélangée sans erreur ? " + (ok1 && ok1b));

        // --- d) 
        List<Carte> rassemblee = GestionCartes.rassembler(melangee);
        System.out.println("Après rassemblement: " + rassemblee);

        // --- e) 
        boolean ok2 = GestionCartes.verifierRassemblement(rassemblee);
        System.out.println("liste rassemblée sans erreur ? " + ok2);

        testerRassemblementEntiers(List.of());                         // []
        testerRassemblementEntiers(Arrays.asList(1,1,2,1,3));          // [1;1;2;1;3]
        testerRassemblementEntiers(Arrays.asList(1,4,3,2));            // [1;4;3;2]
        testerRassemblementEntiers(Arrays.asList(1,1,2,3,1));          // [1;1;2;3;1]

        int freqAvant = Collections.frequency(listeCarteNonMelangee, new Borne(25));
        int freqApres = Collections.frequency(melangee, new Borne(25));
        System.out.println("Fréquence 25KM avant/après = " + freqAvant + " / " + freqApres);
    }

    private static void testerRassemblementEntiers(List<Integer> input) {
        List<Integer> src = new ArrayList<>(input);
        List<Integer> r = GestionCartes.rassembler(src);
        boolean ok = GestionCartes.verifierRassemblement(r);
        System.out.println("Input=" + input + "  Rassemblée=" + r + "  OK? " + ok);
        System.out.println("Fréquences inchangées ? " + memeFrequences(input, r));
    }
}
