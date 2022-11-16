package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class BdGeographique {

    private Collection<Enregistrement> listeEnregistements;

    public BdGeographique(){
        this.listeEnregistements = new LinkedList<Enregistrement>();

    }


    public boolean estPresent(Enregistrement e){
        return this.listeEnregistements == null ? false : this.listeEnregistements.contains(e);
    }

    public Collection<Enregistrement> getListeEnregistements() {
        return listeEnregistements;
    }

    public void vider(){
        this.listeEnregistements.clear();
    }

    public void ajouter(Enregistrement e) throws PresentException{
        if(estPresent(e)){
            throw new PresentException();
        }
        this.listeEnregistements.add(e);
    }

    public void retirer(Enregistrement e) throws AbsentException{
        if(!estPresent(e)){
            throw new AbsentException();
        }
        this.listeEnregistements.remove(e);
    }

    public Enregistrement ville(String v){
        for (Enregistrement e: this.listeEnregistements) {
            if(e.getNomVille() == v) {
                return e;
            }
        }
        return null;
    }

    public Enregistrement coord(Coordonnees c){
        for (Enregistrement e: this.listeEnregistements) {
            if(e.getCoo().getX() == c.getX() && e.getCoo().getY() == c.getY() ) {
                return e;
            }
        }
        return null;
    }

    public void retirerVille(String v) throws AbsentException{
        Enregistrement aRetirer = this.ville(v);
        if(aRetirer == null){
            throw new AbsentException();
        }

        this.retirer(aRetirer);
    }

    public void retirerCoo(Coordonnees c) throws AbsentException{
        Enregistrement aRetirer = this.coord(c);
        if(aRetirer == null){
            throw new AbsentException();
        }

        this.retirer(aRetirer);
    }

    public int population(){

        int res = 0;
        for (Enregistrement e : this.listeEnregistements) {
            res += e.getPopulation();
        }
        return res;
    }



}
