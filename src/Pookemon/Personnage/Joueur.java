package Pookemon.Personnage;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Defausse;
import Pookemon.Carte.Main;

import java.util.Random;

public class Joueur {
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

    public Defausse getM_defausse() {
        return m_defausse;
    }

    public Main getM_main() {
        return m_main;
    }


}
