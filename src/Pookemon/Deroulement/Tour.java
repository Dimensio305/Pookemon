package Pookemon.Deroulement;

import Pookemon.Carte.*;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.Personnage.Humain;
import Pookemon.Personnage.IA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tour {
    private final Humain m_humain;
    private final IA m_IA;
    private static String joueurActif;
    private Terrain m_terrain;
    
    private static final Affichage m_affiche= new Affichage();

    /**
     * Constructeur de la classe Tour.
     * Initialise un tour de jeu avec les éléments nécessaires : main du joueur, deck du joueur, main de l'IA,
     * deck de l'IA, terrain et joueur actif.
     *
     * @param terrain    Le terrain de jeu.
     * @param actif      Le joueur actif ("Joueur" ou "IA").
     */
    public Tour(Humain humain, IA ia, Terrain terrain, String actif){
        m_humain = humain;
        m_IA = ia;
        m_terrain = terrain;
        joueurActif = actif;
    }
    public static void changementJoueur(){
        if(joueurActif.equals("IA")){
            joueurActif="Joueur";
        }else{joueurActif="IA";}
    }


    /**
     * Fait jouer la première phase du tour de jeu.
     * Si c'est au tour du joueur, effectue ses actions, sinon, effectue les actions de l'IA.
     * Affiche l'état actuel du jeu deux fois.
     */
    public void miseEnPlace(){
        if (joueurActif.equals("Joueur")) {
            while(this.m_terrain.getPokemonJoueur().size()<3){
                m_affiche.affichageMain(this.m_humain.getM_main());
                this.ajoutTerrain(3-this.m_terrain.getPokemonJoueur().size());
            }
            while(this.m_terrain.getPokemonIA().size()<3){
                this.m_terrain.ajoutPokemonIA(this.m_IA.getM_main());
            }
        }else {
            while(this.m_terrain.getPokemonIA().size()<3){
                this.m_terrain.ajoutPokemonIA(this.m_IA.getM_main());
            }
            m_affiche.terrainAdverse(this.m_terrain);
            System.out.println("Voici les pokémon choisis par votre adversaire.");
            new Scanner(System.in).nextLine();
            while(this.m_terrain.getPokemonJoueur().size()<3){
                m_affiche.affichageMain(this.m_humain.getM_main());
                this.ajoutTerrain(3-this.m_terrain.getPokemonJoueur().size());
            }
        }
        while (true) {
            deroulementTour();
        }
    }

    /**
     * Fait jouer le tour de jeu.
     * Les joueurs piochent des cartes si nécessaire et l'état du jeu est affiché.
     */
    public void deroulementTour(){
        for (Pokemon p: this.m_terrain.getPokemonJoueur()) {
            p.setPossedeAttaque(true);
        }
        while((this.m_humain.getMainListe().size()<5)&&!this.m_humain.getM_deck().estVide()){
            m_humain.pioche();
        }
        while((this.m_IA.getMainListe().size()<5)&&!this.m_IA.getM_deck().estVide()){
            m_IA.pioche();
        }
        while(joueurActif.equals("IA")&&this.m_terrain.getPokemonIA().size()<3&&this.m_IA.getMainListe().size()>0){
            this.m_terrain.ajoutPokemonIA(this.m_IA.getM_main());
        }
        while(joueurActif.equals("Joueur")&&this.m_terrain.getPokemonJoueur().size()<3&&this.m_humain.getMainListe().size()>0){
            m_affiche.affichageTerrain(this.m_terrain);
            m_affiche.affichageMain(this.m_humain.getM_main());
            this.ajoutTerrain(3-this.m_terrain.getPokemonJoueur().size());
        }

        Scanner s = new Scanner(System.in);
        if (joueurActif.equals("IA")) {
            this.m_IA.actionDuTour(this.m_terrain, this.m_humain);
        }

        if(joueurActif.equals("Joueur")) {
            Boolean tour =true;
            while (tour) {
                m_affiche.affichageTerrain(this.m_terrain);
                m_affiche.affichageMain(this.m_humain.getM_main());
                tour = this.m_humain.actionDuTour(this.m_terrain, this.m_IA);
            }
        }
        changementJoueur();
    }

    /**
     * Demande au joueur d'ajouter un Pokémon sur le terrain.
     * Le nombre de pokémon restants à ajouter est passé en paramètre.
     *
     * @param nombre Le nombre de pokémon restants à ajouter.
     */
    public void ajoutTerrain(int nombre){
        m_affiche.demandeAjout(nombre);
        this.m_humain.ajoutPokemon(this.m_terrain);
    }

}
