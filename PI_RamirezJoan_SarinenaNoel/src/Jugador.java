import java.util.ArrayList;
import java.util.Iterator;

public class Jugador<E extends ItipoPieza> {

    //ATRIBUTOS
    private ArrayList<E> piezasVivas;

    //CONSTRUCTOR
    public Jugador(ArrayList<E> piezasVivas) {
        this.piezasVivas = piezasVivas;
    }

    //GETTER
    public ArrayList<E> getPiezasVivas() {
        return this.piezasVivas;
    }

    //METODOS
    public void moverPieza(int columnaAnterior, int filaAnterior, int nuevaColumna, int nuevaFila) {
        E piezaMover = buscarEnPosicion(filaAnterior,columnaAnterior);
        // Excepciones
        if (piezaMover == null){
            throw new RuntimeException("No hay ninguna pieza en la localización (" + filaAnterior + "," + columnaAnterior + ") para mover.");
        }
        if (buscarEnPosicion(nuevaFila,nuevaColumna) != null) {
            throw new RuntimeException("Hay una pieza en la localización (" + nuevaFila + "," + nuevaColumna + ").");
        }
        //Encontrar la pieza y cambiar posicion(atributos)
        for(E pieza: this.piezasVivas){
            if (pieza.equals(piezaMover)){
                pieza.setPosicion(nuevaFila,nuevaColumna);
            }
        }
    }

    private E buscarEnPosicion(int nuevaFila, int nuevaColumna) {
        for (E pieza: this.piezasVivas){
            if(pieza.getColumna()==nuevaColumna && pieza.getFila() == nuevaFila){
             return pieza;
            }
        }
        return null;
    }

    public boolean eliminarPiezaEnPosicion(int fila, int columna) {
        E pieza = buscarEnPosicion(fila,columna);
        if( pieza == null){
            return false;
        }
        Iterator<E> it = piezasVivas.iterator();
        while(it.hasNext()) {
            E i = it.next();
            if(pieza.equals(i)) {
                it.remove();
                if(i.fiJoc()) throw new FiJocException("Fi de Joc.");
                return true;
            }
        }
        return false;
    }

}
