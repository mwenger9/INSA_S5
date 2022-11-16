package main;

public class Coordonnees {
    private float x;
    private float y;

    public Coordonnees(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X : " + this.getX() + "; Y :" + this.getY();
    }
}
