package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Pokedex;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.Personnage.Humain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SoinTotalTest {

    @Test
    void onUse() {

        Pokemon p1 = new Pokemon("Utilisateur");
        Pokemon p2 = new Pokemon("cible");
        for (String nom: Pokedex.getNom()) {
            new Pokemon(nom);
        }
        p1.setJoueur(new Humain(new Deck(1)));
        p2.setJoueur(new Humain(new Deck(2)));
        Terrain terrain = new Terrain();
        terrain.ajoutDeForceJoueur(p1);
        terrain.ajoutDeForceJoueur(p2);
        p1.setPouvoir(new SoinTotal());
        p1.getPouvoir().onUse(p1, p2, terrain);
        Assertions.assertEquals(p2.getPvMAX(),p2.getPv());
        p2.setPv(1, terrain);
        p1.getPouvoir().onUse(p1,p2,terrain);
        Assertions.assertEquals(p2.getPvMAX(),p2.getPv());
    }
}