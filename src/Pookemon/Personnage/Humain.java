package Pookemon.Personnage;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Defausse;
import Pookemon.Carte.Terrain;

import java.util.Random;
import java.util.Scanner;

public class Humain extends Joueur {

    public Humain(Deck deck) {
        super(deck);
    }

    public void ajoutPokemon(Terrain terrain){
        Scanner s = new Scanner(System.in);
        String choix = s.nextLine();
        if(this.getM_main().contient(choix)) {
            terrain.ajoutPokemonJoueur(this.getM_main(), this.getM_main().getIndex(choix));
        }
        switch (choix){
            case "1":
                terrain.ajoutPokemonJoueur(this.getM_main(), 0);
                break;
            case "2":
                if(this.getM_main().getMain().size()>1){terrain.ajoutPokemonJoueur(this.getM_main(),1);}
                break;
            case "3":
                if(this.getM_main().getMain().size()>2){terrain.ajoutPokemonJoueur(this.getM_main(),2);}
                break;
            case "4":
                if(this.getM_main().getMain().size()>3){terrain.ajoutPokemonJoueur(this.getM_main(),3);}
                break;
            case "5":
                if(this.getM_main().getMain().size()>4){terrain.ajoutPokemonJoueur(this.getM_main(),4);}
                break;
        }
    }
}
