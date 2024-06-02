package Pookemon.Carte;

import Pookemon.DetailPokemon.Pokemon;

import java.util.ArrayList;

public class Defausse {
    private ArrayList<Pokemon> m_defausse = new ArrayList<>();

    public void estDefausse(Pokemon p){
        this.m_defausse.add(p);
    }

}
