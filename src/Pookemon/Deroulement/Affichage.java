package Pookemon.Deroulement;

import Pookemon.Carte.Main;
import Pookemon.Carte.Terrain;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.DetailPokemon.Pouvoirs.*;

import java.util.List;
import java.util.Scanner;

public class Affichage {

    public void StartingGame(){
        System.out.println(String.format(
                "                                                                                  ██████╗ ██████╗ ███████╗███████╗███████╗   \n" +
                "                                                                                  ██╔══██╗██╔══██╗██╔════╝██╔════╝██╔════╝   \n" +
                "                                                                                  ██████╔╝██████╔╝█████╗  ███████╗███████╗   \n" +
                "                                                                                  ██╔═══╝ ██╔══██╗██╔══╝  ╚════██║╚════██║   \n" +
                "                                                                                  ██║     ██║  ██║███████╗███████║███████║   \n" +
                "                                                                                  ╚═╝     ╚═╝  ╚═╝╚══════╝╚══════╝╚══════╝   \n\n" +
                "                                                                                 ███████╗███╗   ██╗████████╗███████╗██████╗ \n" +
                "                                                                                 ██╔════╝████╗  ██║╚══██╔══╝██╔════╝██╔══██╗\n" +
                "                                                                                 █████╗  ██╔██╗ ██║   ██║   █████╗  ██████╔╝\n" +
                "                                                                                 ██╔══╝  ██║╚██╗██║   ██║   ██╔══╝  ██╔══██╗\n" +
                "                                                                                 ███████╗██║ ╚████║   ██║   ███████╗██║  ██║\n" +
                "                                                                                 ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝╚═╝  ╚═╝\n\n" +
                "                                                                                          ⠀    ⠀⠀⠀⠀⠀⠀⠀\033[92m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
                "\033[31m⠀⠀⠀                                                     ⠀⠀⠀⠀⠀⢀⣠⣤⣶⣶⣿⣿⣿⣿⣿⣶⣶⣤⣄⡀⠀⠀⠀⠀⠀\033[92m⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠉⢳⠴⢲⠂⠀⠀⠀⠀⠀\n" +
                "\033[31m⠀⠀                                                     ⠀⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀\033[92m⠀⠀⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⠤⠤⠤⠤⠤⠤⠤⠤⠤⠖⠊⠀⣠⠎⠀⡞⢹⠏⠀⠀⠀⠀\n" +
                "\033[31m⠀                                                     ⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀  \033[92m  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡴⠊⠁⠀⠀⠀⠀⠀⢀⡠⠤⠄⠀⠀⠀⠁⠀⠀⢀⠀⢸⠀⠀⠀⠀⠀\n" +
                "\033[31m⠀                                                     ⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠙⣿⣿⣿⣿⣿⣆⠀⠀\033[94m⠀    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠤⠤⠄⣀⠀⠀⠀\033[92m⠀⢀⣌⠀\033[94m⠀⠀⠀⠀⢀⣠⣆\033[32m⡁⠀⠀⠀\033[92m⠀⠀⠀⠀⠀⠀⠀⡀⠘⡄⠀⠀⠀⠀\n" +
                "\033[31m⠀                                                     ⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⢿⣧⡀⠀⢠⣿⠟⠛⠛⠿⣿⡆⠀\033[94m⠀  ⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⡴⠁⠀⠀⠐⠛⠉⠁⠀⠀⣉⠉⠉⠉⠑⠒⠉⠁⠀⠀⢸⡀⠀⠀\033[92m⠀⠀⠀⠀⠀⠀⠀⢧⠀⠱⡀⠀⠀⠀\n" +
                "\033[31m                                                     ⠀⢰⣿⣿⣿⣿⣿⣿⠿⠟⠋⠉⠁⠀⠀⠀⠀⠀⠙⠿⠿⠟⠋⠀⠀⠀⣠⣿⠇⠀ \033[94m   ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣥⠆⠀⠀⠀\033[94m⣠⣴⣶⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⢇⠀\033[92m⠀⠀⠀⠀⠀⠀⠀⠀⠈⡆⠀⠑⡄⠀⠀\n" +
                "\033[31m⠀                                                     ⢸⣿⣿⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⠟⠋⠀⠀ \033[94m  ⠀⠀⠀⠀⠀ ⠀⠀⠀⢀⡜⠁⠀⠀⢀\033[94m⠀⠻⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡀⠀\033[92m⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠸⡀⠀\n" +
                "\033[31m⠀                                                     ⢸⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣴⣾⠿⠛⠉⠀⠀⠀⠀⠀ \033[94m  ⠀⠀⠀⠀⠀ ⠀⠀⢀⣮⢖\033[31m⣧⢠⠀\033[94m⣿⠇⠀⠀⠁⠀⠀⠀⠠⠀⢀⣠\033[31m⣴⣤⡀⠀\033[94m⠀⠀⠈⡗⢄⠀⠀\033[92m⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⢱⠀\n" +
                "\033[31m⠀                                                     ⠈⢿⣷⣤⣤⣄⣠⣤⣤⣤⣤⣶⣶⣾⠿⠿⠛⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\033[94m   ⠀⠀⠀⠀⠀ ⠀⠀⣼⠃\033[31m⣼\033[0m⣿\033[31m⠘⠀⠀\033[94m⠀⢠⣶⣿⡆⠀⠀⠁⣠⠊\033[31m⣸⣿\033[0m⣿⣿\033[31m⡄⠀⠀\033[94m⠀⡇⠀⢑⣄⠀⠀\033[92m⠀⠀⠀⠀⢠⠃⠀⠀⠸⡆\n" +
                "⠀\033[0m                                                     ⢠⣾\033[37m⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣦⣤⣀⠀⠀⠀⠀⠀\033[94m⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⣿\033[31m⢰⣿⣿⠀⠀⠀⠀\033[94m⠙⠻⠿⠁⠀\033[94m⠀⠠⠁⠀\033[31m⣿⣿⣿\033[0m⣿\033[31m⡇⠀\033[94m⠀⠀⠇⠀⢻⣿⣷⣦⣀\033[32m⡀⣀⠠⠋⠀⠀⠀⢀⡇\n" +
                "⠀\033[0m                                                     ⢸⣿\033[37m⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣄⠀⠀⠀\033[94m  ⠀⠀⠀⠀⠀  ⠀⠀⠈⠉\033[31m⠺⠿⠏⠀⠀⠀\033[94m⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀\033[31m⢿⣿⣿⣿⠇⠀\033[94m⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⢦⡀\033[32m⠀⠀⠀⠀⡸⠀\n" +
                "⠀\033[0m                                                     ⢸⣿\033[37m⡛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀ \033[94m   ⠀⠀⠀⠀⠀⠀⠀⠘⣟⠦⢀⠀⠀⢠⠀⠀⡠⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠁⣀⠔⠀⠀⠀⠀⠀⠀⠀⠛⠻⠟⠋⠀⠙⢦\033[32m⠀⣠⠜⠀⠀\n" +
                "\033[0m⠀                                                     ⠀⢻⣧⠀\033[37m⠈⠙⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀ \033[94m   ⠀⠀⠀⠀⠀⠀⠀⠈⠑⠤\033[31m⠙\033[0m⠳\033[31m⣶⣦⣤⣤⣤⣤⣤⣤⣤⣤⣴⣶⡶\033[0m⠞\033[31m⠁\033[94m⠀⠀⣠⠖⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠈⢯⠁⠀⠀⠀\n" +
                "\033[0m⠀                                                     ⠀⠈⢿⣧⠀⠀⠀⠀⠀⠀\033[37m⠉⠙⠛⠻⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀    \033[94m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢳⠤\033[31m⠙⠻⠿⣿⣿⣿⣿⡿⠿⠛⠉⠀\033[94m⢀⣀⡤⡚⠁⠀⠀⠀⠀⠀⠀⣧⠖⣁⣤⣦⠀⠀⠈⢇⠀⠀⠀\n" +
                "\033[0m⠀⠀                                                     ⠀⠀⠻⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\033[37m⠹⣿⣿⣿⣿⠟\033[0m⠀⣠⣾⠟⠀⠀\033[94m⠀ ⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⠀⢸⠉⠉⣩⣍⠓⠒⣒⠒⠒⠒⠒⠊⠉⠁⢀⡟⠀⠀⣾⣷⠀⠀⠀⠀⠏⢴⣿⣿⣿⠀⠀⠀⢸⠀⠀⠀\n" +
                "\033[0m⠀⠀                                                     ⠀⠀⠀⠈⠻⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀\033[37m⠉⠉\033[0m⢀⣤⣾⠟⠁⠀⠀⠀\033[94m⠀ ⠀⠀⠀⠀⠀   ⠀⠀⠀⠀⠀⠀⠘⣶⣿⣿⣿⠀⠀⠈⠒⢄⣀⡀⠀⠀⠀⣼⣶⣿⡇⠈⠋⠀⠀⠀⡼⠀⠈⠻⣿⡿⠀⠀⠀⢸⠀⠀⠀\n" +
                "\033[0m⠀⠀⠀                                                     ⠀⠀⠀⠀⠀⠙⠻⠿⣶⣦⣤⣤⣤⣤⣤⣤⣶⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀    ⠀\033[94m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡿⠿⠋⠀⠀⠀⠀⡜⠁⠈⢯⡀⢺⣿⣿⣿⠃⠀⠀⠀⢀⣼⣇⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀\n" +
                "\033[0m⠀⠀⠀⠀                                                     ⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  \033[94m  ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣦⣄⣠⣀⣠⠞⠀⠀⠀⠈⠛⣿⡛⠛⠁⠀⠀⠀⣠⠊⠀⠈⢦⣄⣀⣀⣀⣀⢀⡼⠁⠀⠀⠀\n"+
                "                                                                                          ⠀    ⠀⠀\033[94m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠛⠉⠀⠀⠀⠀⠀⠀⠘⠛⠿⣿⠷⡾⠗⠊⠁⠀⠀⠀⠈⠉⠙⠛⠛⠛⠉⠀⠀⠀⠀⠀\033[0m\n"));

    }

    public void tuto(){
        System.out.println("\033[51m Bienvenue dans le projet pookemon, un simulateur de combat pokemon en tour par tour ! \033[0m\n\n" +
                "Votre objectif est de battre votre adversaire, pour ce faire vous devez réduire le nombre de Pokemon de votre adversaire à 0. Pour cela, vous disposez de Pokemon, chacun d'eux possédant des points de vie (PV)\net des dégats (DMG) ainsi qu'un type.\n" +
                "Ces derniers peuvent attaquer une fois par tour, infligeant ses DMG au PV du pokemon adverse ciblé, si un pokemon atteint 0 PV, il meurt. \n" +
                "Si le type de votre pokemon est puissant face a celui de votre adversaire, cela infligera 10 PV de plus en DMG, si au contraire le Pokemon adverse est résitant, il subira 10 DMG de moins.\n\n" +
                "\033[4;37mCertains Pokemons possèdent des pouvoirs ! Si c'est le cas, il peuvent utiliser leur pouvoir en plus de leur attaque, voici la liste des pouvoirs disponible :\033[0m \n\t" +
                new Berserk().getNom() +" : Utilisable 1 fois, cela double les DMG d'un Pokemon durant 1 tour.\n\t"+
                new Empoisonnement().getNom() + " : Utilisable 1 fois par tour, pour un total de 3 fois, cela empoisonne un ennemie, lui faisant perdre 10 PV à chaque début de son tour.\n\t"+
                new FerveurGuerriere().getNom() +" : Utilisable 1 fois, cela ajoute 10 DMG a un Pokemon de manière permanente.\n\t"+
                new Kamikaze().getNom() +" : Utilisable 1 fois, votre Pokemon se sacrifie dans une explosion spectaculaire, emportant dans sa tombe le Pokemon adverse de votre choix.\n\t"+
                new Peur().getNom() +" : Utilisable 1 fois, cela retire 10 DMG a un Pokemon de manière permanente.\n\t"+
                new SoinSimple().getNom() +" : Utilisable chaque tour, soigne 30 PV a un Pokemon.\n\t"+
                new SoinTotal().getNom() +" : Utilisable 1 fois soigne totalement un Pokemon.\n\t"+
                new SoinDeZone().getNom() + " : Utilisable chaque tour, soigne 10 PV a tout vos Pokemon sur le terrain.\n\t"+
                "Vous pouez affichez cette aide a tout moment durant votre tour en tapant help\n\t");
    }
    public void tourJoueur(String premierJoueur){
        if (premierJoueur.equals("Joueur")){
            System.out.println("Vous commencerez la partie ! Choisissez vos pokemon a mettre sur le terrain");

        }else{
            System.out.println("Vous jouerez en second.");
        }
    }
    public void affichageMain(Main main) {
        int numMain=1;
        System.out.println("En main :");
        System.out.println("/-----------------------------------------------------------------------------------\\");
        for (Pokemon p: main.getMain()) {
            System.out.print("|"+numMain+": ");
            affichagePokemon(p);
            numMain++;
        }
        System.out.println("\\-----------------------------------------------------------------------------------/");
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
        if (pokemon.isShiny()){
            System.out.print(String.format("\u001B[93m%-13s\u001B[0m: %-10s PV : %-3s/%-3s DMG : %-3s ", pokemon.getNomComparable(), pokemon.getType(), pokemon.getPv(), pokemon.getPvMAX(), pokemon.getAttaque()));
        }else {
            System.out.print(String.format("%-13s: %-10s PV : %-3s/%-3s DMG : %-3s ", pokemon.getNomComparable(), pokemon.getType(), pokemon.getPv(), pokemon.getPvMAX(), pokemon.getAttaque()));
        }
        if (pokemon.getPouvoir()!=null){
            System.out.print(String.format("Pouvoir : %-30s", pokemon.getPouvoir().getNom()));
        }else{
            System.out.print(String.format("Pouvoir : %-21s", "Aucun"));
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
            if(p.isShiny()) {
                System.out.print("\u001B[93m");
                System.out.print(String.format("\t/-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\\\t"));
                System.out.print("\u001B[0m");
            }else {
                System.out.print("\t+----------------------------------+\t");
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isShiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\t%-40s\u001B[93m|\t", p.getNom()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\t%-31s|\t", p.getNom()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if (p.isShiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tTYPE : %-24s|\t", p.getType()));
                System.out.print("\u001B[0m");
            } else {
                System.out.print(String.format("\t|\tTYPE : %-24s|\t", p.getType()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isShiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tPV : %-3s/%-22s|\t", p.getPv(), p.getPvMAX()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tPV : %-3s/%-22s|\t", p.getPv(), p.getPvMAX()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isShiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tDMG : %-25s|\t", p.getAttaque()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tDMG : %-25s|\t", p.getAttaque()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isShiny()) {
                System.out.print("\u001B[93m ");
                if (p.getPouvoir()!=null) {
                    System.out.print(String.format("\t|\tPouvoir : %-30s\u001B[93m|\t", p.getPouvoir().getNom()));
                }else {
                    System.out.print(String.format("\t|\tPouvoir : %-21s|\t", "Aucun"));

                }
                System.out.print("\u001B[0m");
            }else {
                if (p.getPouvoir()!=null) {
                    System.out.print(String.format("\t|\tPouvoir : %-30s|\t", p.getPouvoir().getNom()));
                }else {
                    System.out.print(String.format("\t|\tPouvoir : %-21s|\t", "Aucun"));

                }
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isShiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t|\tStatut : %-22s|\t", p.getStatut().name().substring(0,1)+ p.getStatut().name().substring(1).toLowerCase()));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t|\tStatut : %-22s|\t", p.getStatut().name().substring(0,1)+ p.getStatut().name().substring(1).toLowerCase()));
            }
        }
        System.out.println();
        for (Pokemon p: combattants) {
            if(p.isShiny()) {
                System.out.print("\u001B[93m ");
                System.out.print(String.format("\t\\-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/\t"));
                System.out.print("\u001B[0m");
            }else {
                System.out.print(String.format("\t+----------------------------------+\t"));
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
                if (terrain.getPokemonJoueur().size()>0&&terrain.getPokemonJoueur().get(0).getPouvoir()!= null && terrain.getPokemonJoueur().get(0).getPouvoir().utilisable()) {
                    System.out.println("   1: " + terrain.getPokemonJoueur().get(0).getNom()+ " : " + terrain.getPokemonJoueur().get(0).getPouvoir().getNom());
                }
                if (terrain.getPokemonJoueur().size()>1&&terrain.getPokemonJoueur().get(1).getPouvoir()!= null && terrain.getPokemonJoueur().get(1).getPouvoir().utilisable()) {
                    System.out.println("   2: " + terrain.getPokemonJoueur().get(1).getNom()+ " : " + terrain.getPokemonJoueur().get(1).getPouvoir().getNom());
                }
                if (terrain.getPokemonJoueur().size()>2&&terrain.getPokemonJoueur().get(2).getPouvoir()!= null && terrain.getPokemonJoueur().get(2).getPouvoir().utilisable()) {
                    System.out.println("   3: " + terrain.getPokemonJoueur().get(2).getNom() + " : " + terrain.getPokemonJoueur().get(2).getPouvoir().getNom());
                }
                break;
            default:
                break;
        }
    }

    public void utilisationPouvoir(String pouvoir, Pokemon utilisateur, Pokemon cible){
        switch (pouvoir){
            case "Berserk":
                System.out.println(utilisateur.getNom()+ " double l'attaque de " + cible.getNom() + " jusqu'à la fin du tour !");
                break;
            case "Empoisonnement":
                System.out.println(utilisateur.getNom()+ " empoisonne " + cible.getNom() + " !");
                break;
            case "Ferveur Guerrière":
                System.out.println(utilisateur.getNom()+ " augmente définitevement l'attaque de " + cible.getNom() + " de 10 points !");
                break;
            case "Kamikaze":
                System.out.println(utilisateur.getNom()+ " EXPLOSE !!!!! Il emporte avec lui " + cible.getNom() + " !");
                break;
            case "Peur":
                System.out.println(utilisateur.getNom()+ " effraye " + cible.getNom() + ", baissant son attaque de 10 points de manière définitive !");
                break;
            case "Soin de Zone":
                System.out.println(utilisateur.getNom()+ " soigne ses alliés sur le terrain de 10 PV !");
                break;
            case "Soin Simple":
                System.out.println(utilisateur.getNom()+ " soigne " + cible.getNom() + " de 30 PV !");
                break;
            case "Soin Total":
                System.out.println(utilisateur.getNom()+ " soigne totalement " + cible.getNom() + " !");
                break;
        }
        new Scanner(System.in).nextLine();
    }
    public void attaqueIA(Pokemon attaquant, Pokemon cible){
        System.out.println("Le " +attaquant.getNom()+" adverse attaque " + cible.getNom());

        if (cible.estMort()) {
            System.out.println(cible.getNom() + "a été mis KO.");
        }
    }


    public void finJeu(boolean Victoire){
        if(Victoire){
            System.out.println(
                                    "\n                                                                               \033[93m██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗\n" +
                                    "                                                                               ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║\n" +
                                    "                                                                                ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║\n" +
                                    "                                                                                 ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║\n" +
                                    "                                                                                  ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║\n" +
                                    "                                                                                  ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝\n\n" +
                                    "                                                                                 ⠀⠀\033[30m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀\033[30m⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀⠀\033[30m⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀⠀\033[30m⠀⠀⠀⠀⠀⠀⠀⡾⠋⠉\033[93m⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀⠀\033[30m⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀\033[93m⠀⡇\033[91m⠀⠀⠀⠀⠀⠀⣠⠖⠲⢤⡖⠒⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀⠀\033[30m⠀⠀⠀⠀⠀⢀⡏⠀⠀⠀\033[93m⠀⡇\033[91m⠀⠀⠀⠀⠀⠀⡏⠀⠀⠀⠀⠀⢀⡇\033[93m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 \033[91m⠀⠀⠀⠀⢀⣀⠀\033[93m⠀⢸⠀⠀⠀⠀⠀⡇\033[91m⠀⠀⠀⠀⠀⠀⠸⣄⠀⠁⣠⠞⠉\033[93m⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀\033[30m⣀⣠⣤⣤⣤⣤⠀⠀\n" +
                                    "                                                                                 \033[91m⠀⡞⠉⠻⠁⢹⠀\033[93m⠀⡏⠀⠀⠀⠀⢸⠃⠀⠀⠀⠀⠀⠀\033[91m⠀⠀⠹⣶⠋\033[93m⠀⠀⠀⠀⣀⡤⠴⠒⠊⠉⠉⠀⠀\033[30m⣿⣿⣿⠿⠋⠀⠀\n" +
                                    "                                                                                 \033[91m⠀⠳⢤⡀⠀⡞⠁\033[93m⠀⡇⠀⠀⢀⡠⠼⠴⠒⠒⠒⠒⠦⠤⠤⣄⣀⠀⢀⣠⠴⠚⠉⠀⠀⠀⠀\033[30m⠀⠀⠀⠀⣼⠿⠋⠁⠀⠀⠀⠀\n" +
                                    "                                                                                 \033[91m⠀⠀⠀⠈⠷⡏⠀\033[93m⠀⣇⠔⠂⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀                                                                                 \033[93m⠀⠀⠀⠀⢰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⠤⠒⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 \033[93m⠀⠀⠀⠀⠀⠀⢀⡟\033[30m⠀⣠⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀\033[93m    ⠀⠀⠈⠉⢻⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⡤⠤⢴\n" +
                                    "                                                                                 \033[93m⠀⠀⠀⠀⠀⠀⣸⠁\033[30m⣾⣿\033[0m⣿\033[30m⣿⡆⠀⠀ ⠀⠀⠀⠀⢠⣾\033[0m⣿\033[30m⣿⣦\033[93m⠀⠀⠀\033[93m⢸⡀⠀⠀⢀⣠⠤⠔⠒⠋⠉⠉⠀⠀⠀⠀⢀⡞\n" +
                                    "                                                                                 ⠀\033[93m⠀⠀⠀⠀⢀⡏⠀\033[30m⠹⠿⠿⠟⠁⠀⠰⠦⠀⠀⠀⠀⠸⣿⣿⣿⡿⠀⠀\033[93m⠀⢘⡧⠖⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠀\n" +
                                    "                                                                                 ⠀\033[91m⠀⠀⠀⠀⣼⠦⣄⠀⠀\033[30m⢠⣀⣀⣴⠟⠶⣄⡀⠀⠀⡀⠀⠉⠁⠀⠀⠀⠀\033[93m⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠁⠀\n" +
                                    "                                                                                 ⠀⠀⠀\033[91m⠀⢰⡇⠀⠈⡇⠀\033[30m⠀⠸⡾⠁⠀⠀⠀⠉⠉⡏⠀⠀\033[91m⠀⣠⠖⠉⠓⢤\033[93m⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠃⠀⠀\n" +
                                    "                                                                                 ⠀⠀⠀\033[91m⠀⠀⢧⣀⡼⠃⠀\033[30m⠀⠀⢧⠀⠀⠀⠀⠀⢸⠃⠀\033[91m⠀⠀⣧⠀⠀⠀⣸\033[93m⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠃⠀⠀⠀\n" +
                                    "                                                                                 ⠀\033[93m⠀⠀⠀⠀⠈⢧⡀⠀⠀\033[30m⠀⠀⠘⣆⠀⠀⠀⢠⠏⠀⠀⠀\033[91m⠀⠈⠳⠤⠖⠃\033[93m⡟⠀⠀⠀⢾⠛⠛⠛⠛⠛⠛⠛⠛⠁⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀\033[93m⠀⠀⠀⠀⠀⠀⠙⣆⠀\033[30m⠀⠀⠀⠈⠦⣀⡴⠋⠀⠀⠀⠀⠀\033[93m⠀⠀⠀⢀⣼⠙⢦⠀⠀⠘⡇⠀⠀\033[91m⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀\033[93m\n" +
                                    "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⢠⡇⠙⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⠋⠸⡇⠈⢳⡀⠀⢹⡀\033[91m⠀⠀⠀⢀⡞⠁⠉⣇⣀⠀⠀\033[93m\n" +
                                    "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⡼⣀⠀⠀⠈⠙⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⣷⠴⠚⠁⠀⣀⣷\033[91m⠀⠀⠀⢠⠇⠀⠀⠀⠀⠀⣳\033[93m\n" +
                                    "                                                                                 ⠀⠀⠀⠀⠀⠀⡴⠁⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⡴⠚⠉⠉⠀\033[91m⠀⠀⠀⢸⠃⣀⣠⠤⠤⠖⠋\033[93m\n" +
                                    "                                                                                 ⣼⢷⡆⠀⣠⡴⠧⣄⣇⠀⠀\033[91m⠀⠀⡴⠚⠙⠲⠞⠛⠙⡆⠀\033[93m⠀⠀⠀⠀⢀⡇⣠⣽⢦⣄⢀⣴⣶⠀\033[91m⠋⠉⠀⠀⠀\033[93m⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⡿⣼⣽⡞⠁⠀⠀⠀⢹⡀⠀\033[91m⠀⠀⢹⠀⠀⠀⠀⠀⠀⣸⠀⠀\033[93m⠀⠀⠀⣼⠉⠁⠀⠀⢠⢟⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⣷⠉⠁⢳⠀⠀⠀⠀⠈⣧\033[91m⠀⠀⠀⠀⠙⢦⠀⠀⠀⡠⠁⠀\033[93m⠀⠀⠀⣰⠃⠀⠀⠀⠀⠏⠀⠀⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠹⡆⠀⠈⡇⠀⠀⠀⠀⠘⣆⠀⠀⠀\033[91m⠀⠀⠹⣧⠞⠁\033[93m⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⠀⠀⠀⣸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⢳⡀⠀⠙⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⣰⠃⠀⠀⠀⠀⢀⡄⠀⢠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀⢳⡀⣰⣀⣀⣀⠀⠀⠀⠘⣦⣀⠀⠀⠀⡇⠀⠀⠀⢀⡴⠃⠀⠀⠀⠀⠀⢸⡇⢠⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "                                                                                 ⠀⠀⠀⠉⠉⠀⠀⠈⠉⠉⠉⠙⠻⠿⠾⠾⠻⠓⢦⠦⡶⡶⠿⠛⠛⠓⠒⠒⠚⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
            );
        }else {
            System.out.println(
                            "\033[107m\n\n                                                                         ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗      ██████╗ ███████╗███████╗\n" +
                            "                                                                         ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║     ██╔═══██╗██╔════╝██╔════╝\n" +
                            "                                                                          ╚████╔╝ ██║   ██║██║   ██║    ██║     ██║   ██║███████╗█████╗  \n" +
                            "                                                                           ╚██╔╝  ██║   ██║██║   ██║    ██║     ██║   ██║╚════██║██╔══╝  \n" +
                            "                                                                            ██║   ╚██████╔╝╚██████╔╝    ███████╗╚██████╔╝███████║███████╗\n" +
                            "                                                                            ╚═╝    ╚═════╝  ╚═════╝     ╚══════╝ ╚═════╝ ╚══════╝╚══════╝\n\n\n" +
                            "                                                                                  \033[30m⠀⠀⠀⠀⠀⢀⣤⣶⡖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 \033[30m⠀⠀⠀⠀⣴⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 \033[33m    ⣸⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⣠⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣦\033[30m⣤⣀⠀⠀⠀\033[33m⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣾⣿⣿⣿⣿⣿\033[30m⣿⣿⣿⣦⡀⠀\033[33m⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⣽⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⠿\033[30m⠿⠿⠿⠿⠛⠀⠀⠀\033[33m⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⢰⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⢸⣿⣿⣿⣿⣿⣿⣷⡀⣀⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁\033[30m⣠⣶⣄\033[33m⢿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀⠹⣿⣿⣿⡟⠉⠉⠙⢿⣿⣿⣿⣿⣿⠀\033[30m⠹⣿⡟\033[33m⢸⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀⠀⢿⣿⣿⡀\033[30m⣾⣿⣄\033[33m⢸⣿⣿⣿⣿⣿⣷⣄⣀⣠⣿⡿⠉⠙⢿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀⠀⢸⣿⠿⣧⡀\033[30m⠙⠉\033[33m⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁\033[31m⣠⣄\033[33m⠘⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀ ⣼\033[31m⢰⣿\033[33m⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠿⠿⠋⡀\033[31m⠹⡟\033[33m⢰⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀⠀⠹\033[31m⠙⡟\033[33m⢀⣄⡈⠙⠻⠟⢁⣠⣈⠙⢁⣠⣶⣤⣾⣿⣦⣴⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀⠀⠈⢷⣤⣾⣿⣿⣷⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀\033[30m⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣶⣿⣿⣷⠀\033[33m\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀\033[30m⠀⠀⠀⠀⠀⣀⣤⣾⣿⣿⣿⣿⣿⣿⣿⡇\033[33m\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀\033[30m⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇\033[33m\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀\033[30m⠀⣿⣿⣿⣿⣿⣿⠿⠟⠛⠛⠉⠉\033[33m⠀\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⠿⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⣧⠀\033[30m⢀⣴⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀⠀\033[33m⠀\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⠀⣿⣿⡇⠈⣿⣿⣿⣿⣿⣿⣿⡀\033[30m⢾⣿⣿⠿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀\033[33m⠀\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣤⣿⣿⣷⣼⣿⣿⣿⣿⣿⣿⣿⡇\033[30m⢨⣿⣿⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\033[33m⠀\n" +
                            "                                                                                 ⠀⠀⠀⢀⣀⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠠⣾⣿⣿\033[30m⣿⣿\033[33m⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀\033[30m⠀⠀⠾⠿⠿\033[33m⣿⣿⣿\033[30m⣿⣿⣿\033[33m⣿⣿⣿⣿⣿\033[30m⣿⣿⣿\033[33m⣿⣿⣿⡟\033[30m⠻⠿⠿⠯\033[33m⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                 ⠀⠀⠀⠀⠀⠀⠉⠉⠀⠀\033[30m⠈⠉⠀\033[33m⠀⠙⠋⠁\033[30m⠈⠛⠋\033[33m⠈⠛⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\n"
            );
        }
    }
}
