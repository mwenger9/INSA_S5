package main;

public class IterateurDeListeDoublementChainee implements Iterateur{

    ListeDoubleChainage l;
    private Maillon ec;

    public IterateurDeListeDoublementChainee(ListeDoubleChainage l){
        this.l = l;
        if (this.l.tete.getSucc() != null){
            this.ec = this.l.tete.getSucc();
        }
        else {
            this.ec = l.tete;
        }
    }

    @Override
    public void entete() {
        if(!l.estVide()){
            this.ec = l.tete.getSucc();
        }
        
    }

    @Override
    public void enqueue() {
        if(!l.estVide()){
            this.ec = l.queue.getPred();
        }
    }

    @Override
    public void succ() {
        if(l.estVide() || estSorti() || ec.getSucc() == this.l.queue) {
            throw new IndexOutOfBoundsException("EC est hors de la liste ou veut en sortir");
        }
        this.ec = this.ec.getSucc();
    }

    @Override
    public void pred() {
        if(l.estVide() || estSorti() || ec.getPred() == l.tete) {
            throw new IndexOutOfBoundsException("EC est hors de la liste ou veut en sortir");
        }
        this.ec = ec.getPred();
        
    }

    @Override
    public void ajouterD(Object o) {
        Maillon nouvMaillon = new Maillon();
        nouvMaillon.setVal(o);
        nouvMaillon.setSucc(ec.getSucc());
        nouvMaillon.setPred(ec);
        ec.getSucc().setPred(nouvMaillon);
        ec.setSucc(nouvMaillon);

        if(ec == l.tete){
            this.entete();
        } else this.succ();
        
    }

    @Override
    public void oterec() {
        if(!estSorti()){
            ec.getSucc().setPred(ec.getPred());
            ec.getPred().setSucc(ec.getSucc());
            ec = ec.getSucc();
        }
        
    }

    @Override
    public Object valec() {
        if(this.estSorti()){
            throw new IndexOutOfBoundsException("EC est hors de la liste");
        }
        return this.ec.getVal();
    }

    @Override
    public boolean estSorti() {
        return (this.ec == l.tete || this.ec == l.queue);
    }

    @Override
    public void modifec(Object o) {
        this.ec.setVal(o);
        
    }

}