package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FerveurGuerriereTest {

    @Test
    void onUse() {
        Pokemon p1 = new Pokemon("Utilisateur");
        Pokemon p2 = new Pokemon("cible");
        Terrain terrain = new Terrain();
        p1.setPouvoir(new FerveurGuerriere());
        p1.getPouvoir().onUse(p1, p2, terrain);
        Assertions.assertEquals(p2.getAttaqueInitial()+10, p2.getAttaque());
    }
}