import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pokemon
{
  private static ArrayList<Pokemon> m_pokedex = new ArrayList<>();
  private static ArrayList<String> m_nomPokemon = new ArrayList<>(Arrays.asList("Bulbizarre","Herbizarre","Florizarre","Salamèche","Reptincel","Dracaufeu","Carapuce","Carabaffe","Tortank","Chenipan","Chrysacier","Papilusion","Aspicot","Coconfort","Dardargnan","Roucool","Roucoups","Roucarnage","Rattata","Rattatac","Piafabec","Rapasdepic","Abo","Arbok","Pikachu","Raichu","Sabelette","Sablaireau","Nidoran♀","Nidorina","Nidoqueen","Nidoran♂","Nidorino","Nidoking","Mélofée","Mélodelfe","Goupix","Feunard","Rondoudou","Grodoudou","Nosferapti","Nosferalto","Mystherbe","Ortide","Rafflesia","Paras","Parasect","Mimitoss","Aéromite","Taupiqueur","Triopikeur","Miaouss","Persian","Psykokwak","Akwakwak","Férosinge","Colossinge","Caninos","Arcanin","Ptitard","Têtarte","Tartard","Abra","Kadabra","Alakazam","Machoc","Machopeur","Mackogneur","Chétiflor","Boustiflor","Empiflor","Tentacool","Tentacruel","Racaillou","Gravalanch","Grolem","Ponyta","Galopa","Ramoloss","Flagadoss","Magnéti","Magnéton","Canarticho","Doduo","Dodrio","Otaria","Lamantine","Tadmorv","Grotadmorv","Kokiyas","Crustabri","Fantominus","Spectrum","Ectoplasma","Onix","Soporifik","Hypnomade","Krabby","Krabboss","Voltorbe","Électrode","Noeunoeuf","Noadkoko","Osselait","Ossatueur","Kicklee","Tygnon","Excelangue","Smogo","Smogogo","Rhinocorne","Rhinoféros","Leveinard","Saquedeneu","Kangourex","Hypotrempe","Hypocéan","Poissirène","Poissoroy","Stari","Staross","M.Mime","Insécateur","Lippoutou","Élektek","Magmar","Scarabrute","Tauros","Magicarpe","Léviator","Lokhlass","Métamorph","Évoli","Aquali","Voltali","Pyroli","Porygon","Amonita","Amonistar","Kabuto","Kabutops","Ptéra","Ronflex","Artikodin","Électhor","Sulfura","Minidraco","Draco","Dracolosse","Mewtwo","Mew"));
  private String m_nom;
  private Type m_type;

  private int m_pvMAX;
  private int m_pv;
  private int m_attaque;


  public Pokemon(String nom){
    m_attaque= new Random().nextInt(1,4)*10;
    m_nom=nom;
    m_pvMAX= new Random().nextInt(10,20)*10;
    m_pv =m_pvMAX;
    m_type= Type.values()[new Random().nextInt(Type.values().length)];
    m_pokedex.add(this);
  }


  @Override
  public String toString(){
      return this.m_nom+": " + this.m_type + ", PV : " +this.m_pv+"/"+this.m_pvMAX+", DMG: "+this.m_attaque;
  }


  /*
  public boolean estFaible( P okemon other){
    return faiblesse.Contains(other.m_type);
  }
*/

  public static ArrayList<Pokemon> getPokedex(){
    return m_pokedex;
  }

  public static void main(String args[])
{

    System.out.println("Lancement du jeu ...");
    for (String nom: m_nomPokemon) {
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
    /*
    System.out.println("Deck joueur :");
    for(Pokemon p : joueur.getPile()) {
      System.out.println(p.m_nom);
    }
    System.out.println("\nDeck IA:");
    for(Pokemon p : IA.getPile()) {
      System.out.print(p.m_nom+" , ");
      System.out.println(p.m_attaque+ " , "+p.m_pv);
    }*/

    Tour T1 = new Tour(new Main(joueur), new Main(IA), new Terrain());
    T1.deroulementTour();
  }
}
