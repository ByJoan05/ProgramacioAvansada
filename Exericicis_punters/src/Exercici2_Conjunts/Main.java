package Exercici2_Conjunts;

public class Main {
    public static void main(String[] args) {
        Conjunt a,b;
        a=new Conjunt(2);
        try{a.inserir(3);}catch(Exception e){}
        try{a.inserir(4);}catch(Exception e){}
        try{a.inserir(8);}catch(Exception e){}
        System.out.println(a);
        b=new Conjunt(3);
        try{b.inserir(10);}catch(Exception e){}
        try{b.inserir(8);}catch(Exception e){}
        System.out.println(b);
        System.out.println(a.unio(b));
        System.out.println(a.interseccio(b));
    }
}
