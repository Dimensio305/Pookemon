package Pookemon.Carte;

import Pookemon.DetailPokemon.Pokemon;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private ArrayList<Pokemon> m_pokemonMain= new ArrayList<>();

    /**
     * Constructeur de la classe Main.
     * Initialise la main avec 5 cartes Pokémon tirées aléatoirement à partir du deck spécifié.
     *
     * @param deck Le deck à partir duquel les cartes Pokémon sont tirées pour initialiser la main.
     */
    public Main(Deck deck){
        for (int i = 0; i < 5; i++) {
            int index = new Random().nextInt(deck.getPile().size());
            m_pokemonMain.add(deck.getPile().get(index));
            deck.estTire(index);
        }
    }

    /**
     * Retourne la liste des cartes Pokémon dans la main.
     *
     * @return La liste des cartes Pokémon dans la main.
     */
    public ArrayList<Pokemon> getMain(){

        return this.m_pokemonMain;
    }

    /**
     * Retourne l'index de la carte Pokémon avec le nom spécifié dans la main.
     *
     * @param nom Le nom de la carte Pokémon à rechercher dans la main.
     * @return L'index de la carte Pokémon s'il est trouvé, sinon -1.
     */
    public int getIndex(String nom){
        for (int i = 0; i <this.m_pokemonMain.size() ; i++) {
            if(this.m_pokemonMain.get(i).getNom().equalsIgnoreCase(nom)){
                return i;
            }
        }
        return -1;//ne dois jamais avoir lieu (on dois ajouter un trycatch)
    }

    /**
     * Vérifie si la main contient une carte Pokémon avec le nom spécifié.
     *
     * @param nom Le nom de la carte Pokémon à rechercher dans la main.
     * @return true si la carte est trouvée, sinon false.
     */
    public boolean contient(String nom){
        for (Pokemon p: this.m_pokemonMain) {
            if (p.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }

    /**
     * Effectue une pioche depuis le deck spécifié et ajoute la carte Pokémon piochée à la main.
     * La carte piochée est retirée du deck.
     *
     * @param deck Le deck à partir duquel la carte Pokémon est piochée.
     */
    public void pioche(Deck deck){
        if(!deck.estVide()){
            int index = new Random().nextInt(deck.getPile().size());
            m_pokemonMain.add(deck.getPile().get(index));
            deck.estTire(index);
        }
    }

    /**
     * Retourne une représentation textuelle de la main, indiquant chaque carte Pokémon présente.
     *
     * @return Une chaîne de caractères représentant les cartes Pokémon dans la main.
     */
    @Override
    public String toString(){
        int numMain=1;
        String enMain ="En main :";
        for (Pokemon p: this.m_pokemonMain) {
            enMain+= "\n   "+numMain+": " + p.toString();
            numMain++;
        }
        return enMain;
    }
}