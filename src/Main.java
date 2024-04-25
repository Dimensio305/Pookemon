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

    @Override
    public String toString(){
        String enMain ="En main :";
        for (Pokemon p: this.m_pokemonMain) {
            enMain+= "\n -" +p.toString();
        }
        return enMain;
    }
}