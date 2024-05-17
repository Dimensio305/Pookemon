import jdk.jshell.Snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {
    private static ArrayList<Pokemon> m_pokedex = new ArrayList<>();
    private static ArrayList<String> m_nomPokemon = new ArrayList<>(Arrays.asList("Bulbizarre", "Herbizarre", "Florizarre", "Salamèche", "Reptincel", "Dracaufeu", "Carapuce", "Carabaffe", "Tortank", "Chenipan", "Chrysacier", "Papilusion", "Aspicot", "Coconfort", "Dardargnan", "Roucool", "Roucoups", "Roucarnage", "Rattata", "Rattatac", "Piafabec", "Rapasdepic", "Abo", "Arbok", "Pikachu", "Raichu", "Sabelette", "Sablaireau", "Nidoran♀", "Nidorina", "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Mélofée", "Mélodelfe", "Goupix", "Feunard", "Rondoudou", "Grodoudou", "Nosferapti", "Nosferalto", "Mystherbe", "Ortide", "Rafflesia", "Paras", "Parasect", "Mimitoss", "Aéromite", "Taupiqueur", "Triopikeur", "Miaouss", "Persian", "Psykokwak", "Akwakwak", "Férosinge", "Colossinge", "Caninos", "Arcanin", "Ptitard", "Têtarte", "Tartard", "Abra", "Kadabra", "Alakazam", "Machoc", "Machopeur", "Mackogneur", "Chétiflor", "Boustiflor", "Empiflor", "Tentacool", "Tentacruel", "Racaillou", "Gravalanch", "Grolem", "Ponyta", "Galopa", "Ramoloss", "Flagadoss", "Magnéti", "Magnéton", "Canarticho", "Doduo", "Dodrio", "Otaria", "Lamantine", "Tadmorv", "Grotadmorv", "Kokiyas", "Crustabri", "Fantominus", "Spectrum", "Ectoplasma", "Onix", "Soporifik", "Hypnomade", "Krabby", "Krabboss", "Voltorbe", "Électrode", "Noeunoeuf", "Noadkoko", "Osselait", "Ossatueur", "Kicklee", "Tygnon", "Excelangue", "Smogo", "Smogogo", "Rhinocorne", "Rhinoféros", "Leveinard", "Saquedeneu", "Kangourex", "Hypotrempe", "Hypocéan", "Poissirène", "Poissoroy", "Stari", "Staross", "M.Mime", "Insécateur", "Lippoutou", "Élektek", "Magmar", "Scarabrute", "Tauros", "Magicarpe", "Léviator", "Lokhlass", "Métamorph", "Évoli", "Aquali", "Voltali", "Pyroli", "Porygon", "Amonita", "Amonistar", "Kabuto", "Kabutops", "Ptéra", "Ronflex", "Artikodin", "Électhor", "Sulfura", "Minidraco", "Draco", "Dracolosse", "Mewtwo", "Mew"));
    private String m_nom;
    private Type m_type;
    private int m_pvMAX;
    private int m_pv;
    private int m_attaque;

    private boolean m_shiny;

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
        m_shiny = new Random().nextInt(1, 65)==1;
        m_pokedex.add(this);
    }

    /**
     * Renvoie le nom du Pokemon
     *
     * @return La chaine de caractère du nom du Pokemon
     */
    public String getNom() {
        if(this.isM_shiny()){return "\u001B[93m"+this.m_nom +" \u001B[0m";}
        else{return this.m_nom;}
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

    public boolean isM_shiny(){
        return m_shiny;
    }

    public void setPossedeAttaque(boolean bool){
        this.m_possedeAttaque=bool;
    }

    public boolean isPossedeAttaque(){
        return m_possedeAttaque;
    }

    /**
     * Reécriture de toString pour une representation des Pokemons
     * La représentation inclut le nom, le type, les points de vie actuels et maximum, ainsi que les dégâts d'attaque.
     *
     * @return Une chaîne de caractères représentant le Pokémon.
     */
    @Override
    public String toString() {
        return this.getNom() + ": " + this.getType() + ", PV : " + this.getPv() + "/" + this.getPvMAX() + ", DMG: " + this.getAttaque();
    }

    public void subitDegat(int dmg, Type type){
        int affinite = this.affiniteType(type);
        switch (affinite){
            case -1:
                this.m_pv-= (dmg-10);
                break;
            case 0:
                this.m_pv-= dmg;
                break;
            case 1:
                this.m_pv-= (dmg+10);
        }

    }

    public int affiniteType(Type type){
        switch (this.m_type){
            case FEE :
                if (type.equals(Type.POISON)||type.equals(Type.ACIER)){
                    return 1;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.DRAGON)||type.equals(Type.INSECTE)||type.equals(Type.TENEBRE)) {
                    return -1;
                }
                return 0;
            case ACIER:
                if (type.equals(Type.COMBAT)||type.equals(Type.FEU)||type.equals(Type.SOL)){
                    return 1;
                } else if (type.equals(Type.ACIER)||type.equals(Type.DRAGON)||type.equals(Type.FEE)||type.equals(Type.GLACE)
                        ||type.equals(Type.INSECTE)||type.equals(Type.NORMAL)||type.equals(Type.PLANTE)||type.equals(Type.POISON)
                        ||type.equals(Type.PSY)||type.equals(Type.ROCHE)||type.equals(Type.VOL)) {
                    return -1;
                }
                return 0;
            case COMBAT:
                if (type.equals(Type.FEE)||type.equals(Type.PSY)||type.equals(Type.VOL)){
                    return 1;
                } else if (type.equals(Type.INSECTE)||type.equals(Type.ROCHE)||type.equals(Type.TENEBRE)) {
                    return -1;
                }
                return 0;
            case DRAGON:
                if (type.equals(Type.DRAGON)||type.equals(Type.FEE)||type.equals(Type.GLACE)){
                    return 1;
                } else if (type.equals(Type.EAU)||type.equals(Type.ELECTRIQUE)||type.equals(Type.FEU)||type.equals(Type.PLANTE)) {
                    return -1;
                }
                return 0;
            case EAU:
                if (type.equals(Type.PLANTE)||type.equals(Type.ELECTRIQUE)){
                    return 1;
                } else if (type.equals(Type.ACIER)||type.equals(Type.EAU)||type.equals(Type.FEU)||type.equals(Type.GLACE)) {
                    return -1;
                }
                return 0;
            case ELECTRIQUE:
                if (type.equals(Type.SOL)){
                    return 1;
                } else if (type.equals(Type.ACIER)||type.equals(Type.ELECTRIQUE)||type.equals(Type.VOL)) {
                    return -1;
                }
                return 0;
            case FEU:
                if (type.equals(Type.EAU)||type.equals(Type.ROCHE)||type.equals(Type.SOL)){
                    return 1;
                } else if (type.equals(Type.ACIER)||type.equals(Type.FEE)||type.equals(Type.FEU)||type.equals(Type.GLACE)
                        ||type.equals(Type.INSECTE)||type.equals(Type.PLANTE)) {
                    return -1;
                }
                return 0;
            case GLACE:
                if (type.equals(Type.ACIER)||type.equals(Type.COMBAT)||type.equals(Type.FEU)||type.equals(Type.ROCHE)){
                    return 1;
                } else if (type.equals(Type.GLACE)) {
                    return -1;
                }
                return 0;
            case INSECTE:
                if (type.equals(Type.FEU)||type.equals(Type.ROCHE)||type.equals(Type.VOL)){
                    return 1;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.PLANTE)||type.equals(Type.SOL)) {
                    return -1;
                }
                return 0;
            case NORMAL:
                if (type.equals(Type.COMBAT)){
                    return 1;
                } else if (type.equals(Type.SPECTRE)) {
                    return -1;
                }
                return 0;
            case PLANTE:
                if (type.equals(Type.FEU)||type.equals(Type.GLACE)||type.equals(Type.INSECTE)||type.equals(Type.POISON)||type.equals(Type.VOL)){
                    return 1;
                } else if (type.equals(Type.EAU)||type.equals(Type.ELECTRIQUE)||type.equals(Type.PLANTE)||type.equals(Type.SOL)) {
                    return -1;
                }
                return 0;
            case POISON:
                if (type.equals(Type.PSY)||type.equals(Type.SOL)){
                    return 1;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.FEE)||type.equals(Type.INSECTE)||type.equals(Type.PLANTE)||type.equals(Type.POISON)) {
                    return -1;
                }
                return 0;
            case PSY:
                if (type.equals(Type.INSECTE)||type.equals(Type.SPECTRE)||type.equals(Type.TENEBRE)){
                    return 1;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.PSY)) {
                    return -1;
                }
                return 0;
            case ROCHE:
                if (type.equals(Type.ACIER)||type.equals(Type.COMBAT)||type.equals(Type.EAU)||type.equals(Type.PLANTE)||type.equals(Type.SOL)){
                    return 1;
                } else if (type.equals(Type.FEU)||type.equals(Type.NORMAL)||type.equals(Type.POISON)||type.equals(Type.VOL)) {
                    return -1;
                }
                return 0;
            case SOL:
                if (type.equals(Type.EAU)||type.equals(Type.GLACE)||type.equals(Type.PLANTE)){
                    return 1;
                }else if (type.equals(Type.ELECTRIQUE)||type.equals(Type.POISON)||type.equals(Type.ROCHE)) {
                    return -1;
                }
                return 0;
            case SPECTRE:
                if (type.equals(Type.SPECTRE)||type.equals(Type.TENEBRE)){
                    return 1;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.NORMAL)||type.equals(Type.INSECTE)||type.equals(Type.POISON)) {
                    return -1;
                }
                return 0;
            case TENEBRE:
                if (type.equals(Type.COMBAT)||type.equals(Type.FEE)||type.equals(Type.INSECTE)){
                    return 1;
                } else if (type.equals(Type.PSY)||type.equals(Type.SPECTRE)||type.equals(Type.TENEBRE)) {
                    return -1;
                }
                return 0;
            case VOL:
                if (type.equals(Type.ELECTRIQUE)||type.equals(Type.GLACE)||type.equals(Type.ROCHE)){
                    return 1;
                } else if (type.equals(Type.COMBAT)||type.equals(Type.INSECTE)||type.equals(Type.PLANTE)||type.equals(Type.SOL)) {
                    return -1;
                }
                return 0;
            default:
                return 0;
        }
    }

    public boolean estMort(){
        if (this.m_pv<1){
            return true;
        }
        return false;
    };

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
            if(p.isM_shiny()) {
                retour += "\u001B[93m";
                retour += String.format("\t/-*-*-*-*-*-*-*-*-*-*-\\\t", p.getNom());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t+---------------------+\t", p.getNom());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\t%-27s\u001B[93m|\t", p.getNom());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t|\t%-18s|\t", p.getNom());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if (p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\tTYPE : %-11s|\t", p.getType());
                retour += "\u001B[0m";
            } else {
                retour += String.format("\t|\tTYPE : %-11s|\t", p.getType());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\tPV : %-3s/%-9s|\t", p.getPv(), p.getPvMAX());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t|\tPV : %-3s/%-9s|\t", p.getPv(), p.getPvMAX());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t|\tDMG : %-12s|\t", p.getAttaque());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t|\tDMG : %-12s|\t", p.getAttaque());
            }
        }
        retour+="\n";
        for (Pokemon p: combattants) {
            if(p.isM_shiny()) {
                retour += "\u001B[93m ";
                retour += String.format("\t\\-*-*-*-*-*-*-*-*-*-*-/\t", p.getNom());
                retour += "\u001B[0m";
            }else {
                retour += String.format("\t+---------------------+\t", p.getNom());
            }
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
        //System.out.println("Choississez le type de votre deck (ou aléatoire pour un deck non-typé):");
        Deck joueur;
        Deck IA;
        if(new Random().nextBoolean()){
            System.out.println("Vous commencerez la partie ! Choisissez vos pokemon a mettre sur le terrain");
            joueur= new Deck(1);
            IA= new Deck(2);
            joueurActif="Joueur";
        }else {
            System.out.println("Vous jouerez en second.");
            new Scanner(System.in).nextLine();
            joueur= new Deck(2);
            IA= new Deck(1);
            joueurActif="IA";
        }

        Tour T1 = new Tour(new Main(joueur), joueur, new Main(IA),IA, new Terrain(),joueurActif);
        T1.miseEnPlace();
    }
}