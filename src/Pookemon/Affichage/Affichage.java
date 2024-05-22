package Pookemon.Affichage;

import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

import java.util.List;

public class Affichage {

    public void affichageMain(Main main) {
        int numMain=1;
        System.out.println("En main :");
        for (Pokemon p: main.getMain()) {
            System.out.print("\t"+numMain+"|");
            affichagePokemon(p);
            numMain++;
        }
    }

    public void affichageTerrain(Terrain terrain) {
        System.out.println("Camp adverse : ");
        affichagePokemonCombat(terrain.getPokemonIA());
        System.out.println("Vos pokémon en jeu : ");
        affichagePokemonCombat(terrain.getPokemonJoueur());
    }

    public void terrainJoueur(Terrain terrain) {
        System.out.println("Vos pokémon en jeu : ");
        affichagePokemonCombat(terrain.getPokemonJoueur());
    }

    public void terrainAdverse(Terrain terrain) {
        System.out.println("Camp adverse : ");
        affichagePokemonCombat(terrain.getPokemonIA());
    }

    public void affichagePokemon(Pokemon pokemon) {
        System.out.println(pokemon.getNom() + ": " + pokemon.getType() + ", PV : " + pokemon.getPv() + "/" + pokemon.getPvMAX() + ", DMG: " + pokemon.getAttaque());
    }

    public void demandeAjout(int nombre){
        System.out.println("Quel pokemon souhaitez vous Placer sur le terrain ? ("+nombre+" restants)");
    }

    public void demandeCibleAdverse(Terrain terrain){
        System.out.println("Quelle pokemon adersaire souhaitez vous ciblez ?");
        int choix=1;
        for (Pokemon p : terrain.getPokemonIA()) {
            System.out.println( choix+": " + p.getNom());
            choix++;
        }
    }
    /**
     * Retourne une représentation textuelle des Pokémon combattants sous forme de chaîne de caractères.
     * Chaque ligne représente un attribut des Pokémon (nom, type, PV, DMG) aligné avec les autres combattants.
     *
     * @param combattants La liste des Pokémon combattants.
     * @return Une chaîne de caractères représentant les Pokémon combattants.
     */

    public void affichagePokemonCombat(List<Pokemon> combattants) {

        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m");
                System.out.print(String.format("\t/-*-*-*-*-*-*-*-*-*-*-\\\t"));
                System.out.print("\u001B[0m");
            }else {
                System.out.print("\t+---------------------+\t");
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\t%-27s\u001B[93m|\t", p.getNom()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\t%-18s|\t", p.getNom()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if (p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tTYPE : %-11s|\t", p.getType()));
                System.out.print("\u001B[0m");
            } else {
                System.out.print(String.format("\t|\tTYPE : %-11s|\t", p.getType()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tPV : %-3s/%-9s|\t", p.getPv(), p.getPvMAX()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tPV : %-3s/%-9s|\t", p.getPv(), p.getPvMAX()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tDMG : %-12s|\t", p.getAttaque()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tDMG : %-12s|\t", p.getAttaque()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t\\-*-*-*-*-*-*-*-*-*-*-/\t"));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t+---------------------+\t"));
            }
        }
        System.out.println();
    }
}
