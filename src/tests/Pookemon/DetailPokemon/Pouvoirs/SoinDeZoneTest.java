package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Pokedex;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.Personnage.Humain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoinDeZoneTest {

    @Test
    void onUse() {

        Pokemon p1 = new Pokemon("Utilisateur");
        Pokemon p2 = new Pokemon("Ami1");
        Pokemon p3 = new Pokemon("Ami2");
        for (String nom: Pokedex.getNom()) {
            new Pokemon(nom);
        }
        p1.setJoueur(new Humain(new Deck(1)));
        p2.setJoueur(new Humain(new Deck(1)));
        p2.setJoueur(new Humain(new Deck(1)));
        Terrain terrain = new Terrain();
        terrain.ajoutDeForceJoueur(p1);
        terrain.ajoutDeForceJoueur(p2);
        terrain.ajoutDeForceJoueur(p3);
        p1.setPouvoir(new SoinDeZone());
        int p1PvAvantSoin = p1.getPv();
        int p2PvAvantSoin = p2.getPv();
        int p3PvAvantSoin = p3.getPv();
        p1.getPouvoir().onUse(p1, p2, terrain);
        Assertions.assertTrue((p1.getPvMAX()==p1.getPv()||p1PvAvantSoin+10==p1.getPv())&&(p2.getPvMAX()==p2.getPv()||p2PvAvantSoin+10==p2.getPv())&&(p3.getPvMAX()==p3.getPv()||p3PvAvantSoin+10==p3.getPv()));
        p2.setPv(50, terrain);
        p3.setPv(1, terrain);
        p1.setPv(p1.getPvMAX()-5, terrain);
        p1PvAvantSoin = p1.getPv();
        p2PvAvantSoin = p2.getPv();
        p3PvAvantSoin = p3.getPv();
        p1.getPouvoir().onUse(p1,p2,terrain);
        Assertions.assertTrue((p1.getPvMAX()==p1.getPv()||p1PvAvantSoin+10==p1.getPv())&&(p2.getPvMAX()==p2.getPv()||p2PvAvantSoin+10==p2.getPv())&&(p3.getPvMAX()==p3.getPv()||p3PvAvantSoin+10==p3.getPv()));
    }
}