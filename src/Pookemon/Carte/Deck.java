package Pookemon.Carte;

import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Pouvoirs.*;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static ArrayList<Integer> m_doublon= new ArrayList<>();

    private ArrayList<Pokemon> m_pile= new ArrayList<>();

    /**
     * Constructeur de la classe Deck.
     * Crée un deck de cartes Pokémon pour un joueur spécifié.
     *
     * @param joueur Le nombre de joueurs pour lesquels le deck est créé.
     *               Le nombre de cartes dans le deck sera de 19 + joueur.
     */
    public Deck(int joueur){
        m_doublon.add(-1);
        int index;
        while(this.m_pile.size()<(19+joueur)) {
            index = new Random().nextInt(Pokedex.getPokedex().size());
            if (!m_doublon.contains(index)) {
                m_doublon.add(index);
                m_pile.add(Pokedex.getPokedex().get(index));
                index = -1;
            }
        }
        index = new Random().nextInt(19+joueur);
        this.m_pile.get(index).setPouvoir(new Berserk());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new Empoisonnement());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new FerveurGuerriere());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new Kamikaze());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new Peur());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new SoinDeZone());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new SoinSimple());
        while (this.m_pile.get(index).getPouvoir()!=null){
            index = new Random().nextInt(19+joueur);
        }
        this.m_pile.get(index).setPouvoir(new SoinTotal());

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
}
