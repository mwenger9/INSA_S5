package main;

public class IterateurDeListeTabulee implements Iterateur {

    private ListeTabulee l;
    private int ec;

    public IterateurDeListeTabulee() {
        this.l = new ListeTabulee();
        this.ec = 0;
    }

    public IterateurDeListeTabulee(ListeTabulee l) {
        this.l = l;
    }

    public void entete() {
        this.ec = 0;
    }

    public void enqueue() {
        if (!this.l.estVide()) {
            this.ec = (this.l.taille - 1);
        }
    }

    public void succ() throws IndexOutOfBoundsException {
        if (this.ec == this.l.taille - 1) {
            throw new IndexOutOfBoundsException("Sorti de la liste");
        }
        this.ec = (this.ec + 1);
    }

    public void pred() {
        if (this.ec == 0) {
            throw new IndexOutOfBoundsException("Sorti de la liste");
        }
        this.ec--;
    }

    public Object valec() {
        return this.l.elements[ec];
    }

    public void modifec(Object o) {
        this.l.elements[ec] = o;
    }

    public void ajouterD(Object o) {
        this.decalerD();
        ec++;
        modifec(o);
    }

    public void ajouterG(Object o) {
        this.decalerD();
        modifec(o);
    }

    public void oterec() throws IndexOutOfBoundsException {
        if (this.l.estVide()) {
            throw new IndexOutOfBoundsException("La liste est vide");
        }
        for (int i = ec; i < l.taille - 1; i++) {
            this.l.elements[i] = this.l.elements[i + 1];
        }
        l.taille--;
    }

    public boolean estSorti() {
        return (this.ec >= l.taille || this.ec < 0);
    }

    public void decalerD() throws IndexOutOfBoundsException {
        if (this.l.taille == this.l.getLMAX()) {
            throw new IndexOutOfBoundsException("La liste est pleine");
        }
        for (int i = this.l.taille; i > this.ec; i--) {
            this.l.elements[i + 1] = this.l.elements[i];
        }
        this.l.taille++;
    }

    public static void main(String[] args) {
        System.out.println("coucou");
    }

}
