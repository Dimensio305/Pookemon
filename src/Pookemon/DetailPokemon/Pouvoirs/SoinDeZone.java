package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;

public class SoinDeZone extends Pouvoir {
    private boolean m_UtiliseCeTour = false;

    /**
     * Cette méthode retourne le nom du pouvoir Soin de Zone.
     *
     * @return Le nom du pouvoir Soin de Zone, avec une mise en forme de couleur.
     */
    @Override
    public String getNom() {
        return "\033[92mSoin de Zone\033[0m";
    }

    /**
     * Cette méthode retourne le nom comparable du pouvoir Soin de Zone.
     *
     * @return Le nom comparable du pouvoir Soin de Zone.
     */
    @Override
    public String getNomComparable() {
        return "Soin de Zone";
    }

    /**
     * Réinitialise l'état d'utilisation du pouvoir pour ce tour.
     */
    @Override
    public void UtilisableCeTour(){
        this.m_UtiliseCeTour = false;
    }

    /**
     * Cette méthode indique si le pouvoir Soin de Zone est utilisable.
     *
     * @return true si le pouvoir Soin de Zone est utilisable, sinon false.
     */
    @Override
    public boolean utilisable() {
        if(!this.m_UtiliseCeTour){
            return true;
        }
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Soin de Zone cible.
     *
     * @return false car le pouvoir Soin de Zone ne cible pas un Pokémon spécifique.
     */
    @Override
    public boolean cible() {
        return false;
    }

    /**
     * Cette méthode indique si le pouvoir Soin de Zone cible l'adversaire.
     *
     * @return false car le pouvoir Soin de Zone ne cible pas un adversaire.
     */
    @Override
    public boolean cibleAdversaire() {
        return false;
    }

    /**
     * Cette méthode est appelée lors de l'utilisation du pouvoir Soin de Zone. Elle soigne tous les Pokémon du côté du lanceur.
     *
     * @param lanceur Le Pokémon qui utilise le pouvoir Soin de Zone.
     * @param cible Le Pokémon sur lequel le pouvoir Soin de Zone est utilisé (non utilisé ici).
     * @param terrain Le terrain sur lequel le combat a lieu.
     */
    @Override
    public void onUse(Pokemon lanceur, Pokemon cible, Terrain terrain){
        if (terrain.IAContient(lanceur.getNomComparable())){
            for (Pokemon p: terrain.getPokemonIA()) {
                if (p.getPv()+10 <= cible.getPvMAX()){
                    p.setPv(p.getPv() + 10, terrain);
                }else {
                    p.setPv(p.getPvMAX(), terrain);
                }
            }
        }else if(terrain.joueurContient(lanceur.getNomComparable())){
            for (Pokemon p: terrain.getPokemonJoueur()) {
                if (p.getPv()+10 <= cible.getPvMAX()){
                    p.setPv(p.getPv() + 10, terrain);
                }else {
                    p.setPv(p.getPvMAX(), terrain);
                }
            }
        }
        new Affichage().utilisationPouvoir(this.getNomComparable(),lanceur, cible);
        this.m_UtiliseCeTour = true;
    }
}
