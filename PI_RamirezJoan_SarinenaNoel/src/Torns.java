import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Torns <E> {
    // ATRIBUTS
    private ArrayList<E> llistatTorns;

    // CONSTRUCTORS

    // Constructor per defecte que inicialitza el llistat de torns
    public Torns() {
        llistatTorns = new ArrayList<E>();
    }
    // Invoca el mètode privat llençarà una excepció si no s’ha pogut llegir o si la llista és buida
    public Torns(String nomFitxer) throws Exception {
        File fitxerACargar = new File(nomFitxer);
        llistatTorns = new ArrayList<E>();
        if (!fitxerACargar.canRead()) throw new IllegalAccessException("No existeix o no es pot llegir el fitxer a carregar.");
        if (fitxerACargar.length()==0) throw new IllegalAccessException("El fitxer a càrregar està buit.");
        carregarDesdeFitxer(nomFitxer);
        if (llistatTorns.isEmpty()) throw new Exception("La llista es buida.");
    }

    // MÈTODES

    // Afegeix un torn a l’última posició del llistat.
    public void afegirTorn(E torn) {
        llistatTorns.add(torn);
    }

    // Elimina i retorna el primer element del llistat (que serà el torn a realitzar),
        // si no hi ha més retornarà una excepció del tipus NoSuchElementException.
    public E agafarPrimerTorn() {
        if (llistatTorns.isEmpty()) throw new NoSuchElementException();
        return llistatTorns.remove(0);
    }

    // Guarda tots els torns de la partida en un fitxer del tipus txt, podria retornar una excepció del tipus IOException.
    public void guardarAFitxer (String nomFitxer) throws IOException {
    //TODO: Hacer todo XD, me he quedado en el punto en el que no se como acceder a los datos de <E> porq no es un objeto instanciado
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(nomFitxer)));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (Object o : llistatTorns) {
            bw.write(o.toString());
            bw.newLine();
        }
    }

    // Mètode privat que llegeix un fitxer txt i inicialitzar el llistat de torns a partir del fitxer.
    private void carregarDesdeFitxer (String nomFitxer) throws Exception {
        File fitxerACargar = new File(nomFitxer);
        //Obro l'arxiu
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fitxerACargar));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        //Afegeix-ho els torns de l'arxiu i el tanco
        String torn;
        while ((torn = br.readLine()) != null) {
            this.afegirTorn((E) torn);
        }
        br.close();
    }
}
