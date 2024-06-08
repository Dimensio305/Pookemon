package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Boost;
import Pookemon.DetailPokemon.Pokemon;

public class FerveurGuerriere extends Pouvoir{
    private int m_nbUtil = 1;

    /**
     * Cette méthode retourne le nom du pouvoir Ferveur Guerrière.
     *
     * @return Le nom du pouvoir Ferveur Guerrière, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[33mFerveur Guerrière\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable du pouvoir Ferveur Guerrière.
     *
     * @return Le nom comparable du pouvoir Ferveur Guerrière.
     */
    @Override
    public String getNomComparable() {
        return "Ferveur Guerrière";
    }

    /**
     * Cette méthode indique si le pouvoir Ferveur Guerrière est utilisable.
     *
     * @return true si le pouvoir Ferveur Guerrière est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Ferveur Guerrière cible l'adversaire.
     *
     * @return false car le pouvoir Ferveur Guerrière n'est pas utilisé sur un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return false;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation du pouvoir Ferveur Guerrière. Elle ajoute un boost à l'attaque du Pokémon cible.
     *
     * @param lanceur Le Pokémon qui utilise le pouvoir Ferveur Guerrière.
     * @param cible Le Pokémon sur lequel le pouvoir Ferveur Guerrière est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        cible.ajoutBoost(new Boost("Ferveur Guerrière", true, 10, true));
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil-=1;
    }
}
