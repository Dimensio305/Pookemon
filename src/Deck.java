import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private static ArrayList<Integer> m_doublon= new ArrayList<>();

    private ArrayList<Pokemon> m_pile= new ArrayList<>();
    private ArrayList<Pokemon> m_defausse = new ArrayList<>();


    /**
     *
     */
    public Deck(int joueur){
        m_doublon.add(-1);
        for (int i = 0; this.m_pile.size()<(19+joueur);i++) {
            int index = new Random().nextInt(Pokemon.getPokedex().size());
            if (!m_doublon.contains(index)) {
                m_doublon.add(index);
                m_pile.add(Pokemon.getPokedex().get(index));
                index = -1;
            }
        }
    }

    public ArrayList<Pokemon> getPile()
    {
        return this.m_pile;
    }

    public void estTire(int index){
        this.m_pile.remove(index);
    }

    public boolean estVide()
    {
        return this.m_pile.size()>0;
    }
}
