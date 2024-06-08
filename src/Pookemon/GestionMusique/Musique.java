package Pookemon.GestionMusique;

import javax.sound.sampled.*;
import java.io.File;
public class Musique {

    /**
     * Cette méthode permet d'écouter une musique à partir d'un chemin spécifié.
     *
     * @param chemin Le chemin vers le fichier audio à écouter.
     */
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
