package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Type;

public class Kamikaze extends Pouvoir {
    private int m_nbUtil = 1;

    @Override
    public String getNom() {
        return "Kamikaze";
    }

    @Override
    public boolean utilisable() {
        if(this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean cibleAdversaire() {
        return true;
    }

    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        lanceur.setM_pv(0, terrain);
        cible.setM_pv(0, terrain);
        this.m_nbUtil-=1;
    }
}
