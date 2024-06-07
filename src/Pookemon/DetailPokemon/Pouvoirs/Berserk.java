package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Boost;
import Pookemon.DetailPokemon.Pokemon;

public class Berserk extends Pouvoir {
    private int m_nbUtil = 1;

    @Override
    public String getNom() {
        return "\033[31mBerserk\033[0m";
    }

    @Override
    public String getNomComparable() {
        return "Berserk";
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
        return false;
    }

    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        cible.ajoutBoost(new Boost("Berserk", true, cible.getAttaqueInitial(), false));
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil -= 1;
    }
}
