package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

abstract public class Pouvoir {

    abstract public String getNom();
    public void UtilisableCeTour(){};
    abstract public boolean utilisable();
    public boolean cible(){
        return true;
    }
    abstract public boolean cibleAdversaire();
    abstract public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain);
}
