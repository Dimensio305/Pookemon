import java.util.ArrayList;
import java.util.Random;

public class Main {
    private ArrayList<Pokemon> m_pokemonMain= new ArrayList<>();

    public Main(Deck deck){
        for (int i = 0; i < 5; i++) {
            int index = new Random().nextInt(deck.getPile().size());
            m_pokemonMain.add(deck.getPile().get(index));
            deck.estTire(index);
        }
    }

    public ArrayList<Pokemon> getMain(){

        return this.m_pokemonMain;
    }

    public int getIndex(String nom){
        for (int i = 0; i <this.m_pokemonMain.size() ; i++) {
            if(this.m_pokemonMain.get(i).getNom().equals(nom)){
                return i;
            }
        }
        return -1;//ne dois jamais avoir lieu (on dois ajouter un trycatch)
    }

    public boolean contient(String nom){
        for (Pokemon p: this.m_pokemonMain) {
            if (p.getNom().equals(nom)){
                return true;
            }
        }
        return false;
    }

    public void pioche(Deck deck){
        int index = new Random().nextInt(deck.getPile().size());
        m_pokemonMain.add(deck.getPile().get(index));
        deck.estTire(index);
    }

    @Override
    public String toString(){
        String enMain ="En main :";
        for (Pokemon p: this.m_pokemonMain) {
            enMain+= "\n -" +p.toString();
        }
        return enMain;
    }
}