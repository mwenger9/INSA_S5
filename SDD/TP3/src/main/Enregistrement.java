package main;

public class Enregistrement {
    private String nomVille;
    private Coordonnees coo;
    private int population;


    public Enregistrement(String nomVille,Coordonnees coo, int population){
        this.nomVille = nomVille;
        this.coo = coo;
        this.population = population;
    }

    public Enregistrement(String nomVille,float x, float y, int population){
        this.nomVille = nomVille;
        this.coo = new Coordonnees(x,y);
        this.population = population;
    }

    public String getNomVille() {
        return nomVille;
    }

    public int getPopulation() {
        return population;
    }

    public Coordonnees getCoo() {
        return coo;
    }

    @Override
    public String toString() {
        return "nom: " + this.nomVille + this.coo.toString() + "; Population : " + this.population;
    }
}
