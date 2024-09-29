public class Pieza {

    // ATRIBUTOS
    private final char PEON = 'P';
    private final char CABALLO = 'C';
    private final char ALFIL = 'A';
    private final char TORRE = 'T';
    private final char REINA = 'Q';
    private final char REY = 'K';
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

    public char getColumna() {
        return columna;
    }

    public int getFila() {
        return fila;
    }

    public char getTipo() {
        return tipo;
    }

    public void setPosicion(int fila, int columna) {
        this.fila = fila;
        // TODO: Transformar columna de char a int
        // --> this.columna = columna;
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
        // TODO: Comprobar si finaliza el juego. Es decir, pos de pieza eliminada = rey
        return false;
    }

    public void checkTipo (char tipo) {
        String tipoCompleto = "";
        switch (tipo) {
            case 'P': tipoCompleto = "Peón";
            case 'C': tipoCompleto = "Caballo";
            case 'A': tipoCompleto = "Alfil";
            case 'T': tipoCompleto = "Torre";
            case 'Q': tipoCompleto = "Reyna";
            case 'K': tipoCompleto = "Rey";
            default: throw new IllegalArgumentException();
        }
        System.out.println("La pieza es de tipo: " + tipoCompleto);
    }

}
