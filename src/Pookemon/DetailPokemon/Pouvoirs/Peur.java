package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Boost;
import Pookemon.DetailPokemon.Pokemon;

public class Peur extends Pouvoir {
    private int m_nbUtil = 1;

    /**
     * Cette méthode retourne le nom du pouvoir Peur.
     *
     * @return Le nom du pouvoir Peur, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[36mPeur\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable du pouvoir Peur.
     *
     * @return Le nom comparable du pouvoir Peur.
     */
    @Override
    public String getNomComparable() {
        return "Peur";
    }

    /**
     * Cette méthode indique si le pouvoir Peur est utilisable.
     *
     * @return true si le pouvoir Peur est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Peur cible l'adversaire.
     *
     * @return true car le pouvoir Peur est utilisé sur un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return true;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation du pouvoir Peur. Elle ajoute un malus à l'attaque du Pokémon cible.
     *
     * @param lanceur Le Pokémon qui utilise le pouvoir Peur.
     * @param cible Le Pokémon sur lequel le pouvoir Peur est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        cible.ajoutBoost(new Boost("Berserk", true, -10, true));
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil -= 1;
    }
}
