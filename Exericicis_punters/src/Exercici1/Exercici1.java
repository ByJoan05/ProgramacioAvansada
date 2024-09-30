package Exercici1;

import Keyboard.Keyboard;

public class Exercici1 {

    public static void main(String[] args) {

        node p = new node(1, new node(2, new node(3, new node(4, new node(5, null)))));
        p = esborrar1SenseCapsalera(p, 3);
        node aux = p;
        while (aux != null) {
            System.out.println(aux.inf);
            aux = aux.seg;
        }

    }

    public static node esborrar1SenseCapsalera(node p, int inf) { // RECORREGUT - Sense Cap.
         if (p == null) return null;
         if (p.inf == inf) return p.seg;
        boolean trobat = false; node aux = p;
        while (!trobat && aux.seg != null) {
            if (aux.seg.inf == inf) {
                aux.seg = aux.seg.seg;
                trobat = true;
            } else aux = aux.seg;
        }
        return p;
    }

    public static void esborrar1AmbCapsalera(node p, int inf) { // RECORREGUT - Amb Cap.
        boolean trobat = false; node aux = p;
        while (!trobat && aux.seg != null) {
            if (aux.seg.inf == inf) {
                aux.seg = aux.seg.seg;
                trobat = true;
            } else aux = aux.seg;
        }
    }

    public static node esborrar1SenseCapseleraCirtcular(node p, int inf) { // CERCA - Sense Cap.
        if (p==null) return null;
        if (p.inf == inf) {
            if (p.seg == p) return null;
            node aux = p;
            while (aux.seg != p) aux = aux.seg;
            aux.seg = p.seg;
            return p.seg;
        }
        boolean trobat = false; node aux = p;
        while (!trobat && aux.seg != p) {
            if(aux.seg.inf == inf) {
                trobat = true;
                aux.seg = aux.seg.seg;
            }
            else aux = aux.seg;
        }
        return p;
    }

    public static node esborrarSenseCapsalera (node p, int inf) { // ESBORRAR TOTS - Sense Cap.
        // Recorregut
        if (p == null) return null;
        node aux = p;
        while (aux.seg != null) {
            if (aux.seg.inf == inf) aux.seg = aux.seg.seg; // NO avançem la referència
            else aux = aux.seg;
        }
        if (p.inf == inf) return p.seg; // Tractem el primer
        return p;
    }

    public static void esborrarAmbCapsalera (node p, int inf) { // ESBORRAR TOTS - Amb Cap
        // Recorregut
        node aux = p;
        while (aux.seg != null) {
            if (aux.seg.inf == inf) aux.seg = aux.seg.seg; // NO avançem la referència
            else aux = aux.seg;
        }
    }

}
