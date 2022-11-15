package main;
public class ListeDoubleChainage implements Liste{

    protected Maillon tete,queue;

    public ListeDoubleChainage(){
        Maillon tete = new Maillon();
        Maillon queue = new Maillon();

        tete.setSucc(queue);
        tete.setPred(null);

        queue.setSucc(null);
        queue.setPred(tete);

        this.tete = tete;
        this.queue = queue;
    }

    public boolean estVide(){
        return this.tete.getSucc() == this.queue;
    }


    public void vider(){
        //TODO
    }

    public Iterateur iterateur(){
        return new IterateurDeListeDoublementChainee(this);
    }



}
