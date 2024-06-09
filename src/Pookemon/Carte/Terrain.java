package Pookemon.Carte;

import Pookemon.DetailPokemon.Pokemon;

import java.util.ArrayList;

public class Terrain {
    private ArrayList<Pokemon> m_pokemonJoueur= new ArrayList<>();
    private ArrayList<Pokemon> m_pokemonIA= new ArrayList<>();

    /**
     * Constructeur par défaut de la classe Terrain.
     * Crée un terrain vide sans aucun Pokémon.
     */
    public Terrain(){
    }

    /**
     * Retourne la liste des Pokémon du joueur.
     *
     * @return La liste des Pokémon du joueur.
     */
    public ArrayList<Pokemon> getPokemonJoueur() {
        return m_pokemonJoueur;
    }

    /**
     * Retourne la liste des Pokémon de l'intelligence artificielle (IA).
     *
     * @return La liste des Pokémon de l'IA.
     */
    public ArrayList<Pokemon> getPokemonIA() {
        return m_pokemonIA;
    }

    /**
     * Ajoute un Pokémon de la main du joueur à son équipe de combat et retire ce Pokémon de la main.
     *
     * @param main     La main du joueur contenant le Pokémon à ajouter.
     * @param indexMain L'index du Pokémon dans la main du joueur.
     */
    public void ajoutPokemonJoueur(Main main, int indexMain){
        this.m_pokemonJoueur.add(main.getMain().get(indexMain));
        main.getMain().remove(indexMain);
    }

    /**
     * Ajoute un Pokémon de la main de l'IA à son équipe de combat et retire ce Pokémon de la main.
     *
     * @param main La main de l'IA contenant le Pokémon à ajouter.
     */
    public void ajoutPokemonIA(Main main){
        this.m_pokemonIA.add(main.getMain().get(0));
        main.getMain().remove(0);
    }

    /**
     * Retire un Pokémon de l'équipe de combat du joueur.
     *
     * @param index L'index du Pokémon à retirer de l'équipe du joueur.
     */
    public void retirePokemonJoueur(int index){
        this.m_pokemonJoueur.remove(index);
    }

    /**
     * Retire un Pokémon de l'équipe de combat de l'IA.
     *
     * @param index L'index du Pokémon à retirer de l'équipe de l'IA.
     */
    public void retirePokemonIA(int index){
        this.m_pokemonIA.remove(index);
    }

    /**
     * Vérifie si l'équipe de combat de l'IA contient un Pokémon avec le nom spécifié.
     *
     * @param nom Le nom du Pokémon à rechercher dans l'équipe de l'IA.
     * @return true si le Pokémon est trouvé, sinon false.
     */
    public boolean IAContient(String nom){
        for (Pokemon p: this.m_pokemonIA) {
            if (p.getNomComparable().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie si l'équipe de combat du joueur contient un Pokémon avec le nom spécifié.
     *
     * @param nom Le nom du Pokémon à rechercher dans l'équipe du joueur.
     * @return true si le Pokémon est trouvé, sinon false.
     */
    public boolean joueurContient(String nom){
        for (Pokemon p: this.m_pokemonJoueur) {
            if (p.getNomComparable().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retourne l'index du Pokémon avec le nom spécifié dans l'équipe de l'IA.
     *
     * @param nom Le nom du Pokémon à rechercher dans l'équipe de l'IA.
     * @return L'index du Pokémon s'il est trouvé, sinon -1.
     */
    public int getIndexIA(String nom){
        for (int i = 0; i <this.m_pokemonIA.size() ; i++) {
            if(this.m_pokemonIA.get(i).getNomComparable().equalsIgnoreCase(nom)){
                return i;
            }
        }
        return -1;//ne dois jamais avoir lieu (on dois ajouter un trycatch)
    }

    /**
     * Retourne l'index du Pokémon avec le nom spécifié dans l'équipe du joueur.
     *
     * @param nom Le nom du Pokémon à rechercher dans l'équipe du joueur.
     * @return L'index du Pokémon s'il est trouvé, sinon -1.
     */
    public int getIndexJoueur(String nom){
        for (int i = 0; i <this.m_pokemonJoueur.size() ; i++) {
            if(this.m_pokemonJoueur.get(i).getNomComparable().equalsIgnoreCase(nom)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Ajoute un Pokémon à l'équipe de l'IA sans retirer de Pokémon de la main.
     * Utilisé pour l'initialisation de l'équipe de l'IA.
     *
     * @param pokemon Le Pokémon à ajouter à l'équipe de l'IA.
     */
    public void ajoutDeForceIA(Pokemon pokemon){
        this.m_pokemonIA.add(pokemon);
    }

    /**
     * Ajoute un Pokémon à l'équipe du joueur sans retirer de Pokémon de la main.
     * Utilisé pour l'initialisation de l'équipe du joueur.
     *
     * @param pokemon Le Pokémon à ajouter à l'équipe du joueur.
     */
    public void ajoutDeForceJoueur(Pokemon pokemon){
        this.m_pokemonJoueur.add(pokemon);
    }
}
