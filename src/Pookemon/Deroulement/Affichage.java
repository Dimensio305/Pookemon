package Pookemon.Deroulement;

import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;

import java.util.List;

public class Affichage {

    public void affichageMain(Main main) {
        int numMain=1;
        System.out.println("En main :");
        System.out.println("/------------------------------------------------------------------------------\\");
        for (Pokemon p: main.getMain()) {
            System.out.print("|"+numMain+": ");
            affichagePokemon(p);
            numMain++;
        }
        System.out.println("\\------------------------------------------------------------------------------/");
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
            System.out.print(String.format("\u001B[93m%-13s\u001B[0m: %-10s PV : %-3s/%-3s DMG : %-3s ", pokemon.getNomComparable(), pokemon.getType(), pokemon.getPv(), pokemon.getPvMAX(), pokemon.getAttaque()));
        }else {
            System.out.print(String.format("%-13s: %-10s PV : %-3s/%-3s DMG : %-3s ", pokemon.getNomComparable(), pokemon.getType(), pokemon.getPv(), pokemon.getPvMAX(), pokemon.getAttaque()));
        }
        if (pokemon.getM_pouvoir()!=null){
            System.out.print(String.format("Pouvoir : %-16s", pokemon.getM_pouvoir().getNom()));
        }else{
            System.out.print(String.format("Pouvoir : %-16s", "Aucun"));
        }
        System.out.println("|");
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
    public void demandeCibleHumain(Terrain terrain){
        System.out.println("Quel est le numéro de votre pokemon que vous souhaitez ciblez ?");
        int choix=1;
        for (Pokemon p : terrain.getPokemonJoueur()) {
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
                System.out.print(String.format("\t/-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\\\t"));
                System.out.print("\u001B[0m");
            }else {
                System.out.print("\t+-----------------------------+\t");
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\t%-35s\u001B[93m|\t", p.getNom()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\t%-26s|\t", p.getNom()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if (p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tTYPE : %-19s|\t", p.getType()));
                System.out.print("\u001B[0m");
            } else {
                System.out.print(String.format("\t|\tTYPE : %-19s|\t", p.getType()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tPV : %-3s/%-17s|\t", p.getPv(), p.getPvMAX()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tPV : %-3s/%-17s|\t", p.getPv(), p.getPvMAX()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tDMG : %-20s|\t", p.getAttaque()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tDMG : %-20s|\t", p.getAttaque()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                if (p.getM_pouvoir()!=null) {
                    System.out.print(String.format("\t|\tPouvoir : %-16s|\t", p.getM_pouvoir().getNom()));
                }else {
                    System.out.print(String.format("\t|\tPouvoir : %-16s|\t", "Aucun"));

                }
                System.out.print("\u001B[0m");
            }else {
                if (p.getM_pouvoir()!=null) {
                    System.out.print(String.format("\t|\tPouvoir : %-16s|\t", p.getM_pouvoir().getNom()));
                }else {
                    System.out.print(String.format("\t|\tPouvoir : %-16s|\t", "Aucun"));

                }
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tStatut : %-17s|\t", p.getM_statut().name().substring(0,1)+ p.getM_statut().name().substring(1).toLowerCase()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tStatut : %-17s|\t", p.getM_statut().name().substring(0,1)+ p.getM_statut().name().substring(1).toLowerCase()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t\\-*-*-*-*-*-*-*-*-*-*-*-*-*-*-/\t"));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t+-----------------------------+\t"));
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
            case 3:
                System.out.println("   3: Pouvoir [pov]");
            default:
                break;
        }
    }

    public void questionAction(int etape, Terrain terrain){
        switch (etape){
            case 2:
                System.out.println("Entrez le numéro du Pokemon que vous souhaitez utilisez?");
                if (terrain.getPokemonJoueur().size()>0&&terrain.getPokemonJoueur().get(0).isPossedeAttaque()) {
                    System.out.println("   1: " + terrain.getPokemonJoueur().get(0).getNom());
                }
                if (terrain.getPokemonJoueur().size()>1&&terrain.getPokemonJoueur().get(1).isPossedeAttaque()) {
                    System.out.println("   2: " + terrain.getPokemonJoueur().get(1).getNom());
                }
                if (terrain.getPokemonJoueur().size()>2&&terrain.getPokemonJoueur().get(2).isPossedeAttaque()) {
                    System.out.println("   3: " + terrain.getPokemonJoueur().get(2).getNom());
                }
                break;
            case 3:
                System.out.println("Entrez le numéro du Pokemon que vous souhaitez utilisez?");
                if (terrain.getPokemonJoueur().size()>0&&terrain.getPokemonJoueur().get(0).getM_pouvoir()!= null && terrain.getPokemonJoueur().get(0).getM_pouvoir().utilisable()) {
                    System.out.println("   1: " + terrain.getPokemonJoueur().get(0).getNom()+ " : " + terrain.getPokemonJoueur().get(0).getM_pouvoir().getNom());
                }
                if (terrain.getPokemonJoueur().size()>1&&terrain.getPokemonJoueur().get(1).getM_pouvoir()!= null && terrain.getPokemonJoueur().get(1).getM_pouvoir().utilisable()) {
                    System.out.println("   2: " + terrain.getPokemonJoueur().get(1).getNom()+ " : " + terrain.getPokemonJoueur().get(1).getM_pouvoir().getNom());
                }
                if (terrain.getPokemonJoueur().size()>2&&terrain.getPokemonJoueur().get(2).getM_pouvoir()!= null && terrain.getPokemonJoueur().get(2).getM_pouvoir().utilisable()) {
                    System.out.println("   3: " + terrain.getPokemonJoueur().get(2).getNom() + " : " + terrain.getPokemonJoueur().get(2).getM_pouvoir().getNom());
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
