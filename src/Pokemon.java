import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Pokemon {
    private static ArrayList<Pokemon> m_pokedex = new ArrayList<>();
    private static ArrayList<String> m_nomPokemon = new ArrayList<>(Arrays.asList("Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel", "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier", "Papilusion", "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups", "Roucarnage", "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu", "Raichu", "Sabelette", "Sablaireau", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix", "Feunard", "Rondoudou", "Grodoudou", "Nosferapti", "Nosferalto", "Mystherbe", "Ortide", "Rafflesia", "Paras", "Parasect", "Mimitoss", "Aéromite", "Taupiqueur", "Triopikeur", "Miaouss", "Persian", "Psykokwak", "Akwakwak", "Férosinge", "Colossinge", "Caninos", "Arcanin", "Ptitard", "Têtarte", "Tartard", "Abra", "Kadabra", "Alakazam", "Machoc", "Machopeur", "Mackogneur", "Chétiflor", "Boustiflor", "Empiflor", "Tentacool", "Tentacruel", "Racaillou", "Gravalanch", "Grolem", "Ponyta", "Galopa", "Ramoloss", "Flagadoss", "Magnéti", "Magnéton", "Canarticho", "Doduo", "Dodrio", "Otaria", "Lamantine", "Tadmorv", "Grotadmorv", "Kokiyas", "Crustabri", "Fantominus", "Spectrum", "Ectoplasma", "Onix", "Soporifik", "Hypnomade", "Krabby", "Krabboss", "Voltorbe", "Électrode", "Noeunoeuf", "Noadkoko", "Osselait", "Ossatueur", "Kicklee", "Tygnon", "Excelangue", "Smogo", "Smogogo", "Rhinocorne", "Rhinoféros", "Leveinard", "Saquedeneu", "Kangourex", "Hypotrempe", "Hypocéan", "Poissirène", "Poissoroy", "Stari", "Staross", "M.Mime", "Insécateur", "Lippoutou", "Élektek", "Magmar", "Scarabrute", "Tauros", "Magicarpe", "Léviator", "Lokhlass", "Métamorph", "Évoli", "Aquali", "Voltali", "Pyroli", "Porygon", "Amonita", "Amonistar", "Kabuto", "Kabutops", "Ptéra", "Ronflex", "Artikodin", "Électhor", "Sulfura", "Minidraco", "Draco", "Dracolosse", "Mewtwo", "Mew"));
    private String m_nom;
    private Type m_type;
    private int m_pvMAX;
    private int m_pv;
    private int m_attaque;

    private boolean m_possedeAttaque;


    /**
     * Constructeur de la classe Pokemon
     * Créé un pokemon avec un nom et une attaque et des points de vie aléatoires
     *
     * @param nom Le nom du pokemon choisis dans le main plus bas
     */
    public Pokemon(String nom) {
        m_attaque = new Random().nextInt(1, 4) * 10;
        m_nom = nom;
        m_pvMAX = new Random().nextInt(10, 20) * 10;
        m_pv = m_pvMAX;
        m_type = Type.values()[new Random().nextInt(Type.values().length)];
        m_pokedex.add(this);
    }

    /**
     * Renvoie le nom du Pokemon
     *
     * @return La chaine de caractère du nom du Pokemon
     */
    public String getNom() {
        return this.m_nom;
    }

    /**
     * Renvoie le Type du Pokemon
     *
     * @return Le Type sous formes de chaine de caractère
     */
    public String getType() {
        return this.m_type.toString();
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
     * Renvoie la limite de PV du Pokemon
     *
     * @return Un entier correspondant aux PV maximum du Pokemon
     */
    public int getPvMAX() {
        return this.m_pvMAX;
    }

    /**
     * Renvoie les dégats qu'inflige le Pokemon
     *
     * @return Un entier correspondant aux dégats du Pokemon
     */
    public int getAttaque() {
        return this.m_attaque;
    }

    public void setPossedeAttaque(boolean bool){
        this.m_possedeAttaque=bool;
    }

    /**
     * Reécriture de toString pour une representation des Pokemons
     * La représentation inclut le nom, le type, les points de vie actuels et maximum, ainsi que les dégâts d'attaque.
     *
     * @return Une chaîne de caractères représentant le Pokémon.
     */
    @Override
    public String toString() {
        return this.m_nom + ": " + this.m_type + ", PV : " + this.m_pv + "/" + this.m_pvMAX + ", DMG: " + this.m_attaque;
    }

    /**
     * Retourne une représentation textuelle des Pokémon combattants sous forme de chaîne de caractères.
     * Chaque ligne représente un attribut des Pokémon (nom, type, PV, DMG) aligné avec les autres combattants.
     *
     * @param combattants La liste des Pokémon combattants.
     * @return Une chaîne de caractères représentant les Pokémon combattants.
     */
    public static String toStringCombat(ArrayList<Pokemon> combattants){
        String retour="";
        for (Pokemon p: combattants) {
            retour+=p.getNom()+"\t\t\t";
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            retour+="Type : "+p.getType()+"\t\t\t";
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            retour+="PV : "+p.getPv()+"/"+p.getPvMAX()+"\t\t\t";
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            retour+="DMG : "+p.getAttaque()+"\t\t\t";
        }
        return retour+"\n";
    }

    /**
     * Renvoie le Pokedex entier de la variable m_pokedex
     *
     * @return Une liste de Pokemon dans le Pokedex
     */
    public static ArrayList<Pokemon> getPokedex() {
        return m_pokedex;
    }
    public static void main(String args[]){
        String joueurActif;

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
            joueurActif="Joueur";
        }else {
            System.out.println("Vous jouerez en second.");
            joueur= new Deck(2);
            IA= new Deck(1);
            joueurActif="IA";
        }

        Tour T1 = new Tour(new Main(joueur), joueur, new Main(IA),IA, new Terrain(),joueurActif);
        T1.miseEnPlace();
    }
}