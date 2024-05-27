package Pookemon.Personnage;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Defausse;
import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

public abstract class Joueur {
    protected Deck m_deck;
    protected Defausse m_defausse;
    protected Main m_main;

    public Joueur(Deck deck) {
        m_deck = deck;
        m_defausse = new Defausse();
        m_main = new Main(m_deck);
    }

    public Deck getM_deck() {
        return m_deck;
    }

    public void pioche(){
        this.getM_main().pioche(this.m_deck);
    }

    public Defausse getM_defausse() {
        return m_defausse;
    }

    public void defausse(Pokemon p){
        this.getM_deck().estDefausse(p);
    }

    public Main getM_main() {
        return m_main;
    }

    public ArrayList<Pokemon> getMainListe() {
        return m_main.getMain();
    }

    public abstract boolean actionDuTour(Terrain terrain, Joueur adversaire);

}
