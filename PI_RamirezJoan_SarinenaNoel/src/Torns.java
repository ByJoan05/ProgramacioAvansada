import java.util.ArrayList;

public class Torns <E> {
    // ATRIBUTS
    private ArrayList<E> llistatTorns;

    // CONSTRUCTORS
    public Torns() {
        llistatTorns = new ArrayList<E>();
    }
    public Torns(String nomFitxer) {
        llistatTorns = new ArrayList<E>();
    }

    // MÈTODES
    public void afegirTorn(E torn) {
        llistatTorns.add(torn);
    }

    public E agafarTorn() {
        return llistatTorns.get(0);
    }

    public void guardarAFitxer (String nomFitxer) {
        //TODO

    }

}
