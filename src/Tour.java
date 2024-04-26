import java.util.Scanner;

public class Tour {
    private String joueurActif;
    private Main m_mainJoueur;
    private Deck m_deckJoueur;
    private Main m_mainIA;
    private Deck m_deckIA;
    private Terrain m_terrain;

    /**
     * Constructeur de la classe Tour.
     * Initialise un tour de jeu avec les éléments nécessaires : main du joueur, deck du joueur, main de l'IA,
     * deck de l'IA, terrain et joueur actif.
     *
     * @param mainjoueur La main du joueur.
     * @param deckJoueur Le deck du joueur.
     * @param mainIA     La main de l'IA.
     * @param deckIA     Le deck de l'IA.
     * @param terrain    Le terrain de jeu.
     * @param actif      Le joueur actif ("Joueur" ou "IA").
     */
    public Tour(Main mainjoueur,Deck deckJoueur, Main mainIA,Deck deckIA, Terrain terrain,String actif){
        m_mainJoueur = mainjoueur;
        m_deckJoueur = deckJoueur;
        m_mainIA = mainIA;
        m_deckIA = deckIA;
        m_terrain = terrain;
        joueurActif = actif;
    }

    /**
     * Fait jouer la première phase du tour de jeu.
     * Si c'est au tour du joueur, effectue ses actions, sinon, effectue les actions de l'IA.
     * Affiche l'état actuel du jeu deux fois.
     */
    public void deroulementTour1(){
        if (joueurActif.equals("Joueur")) {

        }else {

        }
        this.affichage();
        this.affichage();
    }

    /**
     * Fait jouer le tour de jeu.
     * Les joueurs piochent des cartes si nécessaire et l'état du jeu est affiché.
     */
    public void deroulementTour(){
        while(this.m_mainJoueur.getMain().size()<5&&!this.m_deckJoueur.estVide()){
            m_mainJoueur.pioche(m_deckJoueur);
        }
        while(this.m_mainIA.getMain().size()<5&&!this.m_deckIA.estVide()){
            m_mainIA.pioche(m_deckIA);
        }
        this.affichage();
    }
    /**
     * Demande au joueur d'ajouter un Pokémon sur le terrain.
     * Le nombre de pokémon restants à ajouter est passé en paramètre.
     *
     * @param nombre Le nombre de pokémon restants à ajouter.
     */
    public void demandeAjout(int nombre){
        System.out.println("Quel pokemon souhaitez vous Placer sur le terrain ? ("+nombre+" restants)");
        Scanner s = new Scanner(System.in);
        String choix = s.nextLine();
        if(this.m_mainJoueur.contient(choix)){
            this.m_terrain.ajoutPokemonJoueur(this.m_mainJoueur, this.m_mainJoueur.getIndex(choix));
        }
    }

    /**
     * Affiche l'état actuel du jeu, comprenant le terrain et les mains des joueurs.
     * Si c'est au tour du joueur et qu'il n'a pas assez de Pokémon sur le terrain, demande d'ajouter des Pokémon.
     * Si c'est au tour de l'IA et qu'elle n'a pas assez de Pokémon sur le terrain, ajoute automatiquement des Pokémon.
     */
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
