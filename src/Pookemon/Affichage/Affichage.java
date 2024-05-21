package Pookemon.Affichage;

import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

import java.util.List;

public class Affichage {

    public void affichageMain(Main main) {
        int numMain=1;
        String enMain ="En main :";
        for (Pokemon p: main.getMain()) {
            enMain+= "\n   "+numMain+": " + p.toString();
            numMain++;
        }
        System.out.println(enMain);
    }

    public void affichageTerrain(Terrain terrain) {
        String retour = "";
        System.out.println("Camp adverse : ");
        affichagePokemonCombat(terrain.getPokemonIA());
        System.out.println("\nVos pokémon en jeu : ");
        affichagePokemonCombat(terrain.getPokemonJoueur());
        System.out.println(retour);
    }

    public void affichagePokemon(Pokemon pokemon) {
        System.out.println(pokemon.getNom() + ": " + pokemon.getType() + ", PV : " + pokemon.getPv() + "/" + pokemon.getPvMAX() + ", DMG: " + pokemon.getAttaque());
    }

    /**
     * Retourne une représentation textuelle des Pokémon combattants sous forme de chaîne de caractères.
     * Chaque ligne représente un attribut des Pokémon (nom, type, PV, DMG) aligné avec les autres combattants.
     *
     * @param combattants La liste des Pokémon combattants.
     * @return Une chaîne de caractères représentant les Pokémon combattants.
     */

    public void affichagePokemonCombat(List<Pokemon> combattants) {
        String retour="";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m";
                retour += String.format("\t/-*-*-*-*-*-*-*-*-*-*-\\\t", p.getNom());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t+---------------------+\t", p.getNom());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\t%-27s\u001B[93m|\t", p.getNom());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t|\t%-18s|\t", p.getNom());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if (p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\tTYPE : %-11s|\t", p.getType());
                retour += "\u001B[0m";
            } else {
                retour += String.format("\t|\tTYPE : %-11s|\t", p.getType());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\tPV : %-3s/%-9s|\t", p.getPv(), p.getPvMAX());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t|\tPV : %-3s/%-9s|\t", p.getPv(), p.getPvMAX());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\tDMG : %-12s|\t", p.getAttaque());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t|\tDMG : %-12s|\t", p.getAttaque());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t\\-*-*-*-*-*-*-*-*-*-*-/\t", p.getNom());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t+---------------------+\t", p.getNom());
            }
        }

        System.out.println(retour+"\n");
    }
}
