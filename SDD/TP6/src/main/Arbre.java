package main;

public interface Arbre {
    public Object racine();
    public Arbre arbreG();
    public Arbre arbreD();
    public boolean estVide();
    public void vider();
    public int hauteur();
    public int denombrer(String n);
    public void remplacer(String n1,String n2);
    public String toStringInfixe();
    default void modifRacine(Object r){
        throw new UnsupportedOperationException();
    }

    default void modifArbreG(Object r){
        throw new UnsupportedOperationException();
    }

    default void modifArbreD(Object r){
        throw new UnsupportedOperationException();
    }

    default void dessiner(){
        throw new UnsupportedOperationException();
    }

}
