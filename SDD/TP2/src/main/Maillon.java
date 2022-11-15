package main;

public class Maillon {
    private Maillon pred;
    private Maillon succ;
    private Object val;

    public Maillon getPred() {
        return pred;
    }

    public Object getVal() {
        return val;
    }

    public Maillon getSucc() {
        return succ;
    }

    public void setPred(Maillon pred) {
        this.pred = pred;
    }

    public void setSucc(Maillon succ) {
        this.succ = succ;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
