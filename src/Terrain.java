import java.util.ArrayList;

public class Terrain {
    private ArrayList<Pokemon> m_pokemonJoueur= new ArrayList<>();
    private ArrayList<Pokemon> m_pokemonIA= new ArrayList<>();

    public Terrain(){
    }

    public ArrayList<Pokemon> getPokemonJoueur() {
        return m_pokemonJoueur;
    }
    public ArrayList<Pokemon> getPokemonIA() {
        return m_pokemonIA;
    }

    public void ajoutPokemonJoueur(Main main, int indexMain){
        this.m_pokemonJoueur.add(main.getMain().get(indexMain));
        main.getMain().remove(indexMain);
    }

    public void ajoutPokemonIA(Main main){
        this.m_pokemonIA.add(main.getMain().get(0));
        main.getMain().remove(0);
    }

    @Override
    public String toString(){
        return "Camp adverse : \n"+
                Pokemon.toStringCombat(m_pokemonIA)+
                "\nVos pokémon en jeu : \n"
                +Pokemon.toStringCombat(m_pokemonJoueur)+"\n";
    }
}
