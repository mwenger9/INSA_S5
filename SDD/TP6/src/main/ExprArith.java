package main;

import java.util.HashMap;
import java.util.Map;

public class ExprArith {
    private Arbre arbre;

    public Map<String,Double> map;

    public ExprArith(){
        this.arbre = new ArbreConcret();
        this.map = new HashMap<>();
    }

    public void associerValeur(String symbole,double valeur){
        this.map.put(symbole,valeur);
    }

    @Override
    public String toString() {
        return this.arbre.toStringInfixe();
    }


}
