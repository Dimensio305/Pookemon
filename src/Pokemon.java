import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pokemon
{
  private static ArrayList<Pokemon> pokedex = new ArrayList<>();
  private static ArrayList<String> nomPokemon = new ArrayList<>(Arrays.asList("Salameche","Reptincel","Dracaufeu", "Carapuce","Carabaffe","Tortank", "Bulbizarre","Herbizarre","Mewtwo","Mew","Artikodin","Elekthor","Sulfura","Magneton","Magnezone","Magneti","Florizarre","Roucool","Roucoups","Roucarnage","Chenipan","Chrysacier","Papilusion","Mimitoss","Aeromite"));
  private String m_nom;
  private Type m_type;
  private int m_pv;
  private int m_attaque;

  public enum Type {FEU,EAU,PLANTE,ACIER,ROCHE,VOL,POISON,GLACE,INSECTE,PSY,TENEBRE,FEE,ELECTRIQUE,NORMAL,COMBAT,SPECTRE,SOL,DRAGON}

  public Pokemon(String nom){
    m_attaque= new Random().nextInt();
    m_nom=nom;
    m_pv= new Random().nextInt();
    m_type= Type.ACIER;
    pokedex.add(this);
  }




  /*
  public boolean estFaible( P okemon other){
    return faiblesse.Contains(other.m_type);
  }
*/

  public static ArrayList<Pokemon> getPokedex(){
    return pokedex;
  }

  public static void main(String args[])
  {

    System.out.println("Lancement du jeu ...");
    for (String nom: nomPokemon) {
      new Pokemon(nom);
    }
    System.out.println("Choississez le type de votre deck (ou aléatoire pour un deck non-typé):");
    Deck joueur;
    Deck IA;
    if(new Random().nextBoolean()){
       System.out.println("Vous commencerez la partie !");
       joueur= new Deck(1);
       IA= new Deck(2);
    }else {
       System.out.println("Vous jouerez en second.");
       joueur= new Deck(2);
       IA= new Deck(1);
    }

    for(Pokemon p : joueur.getPile()) {
      System.out.println(p.m_nom);
    }
  }
}
