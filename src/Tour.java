import java.util.Scanner;

public class Tour {
    private String joueurActif;
    private Main m_mainJoueur;
    private Deck m_deckJoueur;
    private Main m_mainIA;
    private Deck m_deckIA;
    private Terrain m_terrain;

    public Tour(Main mainjoueur,Deck deckJoueur, Main mainIA,Deck deckIA, Terrain terrain,String actif){
        m_mainJoueur = mainjoueur;
        m_deckJoueur = deckJoueur;
        m_mainIA = mainIA;
        m_deckIA = deckIA;
        m_terrain = terrain;
        joueurActif = actif;
    }

    public void deroulementTour1(){
        if (joueurActif.equals("Joueur")) {

        }else {

        }
        this.affichage();
        this.affichage();
    }

    public void deroulementTour(){
        while(this.m_mainJoueur.getMain().size()<5&&!this.m_deckJoueur.estVide()){
            m_mainJoueur.pioche(m_deckJoueur);
        }
        while(this.m_mainIA.getMain().size()<5&&!this.m_deckIA.estVide()){
            m_mainIA.pioche(m_deckIA);
        }
        this.affichage();
    }
    public void demandeAjout(int nombre){
        System.out.println("Quel pokemon souhaitez vous Placer sur le terrain ? ("+nombre+" restants)");
        Scanner s = new Scanner(System.in);
        String choix = s.nextLine();
        if(this.m_mainJoueur.contient(choix)){
            this.m_terrain.ajoutPokemonJoueur(this.m_mainJoueur, this.m_mainJoueur.getIndex(choix));
        }
    }

    public void affichage(){
        System.out.println(this.m_terrain.toString()+this.m_mainJoueur.toString());
        while(joueurActif.equals("Joueur")&&this.m_terrain.getPokemonJoueur().size()<3){
            this.demandeAjout(3-this.m_terrain.getPokemonJoueur().size());
        }
        while(joueurActif.equals("IA")&&this.m_terrain.getPokemonIA().size()<3){
            this.m_terrain.ajoutPokemonIA(this.m_mainIA);
        }

    }

}
