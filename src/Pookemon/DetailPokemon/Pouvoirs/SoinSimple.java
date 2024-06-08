package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;

public class SoinSimple extends Pouvoir {
    private boolean m_UtiliseCeTour = false;

    /**
     * Cette méthode retourne le nom du pouvoir Soin Simple.
     *
     * @return Le nom du pouvoir Soin Simple, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[92mSoin Simple\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable du pouvoir Soin Simple.
     *
     * @return Le nom comparable du pouvoir Soin Simple.
     */
    @Override
    public String getNomComparable() {
        return "Soin Simple";
    }

    /**
     * Réinitialise l'état d'utilisation du pouvoir pour ce tour.
     */
    @Override
    public void UtilisableCeTour(){
        this.m_UtiliseCeTour = false;
    }

    /**
     * Cette méthode indique si le pouvoir Soin Simple est utilisable.
     *
     * @return true si le pouvoir Soin Simple est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(!this.m_UtiliseCeTour){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Soin Simple cible l'adversaire.
     *
     * @return false car le pouvoir Soin Simple ne cible pas un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return false;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation du pouvoir Soin Simple. Elle soigne le Pokémon cible.
     *
     * @param lanceur Le Pokémon qui utilise le pouvoir Soin Simple.
     * @param cible Le Pokémon sur lequel le pouvoir Soin Simple est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain){
        if (cible.getPv()+30 <= cible.getPvMAX()){
        cible.setPv(cible.getPv() + 30, terrain);
        }else {
            cible.setPv(cible.getPvMAX(), terrain);
        }
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_UtiliseCeTour = true;
    }
}
