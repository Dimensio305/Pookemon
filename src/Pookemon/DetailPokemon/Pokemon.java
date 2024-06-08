package Pookemon.DetailPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Pookemon.Deroulement.*;
import Pookemon.Carte.*;
import Pookemon.DetailPokemon.Pouvoirs.*;
import Pookemon.GestionMusique.Musique;
import Pookemon.Personnage.*;


public class Pokemon {
    private String m_nom;
    private Type m_type;
    private int m_pvMAX;
    private int m_pv;
    private int m_attaque;
    private boolean m_possedeAttaque;
    private Statut m_statut;
    private ArrayList<Boost> m_boost = new ArrayList<>();
    private Pouvoir m_pouvoir;
    private Joueur m_joueur;
    private boolean m_shiny;


    /**
     * Constructeur de la classe Pokemon
     * Créé un pokemon avec un nom et une attaque et des points de vie aléatoires
     *
     * @param nom Le nom du pokemon choisis dans le main plus bas
     */
    public Pokemon(String nom) {
        m_attaque = new Random().nextInt(1, 5) * 10;
        m_nom = nom;
        m_pvMAX = new Random().nextInt(10, 21) * 10;
        m_pv = m_pvMAX;
        m_type = Type.values()[new Random().nextInt(Type.values().length)];
        m_shiny = new Random().nextInt(1, 5)==1;
        m_statut = Statut.AUCUN;
        m_pouvoir = null;
        Pokedex.add(this);
        m_possedeAttaque = true;
        m_joueur = null;
    }

    /**
     * Renvoie le nom du Pokemon avec couleur si shiny
     *
     * @return La chaine de caractère du nom du Pokemon
     */
    public String getNom() {
        if(this.isShiny()){return "\u001B[93m"+this.m_nom +" \u001B[0m";}
        else{return this.m_nom;}
    }

    /**
     * Renvoie le nom comparable du Pokémon.
     *
     * @return Le nom comparable du Pokémon.
     */
    public String getNomComparable(){
        return this.m_nom;
    }

    /**
     * Renvoie le Type du Pokemon
     *
     * @return Le Type sous formes de chaine de caractère
     */
    public Type getType() {
        return this.m_type;
    }

    /**
     * Renvoie le nombre de PV actuel du Pokemon
     *
     * @return Un entier correspondant aux PV du Pokemon
     */
    public int getPv() {
        return this.m_pv;
    }

    /**
     * Définit les PV du Pokémon.
     *
     * @param pv Les points de vie du Pokémon.
     * @param terrain Le terrain sur lequel se déroule le combat.
     */
    public void setPv(int pv, Terrain terrain){
        this.m_pv = pv;
        if (this.estMort()) {
            this.m_joueur.defausse(this);
            this.m_joueur.pokemonDeuil(this, terrain);
        }
    }

    /**
     * Renvoie la limite de PV du Pokemon
     *
     * @return Un entier correspondant aux PV maximum du Pokemon
     */
    public int getPvMAX() {
        return this.m_pvMAX;
    }

    /**
     * Renvoie les dégâts initiaux infligés par le Pokémon.
     *
     * @return Un entier correspondant aux dégâts initiaux du Pokémon.
     */
    public int getAttaqueInitial() {
        return this.m_attaque;
    }

    /**
     * Renvoie les dégats qu'inflige le Pokemon
     *
     * @return Un entier correspondant aux dégats actuel du Pokemon
     */
    public int getAttaque() {
        int dgt = this.m_attaque;
        for (Boost b: this.m_boost) {
            if (b.isAttaque()){
                dgt += b.getValeur();
            }
        }
        return dgt;
    }

    /**
     * Vérifie si le Pokémon est de type Shiny.
     *
     * @return true si le Pokémon est Shiny, sinon false.
     */
    public boolean isShiny(){
        return this.m_shiny;
    }

    /**
     * Définit si le Pokémon possède une attaque.
     *
     * @param bool true si le Pokémon possède une attaque, sinon false.
     */
    public void setPossedeAttaque(boolean bool){
        this.m_possedeAttaque=bool;
    }

    /**
     * Cette méthode renvoie le pouvoir du Pokémon.
     *
     * @return Le pouvoir du Pokémon.
     */
    public Pouvoir getPouvoir(){
        return this.m_pouvoir;
    }

    /**
     * Cette méthode définit le pouvoir du Pokémon.
     *
     * @param p Le pouvoir à définir pour le Pokémon.
     */
    public void setPouvoir(Pouvoir p){
        this.m_pouvoir = p;
    }

    /**
     * Cette méthode vérifie si le Pokémon possède une attaque.
     *
     * @return true si le Pokémon possède une attaque, sinon false.
     */
    public boolean isPossedeAttaque(){
        return this.m_possedeAttaque;
    }

    /**
     * Cette méthode renvoie le statut du Pokémon.
     *
     * @return Le statut du Pokémon.
     */
    public Statut getStatut(){
        return this.m_statut;
    }

    /**
     * Cette méthode définit le statut du Pokémon.
     *
     * @param statut Le statut à définir pour le Pokémon.
     */
    public void setStatut(Statut statut){
        this.m_statut = statut;
    }

    /**
     * Cette méthode renvoie le joueur propriétaire du Pokémon.
     *
     * @return Le joueur propriétaire du Pokémon.
     */
    public Joueur getJoueur(){
        return this.m_joueur;
    }

    /**
     * Cette méthode définit le joueur propriétaire du Pokémon.
     *
     * @param maitreAbsoluAuquelleJeDoisObeir Le joueur propriétaire du Pokémon.
     */
    public void setJoueur(Joueur maitreAbsoluAuquelleJeDoisObeir){
        this.m_joueur = maitreAbsoluAuquelleJeDoisObeir;
    }

    /**
     * Cette méthode renvoie la liste des boosts du Pokémon.
     *
     * @return La liste des boosts du Pokémon.
     */
    public ArrayList<Boost> getBoost() {
        return this.m_boost;
    }

    /**
     * Cette méthode ajoute un boost à la liste des boosts du Pokémon.
     *
     * @param b Le boost à ajouter.
     */
    public void ajoutBoost(Boost b){
        this.m_boost.add(b);
    }

    /**
     * Cette méthode fait subir des dégâts au Pokémon.
     *
     * @param dmg Les dégâts à infliger.
     * @param type Le type de dégât.
     * @param joueur Le joueur auquel appartient le Pokémon.
     * @param terrain Le terrain sur lequel se déroule le combat.
     */
    public void subitDegat(int dmg, Type type, Joueur joueur, Terrain terrain){
        int affinite = this.affiniteType(type);
         affinite += dmg;
        for (Boost b: this.m_boost) {
            if (!b.isAttaque()){
                affinite -= b.getValeur();
            }
        }
        if (affinite < 0){
            affinite = 0;
        }
        this.m_pv-= affinite;
        if (this.estMort()) {
            joueur.defausse(this);
            joueur.pokemonDeuil(this, terrain);
        }

    }

    /**
     * Cette méthode calcule l'affinité du Pokémon par rapport à un type donné.
     *
     * @param type Le type par rapport auquel calculer l'affinité.
     * @return L'affinité du Pokémon par rapport au type donné.
     */
    public int affiniteType(Type type){
        switch (this.m_type){
            case FEE :
                if (type.equals(Type.POISON)||type.equals(Type.ACIER)){
                    return 10;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.DRAGON)||type.equals(Type.INSECTE)||type.equals(Type.TENEBRE)) {
                    return -10;
                }
                return 0;
            case ACIER:
                if (type.equals(Type.COMBAT)||type.equals(Type.FEU)||type.equals(Type.SOL)){
                    return 10;
                } else if (type.equals(Type.ACIER)||type.equals(Type.DRAGON)||type.equals(Type.FEE)||type.equals(Type.GLACE)
                        ||type.equals(Type.INSECTE)||type.equals(Type.NORMAL)||type.equals(Type.PLANTE)||type.equals(Type.POISON)
                        ||type.equals(Type.PSY)||type.equals(Type.ROCHE)||type.equals(Type.VOL)) {
                    return -10;
                }
                return 0;
            case COMBAT:
                if (type.equals(Type.FEE)||type.equals(Type.PSY)||type.equals(Type.VOL)){
                    return 10;
                } else if (type.equals(Type.INSECTE)||type.equals(Type.ROCHE)||type.equals(Type.TENEBRE)) {
                    return -10;
                }
                return 0;
            case DRAGON:
                if (type.equals(Type.DRAGON)||type.equals(Type.FEE)||type.equals(Type.GLACE)){
                    return 10;
                } else if (type.equals(Type.EAU)||type.equals(Type.ELECTRIQUE)||type.equals(Type.FEU)||type.equals(Type.PLANTE)) {
                    return -10;
                }
                return 0;
            case EAU:
                if (type.equals(Type.PLANTE)||type.equals(Type.ELECTRIQUE)){
                    return 10;
                } else if (type.equals(Type.ACIER)||type.equals(Type.EAU)||type.equals(Type.FEU)||type.equals(Type.GLACE)) {
                    return -10;
                }
                return 0;
            case ELECTRIQUE:
                if (type.equals(Type.SOL)){
                    return 10;
                } else if (type.equals(Type.ACIER)||type.equals(Type.ELECTRIQUE)||type.equals(Type.VOL)) {
                    return -10;
                }
                return 0;
            case FEU:
                if (type.equals(Type.EAU)||type.equals(Type.ROCHE)||type.equals(Type.SOL)){
                    return 10;
                } else if (type.equals(Type.ACIER)||type.equals(Type.FEE)||type.equals(Type.FEU)||type.equals(Type.GLACE)
                        ||type.equals(Type.INSECTE)||type.equals(Type.PLANTE)) {
                    return -10;
                }
                return 0;
            case GLACE:
                if (type.equals(Type.ACIER)||type.equals(Type.COMBAT)||type.equals(Type.FEU)||type.equals(Type.ROCHE)){
                    return 10;
                } else if (type.equals(Type.GLACE)) {
                    return -10;
                }
                return 0;
            case INSECTE:
                if (type.equals(Type.FEU)||type.equals(Type.ROCHE)||type.equals(Type.VOL)){
                    return 10;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.PLANTE)||type.equals(Type.SOL)) {
                    return -10;
                }
                return 0;
            case NORMAL:
                if (type.equals(Type.COMBAT)){
                    return 10;
                } else if (type.equals(Type.SPECTRE)) {
                    return -10;
                }
                return 0;
            case PLANTE:
                if (type.equals(Type.FEU)||type.equals(Type.GLACE)||type.equals(Type.INSECTE)||type.equals(Type.POISON)||type.equals(Type.VOL)){
                    return 10;
                } else if (type.equals(Type.EAU)||type.equals(Type.ELECTRIQUE)||type.equals(Type.PLANTE)||type.equals(Type.SOL)) {
                    return -10;
                }
                return 0;
            case POISON:
                if (type.equals(Type.PSY)||type.equals(Type.SOL)){
                    return 10;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.FEE)||type.equals(Type.INSECTE)||type.equals(Type.PLANTE)||type.equals(Type.POISON)) {
                    return -10;
                }
                return 0;
            case PSY:
                if (type.equals(Type.INSECTE)||type.equals(Type.SPECTRE)||type.equals(Type.TENEBRE)){
                    return 10;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.PSY)) {
                    return -10;
                }
                return 0;
            case ROCHE:
                if (type.equals(Type.ACIER)||type.equals(Type.COMBAT)||type.equals(Type.EAU)||type.equals(Type.PLANTE)||type.equals(Type.SOL)){
                    return 10;
                } else if (type.equals(Type.FEU)||type.equals(Type.NORMAL)||type.equals(Type.POISON)||type.equals(Type.VOL)) {
                    return -10;
                }
                return 0;
            case SOL:
                if (type.equals(Type.EAU)||type.equals(Type.GLACE)||type.equals(Type.PLANTE)){
                    return 10;
                }else if (type.equals(Type.ELECTRIQUE)||type.equals(Type.POISON)||type.equals(Type.ROCHE)) {
                    return -10;
                }
                return 0;
            case SPECTRE:
                if (type.equals(Type.SPECTRE)||type.equals(Type.TENEBRE)){
                    return 10;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.NORMAL)||type.equals(Type.INSECTE)||type.equals(Type.POISON)) {
                    return -10;
                }
                return 0;
            case TENEBRE:
                if (type.equals(Type.COMBAT)||type.equals(Type.FEE)||type.equals(Type.INSECTE)){
                    return 10;
                } else if (type.equals(Type.PSY)||type.equals(Type.SPECTRE)||type.equals(Type.TENEBRE)) {
                    return -10;
                }
                return 0;
            case VOL:
                if (type.equals(Type.ELECTRIQUE)||type.equals(Type.GLACE)||type.equals(Type.ROCHE)){
                    return 10;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.INSECTE)||type.equals(Type.PLANTE)||type.equals(Type.SOL)) {
                    return -10;
                }
                return 0;
            default:
                return 0;
        }
    }

    /**
     * Cette méthode vérifie si le Pokémon est mort.
     *
     * @return true si le Pokémon est mort, sinon false.
     */
    public boolean estMort(){
        return (this.m_pv<1);
    };


    public static void main(String args[]){
        String joueurActif;
        Humain joueurHumain;
        IA ordinateur;
        for (String nom: Pokedex.getNom()) {
            new Pokemon(nom);
        }
        if(new Random().nextBoolean()){
            joueurHumain = new Humain(new Deck(1));
            ordinateur= new IA(new Deck(2));
            joueurActif="Joueur";
        }else {


            joueurHumain = new Humain(new Deck(2));
            ordinateur= new IA(new Deck(1));
            joueurActif="IA";
        }
        new Musique().Ecoute("src/Pookemon/GestionMusique/MainTheme.wav");
        Affichage print = new Affichage();
        print.StartingGame();
        joueurHumain.pressEnter();
        print.tuto();
        joueurHumain.pressEnter();
        print.tourJoueur(joueurActif);
        joueurHumain.pressEnter();
        Tour T1 = new Tour(joueurHumain, ordinateur, new Terrain(),joueurActif);
        T1.miseEnPlace();
    }
}