package main;

public class ArbreConcret implements Arbre{


    Noeud racine;

    public ArbreConcret(){
    }

    public ArbreConcret(Noeud n){
        this.racine = n;
    }

    @Override
    public Object racine() {
        return racine;
    }

    @Override
    public Arbre arbreG() {
        return this.racine.getFilsG() == null ? null : new ArbreConcret(racine.getFilsG());
    }

    @Override
    public Arbre arbreD() {
        return this.racine.getFilsD() == null ? null : new ArbreConcret(racine.getFilsD());
    }

    @Override
    public boolean estVide() {
        return this.racine == null;
    }

    @Override
    public void vider() {
        this.racine = null;
    }

    @Override
    public String toString() {
        String res = "";
        Arbre arbreG = this.arbreG();
        Arbre arbreD = this.arbreD();
        if (arbreG != null){
            res += arbreG.toString();
        }
        if(arbreD != null){
            res += arbreD.toString();
        }
        res += " " + racine.getVal().toString();
        return res;
    }

    public int hauteur(){
        if(this.racine == null){
            return 0;
        }
        int hauteurG = this.arbreG() != null ? this.arbreG().hauteur() : 0;
        int hauteurD = this.arbreD() != null ? this.arbreD().hauteur() : 0;
        return Integer.max(1 + hauteurG,1 + hauteurD);
    }

    public int denombrer(String n){
        if(this.racine == null){
            return 0;
        }

        int res_courant = this.racine.getVal().equals(n) ? 1 : 0;

        int nboccG = this.arbreG() != null ? this.arbreG().denombrer(n) : 0;
        int nboccD = this.arbreD() != null ? this.arbreD().denombrer(n) : 0;
        return res_courant + nboccD + nboccG;
    }

    public void remplacer(String n1,String n2){
        if(this.racine == null){
            return;
        }

        if(this.racine.getVal().equals(n1)){
            this.racine.setVal(n2);
        }

        Arbre arbreG = this.arbreG();
        Arbre arbreD = this.arbreD();
        if(arbreG != null){
            this.arbreG().remplacer(n1,n2);
        }

        if(arbreD != null){
            this.arbreD().remplacer(n1,n2);
        }
    }

    public String toStringInfixe(){
        String res = "";
        Arbre arbreG = this.arbreG();
        Arbre arbreD = this.arbreD();

        if (arbreG != null){
            res+="(";
            res += arbreG.toStringInfixe();
        }
        res += racine.getVal().toString();
        if(arbreD != null){
            res += arbreD.toStringInfixe();
            res+=")";
        }
        return res;
    }
}
