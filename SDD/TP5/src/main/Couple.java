package main;

import java.util.Collection;

public class Couple {
    private Mot mot;
    private Mot traduction;

    public Couple(Mot mot, Mot traduction){
        this.mot = mot;
        this.traduction = traduction;
    }
    @Override
    public String toString() {
        return "mot : " + mot.toString() + "; traduction : " + traduction.toString() + "\n";
    }

    public Mot getMot() {
        return mot;
    }

    public Mot getTraduction() {
        return traduction;
    }

    public void setTraduction(Mot traduction) {
        this.traduction = traduction;
    }

    public Mot compCoupleMot(Mot m){
        return (this.mot == m ? traduction : null);
    }
}
