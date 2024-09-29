import java.util.ArrayList;

public class Torns <E> {
    // ATRIBUTS
    private ArrayList<E> llistatTorns;

    // CONSTRUCTORS

    // Constructor per defecte que inicialitza el llistat de torns
    public Torns() {
        llistatTorns = new ArrayList<E>();
    }
    // Invoca el mètode privat llençarà una excepció si no s’ha pogut llegir o si la llista és buida
    public Torns(String nomFitxer) {
        llistatTorns = new ArrayList<E>();
    }

    // MÈTODES

    // Afegeix un torn a l’última posició del llistat.
    public void afegirTorn(E torn) {
        llistatTorns.add(torn);
    }

    // Elimina i retorna el primer element del llistat (que serà el torn a realitzar),
        // si no hi ha més retornarà una excepció del tipus NoSuchElementException.
    public E agafarPrimerTorn() {
        return llistatTorns.get(0);
    }

    // Guarda tots els torns de la partida en un fitxer del tipus txt, podria retornar una excepció del tipus IOException.
    public void guardarAFitxer (String nomFitxer) {
        //TODO

    }

    // Mètode privat que llegeix un fitxer txt i inicialitzar el llistat de torns a partir del fitxer.
    public void carregarDesdeFitxer (String nomFitxer) {


    }

}
