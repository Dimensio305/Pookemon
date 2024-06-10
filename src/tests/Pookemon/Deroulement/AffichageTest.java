package Pookemon.Deroulement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AffichageTest {

    @Test
    void finJeu() {
        new Affichage().finJeu(true);
        new Affichage().finJeu(false);
    }
}