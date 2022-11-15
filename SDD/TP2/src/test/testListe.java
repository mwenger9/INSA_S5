package test;

import main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testListe {

    Liste l;
    Liste l2;
    @BeforeEach
    void setUp(){
        Liste l = new ListeTabulee();
        Liste l2 = new ListeTabulee();
        System.out.println("Je me lance");
        l2.ajouterD(5);
        l2.ajouterD(4);
        l2.ajouterD(2);
        l2.ajouterD(1);
        System.out.println("J'ai fini");
    }

    @Test
    void testEstVide(){
        Liste l = new ListeDoubleChainage();

        assertTrue(l.estVide());
        int i = 5;
        l.ajouterD(i);
        assertTrue(!l.estVide());
    }

    @Test
    void testValec(){
       Liste l2 = new ListeDoubleChainage();
        l2.ajouterD(5);
        l2.ajouterD(4);
        l2.ajouterD(2);
        l2.ajouterD(1);
        
        assertEquals(l2.valec(),1);
        l2.succ();
        assertThrows(IndexOutOfBoundsException.class, () -> l2.valec());
    }
}
