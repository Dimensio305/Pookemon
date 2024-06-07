package Pookemon.DetailPokemon;

public class Boost {

    private String m_nom;
    private boolean m_Attaque;
    private int m_valeur;
    private boolean m_dureeInfini;

    public Boost(String nom, boolean isAttaque, int valeur, boolean dureeInfini){
        m_dureeInfini = dureeInfini;
        m_nom = nom;
        m_valeur = valeur;
        m_Attaque = isAttaque;
    }

    public boolean isAttaque() {
        return this.m_Attaque;
    }

    public int getValeur() {
        return this.m_valeur;
    }

    public boolean isDureeInfini() {
        return this.m_dureeInfini;
    }
}
