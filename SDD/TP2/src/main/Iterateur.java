package main;

public interface Iterateur {
    public void entete();
    public void enqueue();
    public void succ();
    public void pred();
    public void ajouterD(Object o);
    public void oterec();
    public Object valec();
    public boolean estSorti();
    public void modifec(Object o);
}
