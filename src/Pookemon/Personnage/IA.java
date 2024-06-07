package Pookemon.Personnage;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class IA extends Joueur{

    public IA(Deck deck){
        super(deck);
    }

    @Override
    public void pokemonDeuil(Pokemon victime, Terrain sceneDuCrime) {
        sceneDuCrime.retirePokemonIA(sceneDuCrime.getIndexIA(victime.getNomComparable()));

    }

    @Override
    public boolean actionDuTour(Terrain terrain, Joueur adversaire) {
        Affichage print = new Affichage();
        Scanner s = new Scanner(System.in);
        for(Pokemon p: terrain.getPokemonIA()){
            if(p.isPossedeAttaque()) {
                int i = 0;
                List<Pokemon> ciblePossible = new ArrayList<>();
                int cibleIndex;
                while (i < terrain.getPokemonJoueur().size()) {
                    if (terrain.getPokemonJoueur().get(i).affiniteType(p.getType()) == 1) {
                        ciblePossible.add(terrain.getPokemonJoueur().get(i));
                    }
                    i++;
                }
                i=0;
                if (ciblePossible.size() == 1) {
                    ciblePossible.get(0).subitDegat(p.getAttaque(), p.getType(),adversaire, terrain);
                    print.affichageTerrain(terrain);
                    print.attaqueIA(p, ciblePossible.get(0));
                    s.nextLine();
                } else if (ciblePossible.size() > 1) {
                    int pvMin = 1000;
                    for (Pokemon cible : ciblePossible) {
                        if (pvMin > cible.getPv()) {
                            pvMin = cible.getPv();
                        }
                    }
                    List<Pokemon> cibleImpossible = new ArrayList<>();
                    for (Pokemon cible : ciblePossible) {
                        if (pvMin != cible.getPv()) {

                            cibleImpossible.add(cible);
                        }
                    }
                    for (Pokemon pasCible: cibleImpossible) {
                        ciblePossible.remove(pasCible);
                    }
                    if (ciblePossible.size() == 1) {
                        ciblePossible.get(0).subitDegat(p.getAttaque(), p.getType(),adversaire, terrain);
                        print.affichageTerrain(terrain);
                        print.attaqueIA(p, ciblePossible.get(0));
                        s.nextLine();
                    } else {
                        cibleIndex =new Random().nextInt(0, ciblePossible.size());
                        ciblePossible.get(cibleIndex).subitDegat(p.getAttaque(), p.getType(),adversaire, terrain);
                        print.affichageTerrain(terrain);
                        print.attaqueIA(p, ciblePossible.get(cibleIndex));
                        s.nextLine();
                    }
                } else {
                    int pvMin = 1000;
                    while (i < terrain.getPokemonJoueur().size()) {
                        if (pvMin > terrain.getPokemonJoueur().get(i).getPv()) {
                            pvMin = terrain.getPokemonJoueur().get(i).getPv();
                        }
                        i++;
                    }
                    i=0;
                    while (i < terrain.getPokemonJoueur().size()) {
                        if (pvMin == terrain.getPokemonJoueur().get(i).getPv()) {
                            ciblePossible.add(terrain.getPokemonJoueur().get(i));
                        }
                        i++;
                    }
                    i=0;
                    if (ciblePossible.size() == 1) {
                        ciblePossible.get(0).subitDegat(p.getAttaque(), p.getType(),adversaire, terrain);
                        print.affichageTerrain(terrain);
                        print.attaqueIA(p,ciblePossible.get(0));
                        s.nextLine();
                    } else {
                        if(terrain.getPokemonJoueur().size()!=0) {
                            cibleIndex = new Random().nextInt(0, ciblePossible.size());
                            ciblePossible.get(cibleIndex).subitDegat(p.getAttaque(), p.getType(), adversaire, terrain);
                            print.affichageTerrain(terrain);
                            print.attaqueIA(p, ciblePossible.get(cibleIndex));
                            s.nextLine();
                        }
                    }
                }
            }
        }
        if(this.victoireAdversaire(terrain)||adversaire.victoireAdversaire(terrain)){
            print.finJeu(this.victoireAdversaire(terrain));
            System.exit(0);
        }
        return true;
    }

    @Override
    public boolean victoireAdversaire(Terrain terrain){
        if (this.m_deck.estVide()&&this.m_main.getMain().size()==0&&terrain.getPokemonIA().size()==0){
            return true;
        }
        return false;
    }
}
