public class Horaire {
    private int heure;
    private String jour;

    public Horaire(String jour, int heure){
        this.heure = heure;
        this.jour = jour;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    @Override
    public String toString() {
        return "jour : " + jour + "heure : " + heure;
    }
}
