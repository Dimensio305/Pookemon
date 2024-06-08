package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Type;

public class Kamikaze extends Pouvoir {
    private int m_nbUtil = 1;

    /**
     * Cette méthode retourne le nom du pouvoir Kamikaze.
     *
     * @return Le nom du pouvoir Kamikaze, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[31mKamikaze\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable du pouvoir Kamikaze.
     *
     * @return Le nom comparable du pouvoir Kamikaze.
     */
    @Override
    public String getNomComparable() {
        return "Kamikaze";
    }

    /**
     * Cette méthode indique si le pouvoir Kamikaze est utilisable.
     *
     * @return true si le pouvoir Kamikaze est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Kamikaze cible l'adversaire.
     *
     * @return true car le pouvoir Kamikaze est utilisé sur un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return true;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation du pouvoir Kamikaze. Elle élimine le lanceur et la cible du combat.
     *
     * @param lanceur Le Pokémon qui utilise le pouvoir Kamikaze.
     * @param cible Le Pokémon sur lequel le pouvoir Kamikaze est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        lanceur.setPv(0, terrain);
        cible.setPv(0, terrain);
        this.m_nbUtil-=1;
    }
}
