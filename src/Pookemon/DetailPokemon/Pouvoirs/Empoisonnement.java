package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Statut;

public class Empoisonnement extends Pouvoir {
    private int m_nbUtil = 3;
    private boolean m_UtiliseCeTour = false;

    /**
     * Réinitialise l'état d'utilisation de l'objet pour ce tour.
     */
    @Override
    public void UtilisableCeTour(){
        this.m_UtiliseCeTour = false;
    }

    /**
     * Cette méthode retourne le nom de l'objet Empoisonnement.
     *
     * @return Le nom de l'objet Empoisonnement, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[35mEmpoisonnement\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable de l'objet Empoisonnement.
     *
     * @return Le nom comparable de l'objet Empoisonnement.
     */
    @Override
    public String getNomComparable() {
        return "Empoisonnement";
    }

    /**
     * Cette méthode indique si l'objet Empoisonnement est utilisable.
     *
     * @return true si l'objet Empoisonnement est utilisable ce tour et qu'il reste des utilisations, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(!m_UtiliseCeTour && this.m_nbUtil>0){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si l'objet Empoisonnement cible l'adversaire.
     *
     * @return true car l'objet Empoisonnement est utilisé sur un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return true;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation de l'objet Empoisonnement. Elle applique le statut d'empoisonnement au Pokémon cible.
     *
     * @param lanceur Le Pokémon qui utilise l'objet Empoisonnement.
     * @param cible Le Pokémon sur lequel l'objet Empoisonnement est utilisé.
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain) {
        cible.setStatut(Statut.EMPOISONNE);
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_nbUtil -= 1;
        this.m_UtiliseCeTour = true;
    }

}
