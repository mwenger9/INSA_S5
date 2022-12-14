package main.quadtrees;

import java.util.Collections;

public class Noeud {
    private Color valeur;
    private Noeud pere;
    private Noeud[] fils;


    public Noeud(Color valeur, Noeud pere){
        this.valeur = valeur;
        this.pere = pere;
        this.fils = null;
    }

    public Noeud(Color valeur, Noeud pere,Noeud[] fils){
        if(fils.length != 4){
            throw new UnsupportedOperationException();
        }
        for(Noeud n:fils){
            if (n == null){
                throw new UnsupportedOperationException();
            }
        }

        this.valeur = valeur;
        this.pere = pere;
        this.fils = fils;
    }

    public Color getValeur() {
        return valeur;
    }

    public Noeud getPere() {
        return pere;
    }

    public Noeud[] getFils() {
        return fils;
    }

    public void setFils(Noeud[] fils) {
        this.fils = fils;
    }

    public void setPere(Noeud pere) {
        this.pere = pere;
    }

    public void setValeur(Color valeur) {
        this.valeur = valeur;
    }
}
