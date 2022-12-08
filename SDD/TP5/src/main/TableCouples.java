package main;

import java.rmi.AlreadyBoundException;
import java.security.KeyException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class TableCouples {

    private Couple[] couples;
    private LinkedList<Couple>[] listes;


    public TableCouples(int taille){
        this.listes = new LinkedList[taille];
    }

    public void ajouter(Mot m,Mot trad) throws Exception{

        int indice = m.hashCode() % listes.length;
        Couple c = new Couple(m,trad);

        if(this.listes[indice] == null){
            this.listes[indice] = new LinkedList<Couple>();
            this.listes[indice].add(c);
        }
        else{

            for(Couple couple : this.listes[indice]){
                if(c.getMot() == couple.getMot()){
                    throw new KeyException("clé déjà présente");
                }
            }
            this.listes[indice].add(c);
        }



    }

    public Mot traduire(Mot k) throws Exception{
        int indice = k.hashCode();
        Mot trad = null;
        for(Couple c : this.listes[indice] ){
            trad = c.compCoupleMot(k);
            if(trad != null){
                return trad;
            }
        }
        if(trad == null){
            throw new KeyException("clé pas présente");
        }
        return trad;
    }

    @Override
    public String toString() {
        String res = "";

        for(LinkedList<Couple> listeCouple : this.listes){
            if(listeCouple == null){
                continue;
            }
            for (Couple c : listeCouple) {
                res += c.toString();
                }
        }
        return res;
    }
}
