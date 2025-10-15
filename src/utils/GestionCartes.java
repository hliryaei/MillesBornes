package utils;

import java.util.*;

/** Outils génériques pour manipuler des listes. */
public final class GestionCartes {
    private static final Random RNG = new Random();
    private GestionCartes() {}

    // a.1
    public static <T> T extraire(List<T> listeNonVide) {
        if (listeNonVide == null || listeNonVide.isEmpty())
            throw new IllegalArgumentException("liste vide");
        int i = RNG.nextInt(listeNonVide.size());
        return listeNonVide.remove(i);
    }

    // a.2
    public static <T> T extraireIter(List<T> listeNonVide) {
        if (listeNonVide == null || listeNonVide.isEmpty())
            throw new IllegalArgumentException("liste vide");
        int i = RNG.nextInt(listeNonVide.size());
        ListIterator<T> it = listeNonVide.listIterator();
        for (int k = 0; k < i; k++) it.next();
        T val = it.next();
        it.remove();
        return val;
    }

    // b) mélanger: vide la liste src et renvoie une nouvelle liste mélangée
    public static <T> List<T> melanger(List<T> src) {
        if (src == null) throw new IllegalArgumentException("liste nulle");
        List<T> out = new ArrayList<>(src.size());
        while (!src.isEmpty()) {
            out.add(extraire(src));          
        }
        return out;
    }

    // c) vérifier que les deux listes ont les mêmes fréquences pour chaque élément
    public static <T> boolean verifierMelange(List<T> a, List<T> b) {
        if (a == null || b == null) return false;
        if (a.size() != b.size()) return false;

        Set<T> universe = new HashSet<>(a);
        universe.addAll(b);

        for (T x : universe) {
            if (Collections.frequency(a, x) != Collections.frequency(b, x))
                return false;
        }
        return true;
    }

    // d) rassembler: regroupe les occurrences identiques en blocs consécutifs
    public static <T> List<T> rassembler(List<T> src) {
        if (src == null) throw new IllegalArgumentException("liste nulle");
        LinkedHashMap<T, Integer> counts = new LinkedHashMap<>();
        for (T x : src) counts.merge(x, 1, Integer::sum);

        List<T> out = new ArrayList<>(src.size());
        for (Map.Entry<T,Integer> e : counts.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) out.add(e.getKey());
        }
        return out;
    }

    // e) vérifier que chaque valeur forme un bloc contigu
    public static <T> boolean verifierRassemblement(List<T> liste) {
        if (liste == null) return false;
        if (liste.isEmpty()) return true;

        ListIterator<T> it1 = liste.listIterator();
        T courant = it1.next();

        while (it1.hasNext()) {
            T suivant = it1.next();
            if (!Objects.equals(suivant, courant)) {
                ListIterator<T> it2 = liste.listIterator(it1.previousIndex() + 1);
                while (it2.hasNext()) {
                    if (Objects.equals(it2.next(), courant)) return false;
                }
                courant = suivant;
            }
        }
        return true;
    }
}
