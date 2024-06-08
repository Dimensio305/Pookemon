package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;

public class SoinTotal extends Pouvoir {
    private int m_nbUtil = 1;

    /**
     * Cette méthode retourne le nom du pouvoir Soin Total.
     *
     * @return Le nom du pouvoir Soin Total, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[92mSoin Total\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable du pouvoir Soin Total.
     *
     * @return Le nom comparable du pouvoir Soin Total.
     */
    @Override
    public String getNomComparable() {
        return "Soin Total";
    }

    /**
     * Cette méthode indique si le pouvoir Soin Total est utilisable.
     *
     * @return true si le pouvoir Soin Total est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Soin Total cible l'adversaire.
     *
     * @return false car le pouvoir Soin Total ne cible pas un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return false;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation du pouvoir Soin Total. Elle soigne complètement le Pokémon cible.
     *
     * @param lanceur Le Pokémon qui utilise le pouvoir Soin Total.
     * @param cible Le Pokémon sur lequel le pouvoir Soin Total est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain){
        cible.setPv(cible.getPvMAX(), terrain);
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil-=1;
    }
}
