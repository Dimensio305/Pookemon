package Pookemon.Carte;

import Pookemon.DetailPokemon.Pokemon;

import java.util.ArrayList;

public class Defausse {
    private ArrayList<Pokemon> m_defausse = new ArrayList<>();

    /**
     * Ajoute une carte Pokémon à la défausse.
     *
     * @param p La carte Pokémon à ajouter à la défaisse.
     */
    public void estDefausse(Pokemon p){
        this.m_defausse.add(p);
    }

}
