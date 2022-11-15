package main;

public class ListeTabulee implements Liste {
    private final static int LMAX = 10;
    protected Object[] elements;
    protected int taille;

    public ListeTabulee(){
        this.elements = new Object[LMAX];
        this.taille = 0;
    }

    public boolean estVide(){
        return taille == 0;
    }


    public void vider(){
        this.taille = 0;
    }

    public Iterateur iterateur(){
        return new IterateurDeListeTabulee(this);
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }


    public int getLMAX() {
        return LMAX;
    }

}
