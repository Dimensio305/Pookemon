package Pookemon.Affichage;

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
        for (Pokemon p: this.m_terrain.getPokemonIA()) {
            p.setPossedeAttaque(true);
        }
        while((this.m_humain.getM_main().getMain().size()<5)&&!this.m_humain.getM_deck().estVide()){
            m_humain.getM_main().pioche(m_humain.getM_deck());
        }
        while((this.m_IA.getM_main().getMain().size()<5)&&!this.m_IA.getM_deck().estVide()){
            m_IA.getM_main().pioche(m_IA.getM_deck());
        }
        while(joueurActif.equals("IA")&&this.m_terrain.getPokemonIA().size()<3&&this.m_IA.getM_main().getMain().size()>0){
            this.m_terrain.ajoutPokemonIA(this.m_IA.getM_main());
        }
        while(joueurActif.equals("Joueur")&&this.m_terrain.getPokemonJoueur().size()<3&&this.m_humain.getM_main().getMain().size()>0){
            m_affiche.affichageTerrain(this.m_terrain);
            m_affiche.affichageMain(this.m_humain.getM_main());
            this.ajoutTerrain(3-this.m_terrain.getPokemonJoueur().size());
        }
        Scanner s = new Scanner(System.in);

        if (joueurActif.equals("IA")) {
            for(Pokemon p: this.m_terrain.getPokemonIA()){
                if(p.isPossedeAttaque()) {
                    int i = 0;
                    List<Pokemon> ciblePossible = new ArrayList<>();
                    int cibleIndex;
                    while (i < this.m_terrain.getPokemonJoueur().size()) {
                        if (this.m_terrain.getPokemonJoueur().get(i).affiniteType(p.getType()) == 1) {
                            ciblePossible.add(this.m_terrain.getPokemonJoueur().get(i));
                        }
                        i++;
                    }
                    i=0;
                    if (ciblePossible.size() == 1) {
                        ciblePossible.get(0).subitDegat(p.getAttaque(), p.getType());
                        if (ciblePossible.get(0).estMort()) {
                            this.m_humain.getM_deck().estDefausse(ciblePossible.get(0));
                            this.m_terrain.retirePokemonJoueur(this.m_terrain.getIndexJoueur(ciblePossible.get(0).getNom()));
                        }
                        m_affiche.affichageTerrain(this.m_terrain);
                        System.out.println("Le " +p.getNom()+" adverse attaque " + ciblePossible.get(0).getNom());

                        if (ciblePossible.get(0).estMort()) {
                            System.out.println(ciblePossible.get(0).getNom() + "a été mis KO.");
                        }
                        s.nextLine();
                    } else if (ciblePossible.size() > 1) {
                        int pvMin = 1000;
                        for (Pokemon cible : ciblePossible) {
                            if (pvMin > cible.getPv()) {
                                pvMin = cible.getPv();
                            }
                        }
                        for (Pokemon cible : ciblePossible) {
                            if (pvMin != cible.getPv()) {
                                ciblePossible.remove(cible);
                            }
                        }
                        if (ciblePossible.size() == 1) {
                            ciblePossible.get(0).subitDegat(p.getAttaque(), p.getType());
                            if (ciblePossible.get(0).estMort()) {
                                this.m_humain.getM_deck().estDefausse(ciblePossible.get(0));
                                this.m_terrain.retirePokemonJoueur(this.m_terrain.getIndexJoueur(ciblePossible.get(0).getNom()));
                            }
                            m_affiche.affichageTerrain(this.m_terrain);
                            System.out.println("Le " +p.getNom()+" adverse attaque " + ciblePossible.get(0).getNom());

                            if (ciblePossible.get(0).estMort()) {
                                System.out.println(ciblePossible.get(0).getNom() + "a été mis KO.");
                            }
                            s.nextLine();
                        } else {
                            cibleIndex =new Random().nextInt(0, ciblePossible.size());
                            ciblePossible.get(cibleIndex).subitDegat(p.getAttaque(), p.getType());
                            if (ciblePossible.get(cibleIndex).estMort()) {
                                this.m_humain.getM_deck().estDefausse(ciblePossible.get(cibleIndex));
                                this.m_terrain.retirePokemonJoueur(this.m_terrain.getIndexJoueur(ciblePossible.get(cibleIndex).getNom()));
                            }
                            m_affiche.affichageTerrain(this.m_terrain);
                            System.out.println("Le " +p.getNom()+" adverse attaque " + ciblePossible.get(cibleIndex).getNom());

                            if (ciblePossible.get(cibleIndex).estMort()) {
                                System.out.println(ciblePossible.get(cibleIndex).getNom() + "a été mis KO.");
                            }
                            s.nextLine();
                        }
                    } else {
                        int pvMin = 1000;
                        while (i < this.m_terrain.getPokemonJoueur().size()) {
                            if (pvMin > this.m_terrain.getPokemonJoueur().get(i).getPv()) {
                                pvMin = this.m_terrain.getPokemonJoueur().get(i).getPv();
                            }
                            i++;
                        }
                        i=0;
                        while (i < this.m_terrain.getPokemonJoueur().size()) {
                            if (pvMin == this.m_terrain.getPokemonJoueur().get(i).getPv()) {
                                ciblePossible.add(this.m_terrain.getPokemonJoueur().get(i));
                            }
                            i++;
                        }
                        i=0;
                        if (ciblePossible.size() == 1) {
                            ciblePossible.get(0).subitDegat(p.getAttaque(), p.getType());
                            if (ciblePossible.get(0).estMort()) {
                                this.m_humain.getM_deck().estDefausse(ciblePossible.get(0));
                                this.m_terrain.retirePokemonJoueur(this.m_terrain.getIndexJoueur(ciblePossible.get(0).getNom()));
                            }
                            m_affiche.affichageTerrain(this.m_terrain);
                            System.out.println("Le " +p.getNom()+" adverse attaque " + ciblePossible.get(0).getNom());

                            if (ciblePossible.get(0).estMort()) {
                                System.out.println(ciblePossible.get(0).getNom() + "a été mis KO.");
                            }
                            s.nextLine();
                        } else {
                            cibleIndex =new Random().nextInt(0, ciblePossible.size());
                            ciblePossible.get(cibleIndex).subitDegat(p.getAttaque(), p.getType());
                            if (ciblePossible.get(cibleIndex).estMort()) {
                                this.m_humain.getM_deck().estDefausse(ciblePossible.get(cibleIndex));
                                this.m_terrain.retirePokemonJoueur(this.m_terrain.getIndexJoueur(ciblePossible.get(cibleIndex).getNom()));
                            }
                            m_affiche.affichageTerrain(this.m_terrain);
                            System.out.println("Le " +p.getNom()+" adverse attaque " + ciblePossible.get(cibleIndex).getNom());

                            if (ciblePossible.get(cibleIndex).estMort()) {
                                System.out.println(ciblePossible.get(cibleIndex).getNom() + "a été mis KO.");
                            }
                            s.nextLine();
                        }
                    }
                }
            }
        }

        if(joueurActif.equals("Joueur")) {

            String action = "";
            String cible = "-1";
            while (!action.equals("fin") && !action.equals("1")) {
                m_affiche.affichageTerrain(this.m_terrain);
                m_affiche.affichageMain(this.m_humain.getM_main());
                System.out.println("Que souhaitez vous faire ? \n   1: Fin du tour : [fin]");
                Boolean actionPossible = false;
                for (Pokemon p : this.m_terrain.getPokemonJoueur()) {
                    if (p.isPossedeAttaque()) {
                        actionPossible = true;
                    }
                }
                if (actionPossible) {
                    System.out.println("   2: Attaquer [atk]");
                }
                action = s.nextLine();
                if (actionPossible) {
                    if (action.equals("2") || action.equals("atk")) {
                        System.out.println("Quel pokemon souhaitez vous utilisez ?");
                        if (this.m_terrain.getPokemonJoueur().get(0).isPossedeAttaque()) {
                            System.out.println("   1: " + this.m_terrain.getPokemonJoueur().get(0));
                        }
                        if (this.m_terrain.getPokemonJoueur().get(1).isPossedeAttaque()) {
                            System.out.println("   2: " + this.m_terrain.getPokemonJoueur().get(1));
                        }
                        if (this.m_terrain.getPokemonJoueur().get(2).isPossedeAttaque()) {
                            System.out.println("   3: " + this.m_terrain.getPokemonJoueur().get(2));
                        }
                        action = s.nextLine();

                        if (this.m_terrain.joueurContient(action) && this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).isPossedeAttaque()) {
                            m_affiche.demandeCibleAdverse(this.m_terrain);
                            cible = s.nextLine();
                            if (this.m_terrain.IAContient(cible)) {
                                this.m_terrain.getPokemonIA().get(this.m_terrain.getIndexIA(cible)).subitDegat(this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).getAttaque(), this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).getType());
                                this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).setPossedeAttaque(false);
                                if (this.m_terrain.getPokemonIA().get(this.m_terrain.getIndexIA(cible)).estMort()) {
                                    this.m_IA.getM_deck().estDefausse(this.m_terrain.getPokemonIA().get(this.m_terrain.getIndexIA(cible)));
                                    this.m_terrain.retirePokemonIA(this.m_terrain.getIndexIA(cible));
                                }
                            }
                            if (cible.equals("1") || cible.equals("2") || cible.equals("3")) {
                                if (Integer.parseInt(cible) <= this.m_terrain.getPokemonIA().size() && Integer.valueOf(cible) >= 0) {
                                    this.m_terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).subitDegat(this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).getAttaque(), this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).getType());
                                    this.m_terrain.getPokemonJoueur().get(this.m_terrain.getIndexJoueur(action)).setPossedeAttaque(false);
                                    if (this.m_terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).estMort()) {
                                        this.m_IA.getM_deck().estDefausse(this.m_terrain.getPokemonIA().get(Integer.valueOf(cible) - 1));
                                        this.m_terrain.retirePokemonIA(Integer.valueOf(cible) - 1);
                                    }
                                }
                            }
                        }

                        if ((action.equals("1") && this.m_terrain.getPokemonJoueur().get(0).isPossedeAttaque()) ||
                                (action.equals("2") && this.m_terrain.getPokemonJoueur().get(1).isPossedeAttaque()) ||
                                (action.equals("3") && this.m_terrain.getPokemonJoueur().get(2).isPossedeAttaque())) {

                            m_affiche.demandeCibleAdverse(this.m_terrain);
                            cible = s.nextLine();
                            if (this.m_terrain.IAContient(cible)) {
                                this.m_terrain.getPokemonIA().get(this.m_terrain.getIndexIA(cible)).subitDegat(this.m_terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getAttaque(), this.m_terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getType());
                                this.m_terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).setPossedeAttaque(false);
                                if (this.m_terrain.getPokemonIA().get(this.m_terrain.getIndexIA(cible)).estMort()) {
                                    this.m_IA.getM_deck().estDefausse(this.m_terrain.getPokemonIA().get(this.m_terrain.getIndexIA(cible)));
                                    this.m_terrain.retirePokemonIA(this.m_terrain.getIndexIA(cible));
                                }
                            }
                            System.out.println(cible);
                            if (cible.equals("1") || cible.equals("2") || cible.equals("3")) {
                                if (Integer.parseInt(cible) <= this.m_terrain.getPokemonIA().size() && Integer.valueOf(cible) >= 0) {
                                    this.m_terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).subitDegat(this.m_terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getAttaque(), this.m_terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getType());
                                    this.m_terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).setPossedeAttaque(false);
                                    if (this.m_terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).estMort()) {
                                        this.m_IA.getM_deck().estDefausse(this.m_terrain.getPokemonIA().get(Integer.valueOf(cible) - 1));
                                        this.m_terrain.retirePokemonIA(Integer.valueOf(cible) - 1);
                                    }
                                }
                            }
                        }
                        action = "2";
                    }
                }
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
