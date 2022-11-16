package test;

import main.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class testBdGeographique {

    Enregistrement e1 = new Enregistrement("Marseille",5.0f,-20.0f,5);
    Enregistrement e2 = new Enregistrement("Paris",2.0f,7.0f,15);
    private  BdGeographique testDB = new BdGeographique();
    @BeforeEach
    void setUp(){
        Enregistrement e1 = new Enregistrement("Marseille",5.0f,-20.0f,217890);
        Enregistrement e2 = new Enregistrement("Paris",2.0f,7.0f,1500000);
        BdGeographique testDB = new BdGeographique();
    }

    @Test
    void testInit(){
        assertEquals(0,testDB.getListeEnregistements().size());
    }

    @Test
    void testAdd() throws PresentException {
        testDB.ajouter(e1);
        Assert.assertTrue(testDB.estPresent(e1));
        Assert.assertThrows(PresentException.class, () -> testDB.ajouter(e1));

    }

    @Test
    void testRemove() throws AbsentException, PresentException {
        assertThrows(AbsentException.class, () -> testDB.retirer(e1));
        testDB.ajouter(e1);
        testDB.retirer(e1);
        assertFalse(testDB.estPresent(e1));
        assertThrows(AbsentException.class, () -> testDB.retirer(e1));
    }

    @Test
    void testVille() throws PresentException{
        testDB.ajouter(e1);
        testDB.ajouter(e2);

        assertEquals(e2,testDB.ville("Paris"));
    }

    @Test
    void testCoo() throws PresentException{
        testDB.ajouter(e1);
        testDB.ajouter(e2);

        assertEquals(e2,testDB.coord(new Coordonnees(2.0f,7.0f)));
    }

    @Test
    void testPop() throws PresentException {
        testDB.ajouter(e1);
        testDB.ajouter(e2);

        assertEquals(20,testDB.population());
    }




}
