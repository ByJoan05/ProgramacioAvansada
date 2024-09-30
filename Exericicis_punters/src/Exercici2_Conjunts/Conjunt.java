package Exercici2_Conjunts;

public class Conjunt implements ConjuntE {

    private class node {
        // ATRIBUTS
        private int ele;
        private node seg;

        // CONSTRUCTORS
        public node (int e, node s) {
            this.ele = e;
            this.seg = s;
        }
        public node (int e) {
            this(e, null);
        }
    }

    // ATRIBUTS
    private node cap;

    // CONSTRUCTORS
    public Conjunt() { // Inicialitzar
        cap = new node(0);
    }
    public Conjunt (int e) { // Construir
        this();
        cap.ele++;
        cap.seg = new node(e);
    }

    // TOSTRING && EQUALS
    @Override
    public String toString(){
        String a="";
        node aux=this.cap.seg; //cal auxiliar
        for (int i=0; i<this.cap.ele; i++){
            a+=aux.ele+" \n";
            aux=aux.seg;
        }
        return a;
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Conjunt){
            boolean iguals = ((Conjunt)o).cap.ele==this.cap.ele;
            iguals = iguals &&
                ((Conjunt)(this.interseccio((Conjunt)o))).cap.ele==
                        this.cap.ele;
            return iguals;
        }
        return false;
    }

    // MÈTODES
    @Override
    public boolean conjuntBuit() {
        return this.cap.ele == 0 || this.cap.seg == null;
    }

    @Override
    public boolean membre(int ele) {
        boolean trobat = false;
        node aux = this.cap.seg; // Cal un auxiliar
        while (!trobat && aux != null) {
            // No cal anar endarrerits
            if (aux.ele == ele) trobat = true;
            else aux = aux.seg;
        }
        return trobat;
    }

    @Override
    public void inserir(int e) throws Exception {
        // Inserim davant de tot
        if (!this.membre(e)) {
            this.cap.seg = new node (e, this.cap.seg);
            this.cap.ele++;
        }
        else throw new Exception("Repetit");

    }

    @Override
    public int[] contingut() {
        int []m = new int [this.cap.ele];
        node aux = this.cap;
        for (int i = 0; i < this.cap.ele; i++) {
            m[i] = aux.seg.ele;
            aux = aux.seg;
        }
        return m;
    }

    @Override
    public int element(int quin) throws Exception {
        if (quin<1 || quin>this.cap.ele) throw new IndexOutOfBoundsException();
        node aux=this.cap.seg; //saltem el capç
        int salts=1;
        while (salts<quin){
            aux=aux.seg;
            salts++;
        }
        return aux.ele;
    }

    @Override
    public ConjuntE unio(ConjuntE a) {
        Conjunt res = new Conjunt();
        try {
            node aux = this.cap;
            while (aux.seg != null) {
                res.inserir(aux.seg.ele);
                aux = aux.seg;
            }
        } catch (Exception e) {} // No petarà mai

        node aux = ((Conjunt) a).cap;
        while (aux.seg != null) {
            try { res.inserir(aux.seg.ele); }
            catch (Exception e) {
                System.out.println("L'element " + aux.seg.ele + " ja existeix al conjunt");
            }
            aux = aux.seg;
        }
        return res;
    }

    @Override
    public ConjuntE interseccio(ConjuntE a) {
        Conjunt res = new Conjunt();
        node aux = this.cap.seg;
        while (aux != null) {
            if (a.membre(aux.ele)) {
                try { res.inserir(aux.ele); }
                catch (Exception e) {}
            }
            aux = aux.seg;
        }
        return res;
    }
}
