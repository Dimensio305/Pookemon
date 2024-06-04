package Pookemon.Personnage;

import Pookemon.Carte.Deck;
import Pookemon.Carte.Terrain;
import Pookemon.Deroulement.Affichage;
import Pookemon.DetailPokemon.Pokemon;

import java.util.Scanner;

public class Humain extends Joueur {

    public Humain(Deck deck) {
        super(deck);
    }

    @Override
    public void pokemonEnterre(Pokemon victime, Terrain sceneDuCrime) {
        sceneDuCrime.retirePokemonJoueur(sceneDuCrime.getIndexJoueur(victime.getNomComparable()));
    }

    @Override
    public void pokemonDeuil(Pokemon victime, Terrain sceneDuCrime) {
        sceneDuCrime.retirePokemonJoueur(sceneDuCrime.getIndexJoueur(victime.getNomComparable()));

    }

    public void ajoutPokemon(Terrain terrain){
        Scanner s = new Scanner(System.in);
        String choix = s.nextLine();
        if(this.getM_main().contient(choix)) {
            terrain.ajoutPokemonJoueur(this.getM_main(), this.getM_main().getIndex(choix));
        }
        switch (choix){
            case "1":
                terrain.ajoutPokemonJoueur(this.getM_main(), 0);
                break;
            case "2":
                if(this.getMainListe().size()>1){terrain.ajoutPokemonJoueur(this.getM_main(),1);}
                break;
            case "3":
                if(this.getMainListe().size()>2){terrain.ajoutPokemonJoueur(this.getM_main(),2);}
                break;
            case "4":
                if(this.getMainListe().size()>3){terrain.ajoutPokemonJoueur(this.getM_main(),3);}
                break;
            case "5":
                if(this.getMainListe().size()>4){terrain.ajoutPokemonJoueur(this.getM_main(),4);}
                break;
        }
    }

    @Override
    public boolean actionDuTour(Terrain terrain, Joueur adversaire) {
        String action = "";
        String cible = "-1";
        Scanner s= new Scanner(System.in);
        Affichage print = new Affichage();

        print.questionAction(1);
        Boolean actionPossible = false;
        Boolean pouvoirUtilisable = false;
        for (Pokemon p : terrain.getPokemonJoueur()) {
            if (p.isPossedeAttaque()) {
                actionPossible = true;
            }
            if (p.getM_pouvoir()!=null &&p.getM_pouvoir().utilisable()){
                pouvoirUtilisable = true;
            }
        }
        if (actionPossible) {
            print.questionAction(2);
        }
        if (pouvoirUtilisable){
            print.questionAction(3);
        }
        action = s.nextLine();
        if (action.equals("fin")||action.equals("1")){
            return false;
        }
        if (actionPossible&&action.equals("2") || action.equals("atk")) {
            print.questionAction(2, terrain);
            action = s.nextLine();

            if ((action.equals("1") && terrain.getPokemonJoueur().get(0).isPossedeAttaque())
                    || (action.equals("2") && terrain.getPokemonJoueur().get(1).isPossedeAttaque())
                    || (action.equals("3") && terrain.getPokemonJoueur().get(2).isPossedeAttaque())) {

                print.demandeCibleAdverse(terrain);
                cible = s.nextLine();
                if ((cible.equals("1") || cible.equals("2") || cible.equals("3"))&&
                        (Integer.parseInt(cible) <= terrain.getPokemonIA().size() && Integer.valueOf(cible) >= 0)) {
                        terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).subitDegat(terrain.getPokemonJoueur()
                                .get(Integer.parseInt(action) - 1).getAttaque(), terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getType(),adversaire, terrain);
                        terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).setPossedeAttaque(false);

                }
            }
            action ="";
        }
        if (pouvoirUtilisable&&action.equals("3")|| action.equals("pov")){
            print.questionAction(3, terrain);
            action = s.nextLine();

            if ((action.equals("1") && terrain.getPokemonJoueur().get(0).getM_pouvoir()!= null && terrain.getPokemonJoueur().get(0).getM_pouvoir().utilisable())
                    || (action.equals("2") && terrain.getPokemonJoueur().get(1).getM_pouvoir()!= null && terrain.getPokemonJoueur().get(1).getM_pouvoir().utilisable())
                    || (action.equals("3") && terrain.getPokemonJoueur().get(2).getM_pouvoir()!= null && terrain.getPokemonJoueur().get(2).getM_pouvoir().utilisable())) {
                if(terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).getM_pouvoir().cibleAdversaire()){
                    print.demandeCibleAdverse(terrain);
                    cible = s.nextLine();
                    if ((cible.equals("1") || cible.equals("2") || cible.equals("3"))&&
                            (Integer.parseInt(cible) <= terrain.getPokemonIA().size() && Integer.valueOf(cible) >= 0)) {
                        terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).getM_pouvoir().onUse(terrain.getPokemonJoueur().get(Integer.parseInt(action)-1), terrain.getPokemonIA().get(Integer.valueOf(cible) - 1), terrain);
                    }
                }else {
                    print.demandeCibleHumain(terrain);
                    cible = s.nextLine();
                    if ((cible.equals("1") || cible.equals("2") || cible.equals("3"))&&
                            (Integer.parseInt(cible) <= terrain.getPokemonJoueur().size() && Integer.valueOf(cible) >= 0)) {
                        terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).getM_pouvoir().onUse(terrain.getPokemonJoueur().get(Integer.parseInt(action)-1), terrain.getPokemonJoueur().get(Integer.valueOf(cible) - 1), terrain);
                    }
                }
            }
        }
        return true;
    }
}
