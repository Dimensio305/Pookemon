package Pookemon.Deroulement;

import Pookemon.DetailPokemon.Boost;
import Pookemon.DetailPokemon.Pokemon;
import Pookemon.Carte.Terrain;
import Pookemon.Personnage.Humain;
import Pookemon.Personnage.IA;

import java.util.ArrayList;
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
     * @param humain  Le joueur humain.
     * @param ia      L'intelligence artificielle.
     * @param terrain Le terrain de jeu.
     * @param actif   Le joueur actif ("Joueur" ou "IA").
     */
    public Tour(Humain humain, IA ia, Terrain terrain, String actif){
        m_humain = humain;
        m_IA = ia;
        m_terrain = terrain;
        joueurActif = actif;
    }

    /**
     * Change le joueur actif.
     */
    public static void changementJoueur(){
        if(joueurActif.equals("IA")){
            joueurActif="Joueur";
        }else{joueurActif="IA";}
    }


    /**
     * Effectue la mise en place du tour de jeu.
     * Si c'est au tour du joueur, effectue ses actions, sinon, effectue les actions de l'IA.
     * Affiche l'état actuel du jeu deux fois.
     */
    public void miseEnPlace(){
        if (joueurActif.equals("Joueur")) {
            while(this.m_terrain.getPokemonJoueur().size()<3){
                m_affiche.affichageMain(this.m_humain.getMain());
                this.ajoutTerrain(3-this.m_terrain.getPokemonJoueur().size());
            }
            while(this.m_terrain.getPokemonIA().size()<3){
                this.m_terrain.ajoutPokemonIA(this.m_IA.getMain());
            }
        }else {
            while(this.m_terrain.getPokemonIA().size()<3){
                this.m_terrain.ajoutPokemonIA(this.m_IA.getMain());
            }
            m_affiche.terrainAdverse(this.m_terrain);
            System.out.println("Voici les pokémon choisis par votre adversaire.");
            new Scanner(System.in).nextLine();
            while(this.m_terrain.getPokemonJoueur().size()<3){
                m_affiche.affichageMain(this.m_humain.getMain());
                this.ajoutTerrain(3-this.m_terrain.getPokemonJoueur().size());
            }
        }
        while (true) {
            deroulementTour();
        }
    }

    /**
     * Effectue le déroulement du tour de jeu.
     * Les joueurs piochent des cartes si nécessaire et l'état du jeu est affiché.
     */
    public void deroulementTour(){
        for (Pokemon p: this.m_terrain.getPokemonJoueur()) {
            p.setPossedeAttaque(true);
            if (p.getPouvoir()!=null) {
                p.getPouvoir().UtilisableCeTour();
            }
            if(joueurActif.equals("Joueur")) {
                ArrayList<Boost> supprime = new ArrayList<>();
                for (Boost b: p.getBoost()) {
                    if(!b.isDureeInfini()){
                        supprime.add(b);
                    }
                }
                for (Boost b: supprime) {
                    p.getBoost().remove(b);
                }
                switch (p.getStatut()) {
                    case AUCUN:
                        break;
                    case EMPOISONNE:
                        p.setPv(p.getPv() - 10, this.m_terrain);
                }
            }
        }
        for (Pokemon p: this.m_terrain.getPokemonIA()) {
            if (p.getPouvoir()!=null) {
                p.getPouvoir().UtilisableCeTour();
            }
            if(joueurActif.equals("IA")) {
                ArrayList<Boost> supprime = new ArrayList<>();
                for (Boost b: p.getBoost()) {
                    if(!b.isDureeInfini()){
                        supprime.add(b);
                    }
                }
                for (Boost b: supprime) {
                    p.getBoost().remove(b);
                }
                switch (p.getStatut()){
                case AUCUN:
                    break;
                case EMPOISONNE:
                        p.setPv(p.getPv() - 10, this.m_terrain);
                }
            }
        }
        while((this.m_humain.getMainListe().size()<5)&&!this.m_humain.getDeck().estVide()){
            m_humain.pioche();
        }
        while((this.m_IA.getMainListe().size()<5)&&!this.m_IA.getDeck().estVide()){
            m_IA.pioche();
        }
        while(joueurActif.equals("IA")&&this.m_terrain.getPokemonIA().size()<3&&this.m_IA.getMainListe().size()>0){
            this.m_terrain.ajoutPokemonIA(this.m_IA.getMain());
        }
        while(joueurActif.equals("Joueur")&&this.m_terrain.getPokemonJoueur().size()<3&&this.m_humain.getMainListe().size()>0){
            m_affiche.affichageTerrain(this.m_terrain);
            m_affiche.affichageMain(this.m_humain.getMain());
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
                m_affiche.affichageMain(this.m_humain.getMain());
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
        this.m_affiche.demandeAjout(nombre);
        this.m_humain.ajoutPokemon(this.m_terrain);
    }

}
