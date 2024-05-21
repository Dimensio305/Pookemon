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
        for (int i = 0; i < 5; i++) {
            int index = new Random().nextInt(m_deck.getPile().size());
            m_main.addMain(deck.getPile().get(index));
            deck.estTire(index);
        }
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
