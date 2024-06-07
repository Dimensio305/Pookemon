package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
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
        return "\033[35mEmpoisonnement\033[0m";
    }

    @Override
    public String getNomComparable() {
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
        cible.setStatut(Statut.EMPOISONNE);
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil -= 1;
        this.m_UtiliseCeTour = true;
    }

}
