package Pookemon.Deroulement;

import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

import java.util.List;

public class Affichage {

    public void affichageMain(Main main) {
        int numMain=1;
        System.out.println("En main :");
        System.out.println("/----------------------------------------------------\\");
        for (Pokemon p: main.getMain()) {
            System.out.print("|"+numMain+": ");
            affichagePokemon(p);
            numMain++;
        }
        System.out.println("\\----------------------------------------------------/");
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
        if (pokemon.isM_shiny()){
            System.out.println(String.format("\u001B[93m%-13s\u001B[0m: %-10s PV : %-3s/%-3s DMG : %-3s |", pokemon.getNomComparable(), pokemon.getType(), pokemon.getPv(), pokemon.getPvMAX(), pokemon.getAttaque()));
        }else {
            System.out.println(String.format("%-13s: %-10s PV : %-3s/%-3s DMG : %-3s |", pokemon.getNomComparable(), pokemon.getType(), pokemon.getPv(), pokemon.getPvMAX(), pokemon.getAttaque()));
        }
    }

    public void demandeAjout(int nombre){
        System.out.println("Quel est le numéro du Pokemon que vous souhaitez placer sur le terrain ? ("+nombre+" restants)");
    }

    public void demandeCibleAdverse(Terrain terrain){
        System.out.println("Quel est le numéro du pokemon adersaire que vous souhaitez ciblez ?");
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

    public void questionAction(int etape){
        switch (etape){
            case 1:
                System.out.println("Que souhaitez vous faire ? \n   1: Fin du tour : [fin]");
                break;
            case 2:
                System.out.println("   2: Attaquer [atk]");
                break;
            default:
                break;
        }
    }

    public void questionAction(int etape, Terrain terrain){
        switch (etape){
            case 3:
                System.out.println("Entrez le numéro du Pokemon que vous souhaitez utilisez?");
                if (terrain.getPokemonJoueur().get(0).isPossedeAttaque()) {
                    System.out.println("   1: " + terrain.getPokemonJoueur().get(0).getNom());
                }
                if (terrain.getPokemonJoueur().get(1).isPossedeAttaque()) {
                    System.out.println("   2: " + terrain.getPokemonJoueur().get(1).getNom());
                }
                if (terrain.getPokemonJoueur().get(2).isPossedeAttaque()) {
                    System.out.println("   3: " + terrain.getPokemonJoueur().get(2).getNom());
                }
                break;
            default:
                break;
        }
    }

    public void attaqueIA(Pokemon attaquant, Pokemon cible){
        System.out.println("Le " +attaquant.getNom()+" adverse attaque " + cible.getNom());

        if (cible.estMort()) {
            System.out.println(cible.getNom() + "a été mis KO.");
        }
    }
}
