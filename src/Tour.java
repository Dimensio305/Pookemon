public class Tour {
    private Main m_mainJoueur;
    private Main m_mainIA;
    private Terrain m_terrain;

    public Tour(Main joueur, Main IA, Terrain terrain){
        m_mainIA = IA;
        m_mainJoueur = joueur;
        m_terrain = terrain;
    }

    public void deroulementTour(){
        System.out.println(this.toString());
    }
    @Override
    public String toString(){
        return m_mainJoueur.toString();
    }

}
