package Pookemon.DetailPokemon;

public class Boost {

    private String m_nom;
    private boolean m_Attaque;
    private int m_valeur;
    private boolean m_dureeInfini;

    /**
     * Constructeur de la classe Boost.
     *
     * @param nom Le nom du boost.
     * @param isAttaque Indique si le boost concerne une attaque (true) ou une défense (false).
     * @param valeur La valeur du boost.
     * @param dureeInfini Indique si la durée du boost est infinie (true) ou non (false).
     */
    public Boost(String nom, boolean isAttaque, int valeur, boolean dureeInfini){
        m_dureeInfini = dureeInfini;
        m_nom = nom;
        m_valeur = valeur;
        m_Attaque = isAttaque;
    }

    /**
     * Méthode pour vérifier si le boost concerne une attaque.
     *
     * @return true si le boost concerne une attaque, sinon false.
     */
    public boolean isAttaque() {
        return this.m_Attaque;
    }

    /**
     * Méthode pour obtenir la valeur du boost.
     *
     * @return La valeur du boost.
     */
    public int getValeur() {
        return this.m_valeur;
    }

    /**
     * Méthode pour vérifier si la durée du boost est infinie.
     *
     * @return true si la durée du boost est infinie, sinon false.
     */
    public boolean isDureeInfini() {
        return this.m_dureeInfini;
    }
}
