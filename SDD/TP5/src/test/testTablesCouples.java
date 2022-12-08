package test;
import main.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.KeyException;

import static org.junit.jupiter.api.Assertions.*;

public class testTablesCouples {

    private TableCouples tableCouples;

    @Test
    public void testAjouter() throws Exception {
        tableCouples = new TableCouples(12);
        Couple c1 = new Couple(new Mot("clé"),new Mot("Valeur"));
        Couple c2 = new Couple(new Mot("clé"),new Mot("Valeur"));
        tableCouples.ajouter(c1.getMot(),c1.getTraduction());
        tableCouples.ajouter(c2.getMot(),c2.getTraduction());
        assertTrue(c1.getMot().equals(c2.getMot()));
        System.out.println(tableCouples.toString());
        //assertThrows(KeyException.class, () -> tableCouples.ajouter(new Mot("clé"),new Mot("Valeur")));
    }

}
