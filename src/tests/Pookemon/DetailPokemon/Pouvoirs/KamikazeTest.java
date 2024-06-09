package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Pokedex;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.Personnage.Humain;
import Pookemon.Personnage.IA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KamikazeTest {

    @Test
    void onUse() {

        Pokemon p1 = new Pokemon("Utilisateur");
        Pokemon p2 = new Pokemon("cible");
        for (String nom: Pokedex.getNom()) {
            new Pokemon(nom);
        }
        p1.setJoueur(new Humain(new Deck(1)));
        p2.setJoueur(new IA(new Deck(2)));
        Terrain terrain = new Terrain();
        terrain.ajoutDeForceJoueur(p1);
        terrain.ajoutDeForceIA(p2);
        p1.setPouvoir(new Kamikaze());
        p1.getPouvoir().onUse(p1, p2, terrain);
        Assertions.assertTrue(p1.estMort()&&p2.estMort());
    }
}