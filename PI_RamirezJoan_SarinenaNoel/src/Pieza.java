public class Pieza implements ItipoPieza {

    // ATRIBUTOS
    public final char PEON = 'P';
    public final char CABALLO = 'C';
    public final char ALFIL = 'A';
    public final char TORRE = 'T';
    public final char REINA = 'D'; // D = Dama
    public final char REY = 'R';
    private char columna;
    private int fila;
    private char tipo;

    // CONSTRUCTOR
    public Pieza(char columna, int fila, char tipo) {
        this.columna = columna;
        this.fila = fila;
        this.tipo = tipo;
    }

    // GETTERS Y SETTERS
    public int getColumna() {
        return columna;
    }

    @Override
    public char getTipus() {
        return tipo;
    }

    public int getFila() {
        return fila;
    }

    public void setPosicion(int fila, int columna) {
        if (columna < 65 || columna > 72 || fila < 1 || fila > 8) {
            throw new RuntimeException("La posición no es correcta");
        }
        this.columna = (char) columna;
        this.fila = fila;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Pieza{" +
                "columna=" + columna +
                ", fila=" + fila +
                ", tipo=" + tipo +
                '}';
    }

    // MÉTODOS
    public boolean fiJoc () {
        if (this.tipo == REY) return true;
        return false;
        // return this.tipo == REY;
    }

    private void checkTipo (char tipo) {
        if (tipo != PEON && tipo != CABALLO && tipo != ALFIL && tipo != TORRE && tipo != REINA && tipo != REY) {
            throw new IllegalArgumentException("El tipus de peça no és correcte.");
        }
    }

    public boolean toEquals (Pieza pieza) {
        return this.columna == pieza.columna && this.fila == pieza.fila && this.tipo == pieza.tipo;
    }

}
