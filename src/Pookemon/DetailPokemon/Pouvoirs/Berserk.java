package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Boost;
import Pookemon.DetailPokemon.Pokemon;

public class Berserk extends Pouvoir {
    private int m_nbUtil = 1;

    /**
     * Cette méthode retourne le nom de l'objet Berserk.
     *
     * @return Le nom de l'objet Berserk, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[31mBerserk\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable de l'objet Berserk.
     *
     * @return Le nom comparable de l'objet Berserk.
     */
    @Override
    public String getNomComparable() {
        return "Berserk";
    }

    /**
     * Cette méthode indique si l'objet Berserk est utilisable.
     *
     * @return true si l'objet Berserk est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si l'objet Berserk cible l'adversaire.
     *
     * @return false car l'objet Berserk n'est pas utilisé sur un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return false;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation de l'objet Berserk. Elle ajoute un boost à la statistique d'attaque du Pokémon cible.
     *
     * @param lanceur Le Pokémon qui utilise l'objet Berserk.
     * @param cible Le Pokémon sur lequel l'objet Berserk est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        cible.ajoutBoost(new Boost("Berserk", true, cible.getAttaqueInitial(), false));
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil -= 1;
    }
}
