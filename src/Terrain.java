import java.util.ArrayList;

public class Terrain {
    private ArrayList<Pokemon> m_pokemonJoueur= new ArrayList<>();
    private ArrayList<Pokemon> m_pokemonIA= new ArrayList<>();

    /**
     * Constructeur pour que le terrain soit vide
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
     * Reécriture de toString pour une representation du terrains
     *
     * @return Une chaîne de caractères représentant le terrain.
     */
    @Override
    public String toString(){
        return "Camp adverse : \n"+
                Pokemon.toStringCombat(m_pokemonIA)+
                "\nVos pokémon en jeu : \n"
                +Pokemon.toStringCombat(m_pokemonJoueur)+"\n";
    }
}
