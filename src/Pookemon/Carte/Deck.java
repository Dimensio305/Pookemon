package Pookemon.Carte;

import Pookemon.DetailPokemon.Pokemon;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static ArrayList<Integer> m_doublon= new ArrayList<>();

    private ArrayList<Pokemon> m_pile= new ArrayList<>();
    private ArrayList<Pokemon> m_defausse = new ArrayList<>();


    /**
     * Constructeur de la classe Deck.
     * Crée un deck de cartes Pokémon pour un joueur spécifié.
     *
     * @param joueur Le nombre de joueurs pour lesquels le deck est créé.
     *               Le nombre de cartes dans le deck sera de 19 + joueur.
     */
    public Deck(int joueur){
        m_doublon.add(-1);
        for (int i = 0; this.m_pile.size()<(19+joueur);i++) {
            int index = new Random().nextInt(Pokemon.getPokedex().size());
            if (!m_doublon.contains(index)) {
                m_doublon.add(index);
                m_pile.add(Pokemon.getPokedex().get(index));
                index = -1;
            }
        }
    }

    /**
     * Retourne la pile de cartes Pokémon du deck.
     *
     * @return La pile de cartes Pokémon du deck.
     */
    public ArrayList<Pokemon> getPile()
    {
        return this.m_pile;
    }

    /**
     * Retire une carte Pokémon de la pile à l'index spécifié.
     *
     * @param index L'index de la carte à retirer de la pile.
     */
    public void estTire(int index){
        this.m_pile.remove(index);
    }

    /**
     * Vérifie si la pile de cartes Pokémon est vide.
     *
     * @return true si la pile est vide, sinon false.
     */
    public boolean estVide()
    {
        return this.m_pile.size()<=0;
    }

    public void estDefausse(Pokemon p){
        this.m_defausse.add(p);
    }
}
