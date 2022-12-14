package main;

public class testArbre {

    public static void main(String[] args) {
        Arbre arbre = new ArbreConcret(
                new Noeud("+",
                        new Noeud("*",
                                new Noeud("4"),
                                new Noeud("pi")
                        ),
                        new Noeud("/",
                                new Noeud("2"),
                                new Noeud("2"))
                ));

        System.out.println(arbre.toString());
        System.out.println(arbre.hauteur());
        System.out.println(arbre.denombrer("2"));
        arbre.remplacer("2","24");
        System.out.println(arbre.denombrer("24"));
        System.out.println(arbre.toStringInfixe());
    }


}
