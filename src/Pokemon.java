import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pokemon
{
  private static ArrayList<Pokemon> pokedex = new ArrayList<>();
  private static ArrayList<String> nomPokemon = new ArrayList<>(Arrays.asList("Bulbasaur","Ivysaur","Venusaur","Mega","Venusaur","Charmander","Charmeleon","Charizard","Squirtle","Wartortle","Blastoise","Mega","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill","Pidgey","Pidgeotto","Pidgeot","Mega","Pidgeot","Rattata","Rattata","Raticate","Raticate","Spearow","Fearow","Ekans","Arbok","Pikachu","Raichu","Raichu","Sandshrew","Sandshrew","Sandslash","Sandslash","NidoranF","Nidorina","Nidoqueen","NidoranM","Nidorino","Nidoking","Clefairy","Clefable","Vulpix","Vulpix","Ninetales","Ninetales","Jigglypuff","Wigglytuff","Zubat","Golbat","Oddish","Gloom","Vileplume","Paras","Parasect","Venonat","Venomoth","Diglett","Diglett","Dugtrio","Dugtrio","Meowth","Meowth","Meowth","Persian","Persian","Psyduck","Golduck","Mankey","Primeape","Growlithe","Arcanine","Poliwag","Poliwhirl","Poliwrath","Abra","Kadabra","Alakazam","Machop","Machoke","Machamp","Bellsprout","Weepinbell","Victreebel","Tentacool","Tentacruel","Geodude","Geodude","Graveler","Graveler","Golem","Golem","Ponyta","Ponyta","Rapidash","Rapidash","Slowpoke","Slowpoke","Slowbro","Slowbro","Magnemite","Magneton","Farfetch'd","Farfetch'd","Doduo","Dodrio","Seel","Dewgong","Grimer","Grimer","Muk","Muk","Shellder","Cloyster","Gastly","Haunter","Gengar","Mega","Gengar","Onix","Drowzee","Hypno","Krabby","Kingler","Voltorb","Electrode","Exeggcute","Exeggutor","Exeggutor","Cubone","Marowak","Marowak","Hitmonlee","Hitmonchan","Lickitung","Koffing","Weezing","Weezing","Rhyhorn","Rhydon","Chansey","Tangela","Kangaskhan","Horsea","Seadra","Goldeen","Seaking","Staryu","Starmie","Mr.Mime","Mr.Mime","Scyther","Jynx","Electabuzz","Magmar","Pinsir","Tauros","Magikarp","Gyarados","Lapras","Ditto","Eevee","Vaporeon","Jolteon","Flareon","Porygon","Omanyte","Omastar","Kabuto","Kabutops","Aerodactyl","Snorlax","Articuno","Zapdos","Moltres","Dratini","Dragonair","Dragonite","Mewtwo","Mew"));
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
    System.out.println("Deck joueur :");
    for(Pokemon p : joueur.getPile()) {
      System.out.println(p.m_nom);
    }
    System.out.println("\nDeck IA:");
    for(Pokemon p : IA.getPile()) {
      System.out.println(p.m_nom);
    }
  }
}
