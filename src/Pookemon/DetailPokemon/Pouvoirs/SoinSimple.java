package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

public class SoinSimple extends Pouvoir {
    private boolean m_UtiliseCeTour = false;

    @Override
    public String getNom() {
        return "Soin Simple";
    }

    @Override
    public void UtilisableCeTour(){
        this.m_UtiliseCeTour = false;
    }

    @Override
    public boolean utilisable() {
        if(!this.m_UtiliseCeTour){
            return true;
        }
        return false;
    }

    @Override
    public boolean cibleAdversaire() {
        return false;
    }

    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain){
        if (cible.getPv()+30 <= cible.getPvMAX()){
        cible.setPv(cible.getPv() + 30, terrain);
        }else {
            cible.setPv(cible.getPvMAX(), terrain);
        }
        this.m_UtiliseCeTour = true;
    }
}
