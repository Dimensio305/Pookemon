package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Statut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpoisonnementTest {

    @Test
    void onUse() {
        Pokemon p1 = new Pokemon("Utilisateur");
        Pokemon p2 = new Pokemon("cible");
        Terrain terrain = new Terrain();
        p1.setPouvoir(new Empoisonnement());
        p1.getPouvoir().onUse(p1, p2, terrain);
        Assertions.assertEquals(Statut.EMPOISONNE, p2.getStatut());
    }
}