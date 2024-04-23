import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Pokemon> m_pile= new ArrayList<>();

    /**
     *
     */
    public Deck(int joueur){
        ArrayList<Integer> doublon= new ArrayList<>();
        doublon.add(-1);
        for (int i = 0; this.m_pile.size()<(19+joueur);i++) {
            int index = new Random().nextInt(Pokemon.getPokedex().size());
            if (!doublon.contains(index)) {
                m_pile.add(Pokemon.getPokedex().get(index));
                index = -1;
            }
        }
    }

    public ArrayList<Pokemon> getPile(){
        return m_pile;
    }
}
