package Exercici1;

import Keyboard.Keyboard;

public class Exercici1 {

    public static void main(String[] args) {

        node p = new node(1, new node(2, new node(3, new node(4, new node(5, null)))));
        p = esborrar1SenseCapçalera(p, 3);
        node aux = p;
        while (aux != null) {
            System.out.println(aux.inf);
            aux = aux.seg;
        }

    }

    public static node esborrar1SenseCapçalera(node p, int inf) {

        node aux = p;
        boolean trobat = false;
        while (!trobat && aux != null) {
            if (aux.seg.inf == inf) {
                aux.seg = aux.seg.seg;
                trobat = true;
            } else {
                aux = aux.seg;
            }
        }
        return p;
    }

}
