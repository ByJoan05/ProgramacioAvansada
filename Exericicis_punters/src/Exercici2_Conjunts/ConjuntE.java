package Exercici2_Conjunts;

public interface ConjuntE {

    boolean conjuntBuit();
    boolean membre (int valor);
    void inserir(int valor) throws Exception;
    int[] contingut();
    int element (int quin) throws Exception;
    ConjuntE unio (ConjuntE a);
    ConjuntE interseccio (ConjuntE e);

}
