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

    public void retirePokemonJoueur(int index){
        this.m_pokemonJoueur.remove(index);
    }

    public void retirePokemonIA(int index){
        this.m_pokemonIA.remove(index);
    }

    public boolean IAContient(String nom){
        for (Pokemon p: this.m_pokemonIA) {
            if (p.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    public boolean joueurContient(String nom){
        for (Pokemon p: this.m_pokemonJoueur) {
            if (p.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    public int getIndexIA(String nom){
        for (int i = 0; i <this.m_pokemonIA.size() ; i++) {
            if(this.m_pokemonIA.get(i).getNom().equalsIgnoreCase(nom)){
                return i;
            }
        }
        return -1;//ne dois jamais avoir lieu (on dois ajouter un trycatch)
    }

    public int getIndexJoueur(String nom){
        for (int i = 0; i <this.m_pokemonJoueur.size() ; i++) {
            if(this.m_pokemonJoueur.get(i).getNom().equalsIgnoreCase(nom)){
                return i;
            }
        }
        return -1;//ne dois jamais avoir lieu (on dois ajouter un trycatch)
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

    public String toStringAdversraire() {
        return "Camp adverse : \n" +
                Pokemon.toStringCombat(m_pokemonIA);
    }
}
