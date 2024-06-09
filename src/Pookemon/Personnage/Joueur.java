package Pookemon.Personnage;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Defausse;
import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

import java.util.ArrayList;

public abstract class Joueur {
    protected Deck m_deck;
    protected Defausse m_defausse;
    protected Main m_main;

    public Joueur(Deck deck) {
        m_deck = deck;
        for (Pokemon p : this.m_deck.getPile()) {
            p.setJoueur(this);
        }
        m_defausse = new Defausse();
        m_main = new Main(m_deck);
    }

    public Deck getDeck() {
        return m_deck;
    }

    public void pioche(){
        this.getMain().pioche(this.m_deck);
    }

    public Defausse getDefausse() {
        return m_defausse;
    }

    public void defausse(Pokemon p){
        this.getDefausse().estDefausse(p);
    }

    public Main getMain() {
        return m_main;
    }

    public ArrayList<Pokemon> getMainListe() {
        return m_main.getMain();
    }
    public abstract void pokemonDeuil(Pokemon victime, Terrain sceneDuCrime);

    public abstract boolean actionDuTour(Terrain terrain, Joueur adversaire);

    public abstract boolean victoireAdversaire(Terrain terrain);

}
