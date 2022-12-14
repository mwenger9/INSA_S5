package main.quadtrees;

public class QuadTreeConcret implements QuadTree{

    private Noeud racine;
    private Noeud elemCourant;

    public QuadTreeConcret(Noeud racine){
        this.racine = racine;
        this.goToRoot();
    }

    public QuadTreeConcret(Color c){
        this.createRoot(c);
    }

    public QuadTreeConcret(Image img ){
        this.createRoot(null);
        int taille = (int) (Math.log(img.getWidth())/Math.log(2));
        for(int i = 0;i<taille;i++){

        }
    }

    public void createRec(int i, int j, int width,Image img){
        if(width==2){
            for (int k = i; k < i+width; k++) {
                for (int l = j; l < j + width; l++) {
                    Noeud n = new Noeud(img.getPixel(k, l), this.elemCourant);
                }
            }
        }
    }


    @Override
    public boolean emptyTree() {
        return this.racine == null;
    }

    @Override
    public boolean outOfTree() {
        return this.elemCourant == null;
    }

    @Override
    public void goToRoot() {
        this.elemCourant = this.racine;
    }

    @Override
    public void goToParent() {
        if(this.outOfTree()){
            throw new NullPointerException();
        }
        this.elemCourant = this.elemCourant.getPere();
    }

    @Override
    public void goToChild(int i) throws UnsupportedOperationException {
        if(this.elemCourant.getFils() != null && i <= 3 && i >= 0 ){
            this.elemCourant = this.elemCourant.getFils()[i];
        }
        else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean onRoot() {
        return this.elemCourant == this.racine;
    }

    @Override
    public boolean surFeuille() {
        if(this.outOfTree()){
            throw new NullPointerException();
        }
        return this.elemCourant.getFils() == null;
    }

    @Override
    public boolean hasChild(int i) {
        if(this.outOfTree()){
            throw new NullPointerException();
        }
        return this.elemCourant.getFils()[i] != null;
    }

    @Override
    public Color getValue() {
        if(this.outOfTree()){
            throw new NullPointerException();
        }
        return this.elemCourant.getValeur();
    }

    @Override
    public void setValue(Color c) {
        if(this.outOfTree()){
            throw new NullPointerException();
        }
        this.elemCourant.setValeur(c);
    }

    @Override
    public void addChildren(Color[] c) {
        Noeud[] fils = new Noeud[4];
        for(int i=0;i<c.length;i++){
            if(c[i] == null){
                throw new UnsupportedOperationException();
            }
            fils[i] = new Noeud(c[i],this.elemCourant);
        }
        this.elemCourant.setFils(fils);
    }

    @Override
    public void createRoot(Color c) {
        this.racine = new Noeud(c,null);
        this.goToRoot();
    }

    @Override
    public void delete() {
        if(this.outOfTree()){
            throw new NullPointerException();
        }
        this.elemCourant.setFils(null);
        this.elemCourant = this.elemCourant.getPere();
    }

    public void recreate(Image image){
        this.recreateRec(0,0, image.getWidth(), image);
    }

    public void recreateRec(int i, int j,int width,Image m){
        if(this.surFeuille()){
            while(i<width){
                while(j<width){
                    m.setPixel(i,j,this.elemCourant.getValeur());
                    j++;
                }
                i++;
            }
        }

        else{
            this.goToChild(0);
            this.recreateRec(i,j, width /2,m);
            this.goToParent();

            this.goToChild(1);
            this.recreateRec(i+(width/2),j, width /2,m);
            this.goToParent();

            this.goToChild(2);
            this.recreateRec(i+(width/2),j+(width/2), width /2,m);
            this.goToParent();

            this.goToChild(3);
            this.recreateRec(i,j+(width/2), width /2,m);
            this.goToParent();
        }
    }
}
