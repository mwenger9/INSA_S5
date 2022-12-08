package main;

public class Mot {

    private String mot;

    public Mot(String mot){
        this.mot = mot.toLowerCase();
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }

    @Override
    public int hashCode() {
        return ((int) mot.charAt(0)) * 26 + ((int) mot.charAt(1));
    }

    @Override
    public String toString() {
        return this.mot;
    }


    public boolean equals(Mot m){
        return this.mot.equals(m.getMot());
    }


}
