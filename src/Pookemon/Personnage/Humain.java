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
        for (Pokemon p : terrain.getPokemonJoueur()) {
            if (p.isPossedeAttaque()) {
                actionPossible = true;
            }
        }
        if (actionPossible) {
            print.questionAction(2);
        }
        action = s.nextLine();
        if (action.equals("fin")||action.equals("1")){
            return false;
        }
        if (actionPossible) {
            if (action.equals("2") || action.equals("atk")) {
                print.questionAction(3, terrain);
                action = s.nextLine();

                if (terrain.joueurContient(action)&&terrain.getPokemonJoueur().get(terrain.getIndexJoueur(action)).isPossedeAttaque()) {
                    print.demandeCibleAdverse(terrain);
                    cible = s.nextLine();
                    if (terrain.IAContient(cible)) {
                        terrain.getPokemonIA().get(terrain.getIndexIA(cible)).subitDegat(terrain.getPokemonJoueur()
                                .get(terrain.getIndexJoueur(action)).getAttaque(), terrain.getPokemonJoueur().get(terrain.getIndexJoueur(action)).getType());
                        terrain.getPokemonJoueur().get(terrain.getIndexJoueur(action)).setPossedeAttaque(false);
                        if (terrain.getPokemonIA().get(terrain.getIndexIA(cible)).estMort()) {
                            adversaire.defausse(terrain.getPokemonIA().get(terrain.getIndexIA(cible)));
                            terrain.retirePokemonIA(terrain.getIndexIA(cible));
                        }
                    }
                    if (cible.equals("1") || cible.equals("2") || cible.equals("3")) {
                        if (Integer.parseInt(cible) <= terrain.getPokemonIA().size() && Integer.valueOf(cible) >= 0) {
                            terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).subitDegat(terrain.getPokemonJoueur()
                                    .get(terrain.getIndexJoueur(action)).getAttaque(), terrain.getPokemonJoueur().get(terrain.getIndexJoueur(action)).getType());
                            terrain.getPokemonJoueur().get(terrain.getIndexJoueur(action)).setPossedeAttaque(false);
                            if (terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).estMort()) {
                                adversaire.defausse(terrain.getPokemonIA().get(Integer.valueOf(cible) - 1));
                                terrain.retirePokemonIA(Integer.valueOf(cible) - 1);
                            }
                        }
                    }
                }
                if ((action.equals("1") && terrain.getPokemonJoueur().get(0).isPossedeAttaque()) ||
                        (action.equals("2") && terrain.getPokemonJoueur().get(1).isPossedeAttaque()) ||
                        (action.equals("3") && terrain.getPokemonJoueur().get(2).isPossedeAttaque())) {

                    print.demandeCibleAdverse(terrain);
                    cible = s.nextLine();
                    if (terrain.IAContient(cible)) {
                        terrain.getPokemonIA().get(terrain.getIndexIA(cible)).subitDegat(terrain.getPokemonJoueur()
                                .get(Integer.parseInt(action) - 1).getAttaque(), terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getType());
                        terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).setPossedeAttaque(false);
                        if (terrain.getPokemonIA().get(terrain.getIndexIA(cible)).estMort()) {
                            adversaire.defausse(terrain.getPokemonIA().get(terrain.getIndexIA(cible)));
                            terrain.retirePokemonIA(terrain.getIndexIA(cible));
                        }
                    }
                    System.out.println(cible);
                    if (cible.equals("1") || cible.equals("2") || cible.equals("3")) {
                        if (Integer.parseInt(cible) <= terrain.getPokemonIA().size() && Integer.valueOf(cible) >= 0) {
                            terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).subitDegat(terrain.getPokemonJoueur()
                                    .get(Integer.parseInt(action) - 1).getAttaque(), terrain.getPokemonJoueur().get(Integer.parseInt(action) - 1).getType());
                            terrain.getPokemonJoueur().get(Integer.parseInt(action)-1).setPossedeAttaque(false);
                            if (terrain.getPokemonIA().get(Integer.valueOf(cible) - 1).estMort()) {
                                adversaire.defausse(terrain.getPokemonIA().get(Integer.valueOf(cible) - 1));
                                terrain.retirePokemonIA(Integer.valueOf(cible) - 1);
                            }
                        }
                    }
                }
                action = "2";
            }
        }
        return true;
    }
}
