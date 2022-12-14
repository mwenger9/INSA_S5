package main;

public class Noeud {
    private Object val;
    private Noeud filsG;
    private Noeud filsD;

    public Noeud(Object val){
        this.val = val;
        this.filsG = null;
        this.filsD = null;
    }

    public Noeud(Object val,Noeud filsG,Noeud filsD){
        this.val = val;
        this.filsG = filsG;
        this.filsD = filsD;
    }



    public Noeud getFilsD() {
        return filsD;
    }


    public Noeud getFilsG() {
        return filsG;
    }

    public void setFilsD(Noeud filsD) {
        this.filsD = filsD;
    }

    public void setFilsG(Noeud filsG) {
        this.filsG = filsG;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
