package Pookemon.DetailPokemon.Pouvoirs;

import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;

public class SoinDeZone extends Pouvoir {
    private boolean m_UtiliseCeTour = false;

    @Override
    public String getNom() {
        return "\033[92mSoin de Zone\033[0m";
    }

    @Override
    public String getNomComparable() {
        return "Soin de Zone";
    }

    @Override
    public void UtilisableCeTour(){
        this.m_UtiliseCeTour = false;
    }

    @Override
    public boolean utilisable() {
        if(!this.m_UtiliseCeTour){
            return true;
        }
        return false;
    }

    @Override
    public boolean cible() {
        return false;
    }

    @Override
    public boolean cibleAdversaire() {
        return false;
    }

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
