package Exercici1;

public class node {

    int inf;
    node seg;
    public node(int inf) {
        this(inf, null);
    }
    public node(int inf, node seg) {
        this.inf = inf;
        this.seg = seg;
    }


}
