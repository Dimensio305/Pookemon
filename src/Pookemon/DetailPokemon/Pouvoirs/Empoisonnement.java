package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Statut;

public class Empoisonnement extends Pouvoir {
    private int m_nbUtil = 3;
    private boolean m_UtiliseCeTour = false;

    @Override
    public void UtilisableCeTour(){
        this.m_UtiliseCeTour = false;
    }

    @Override
    public String getNom() {
        return "Empoisonnement";
    }

    @Override
    public boolean utilisable() {
        if(!m_UtiliseCeTour && this.m_nbUtil>0){
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
        cible.setM_statut(Statut.EMPOISONNE);
        this.m_nbUtil -= 1;
        this.m_UtiliseCeTour = true;
    }

}
