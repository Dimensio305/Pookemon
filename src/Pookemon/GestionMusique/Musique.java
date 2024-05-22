package Pookemon.GestionMusique;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Musique {
    public static void Ecoute(String chemin) {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(new File(chemin));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement de la musique");
        }

    }
}
