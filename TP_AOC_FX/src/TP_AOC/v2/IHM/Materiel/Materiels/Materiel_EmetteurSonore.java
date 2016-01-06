package TP_AOC.v2.IHM.Materiel.Materiels;


import TP_AOC.v2.IHM.Materiel.Interface.EmetteurSonore;
import TP_AOC.v2.IHM.Materiel.Materiel;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.applet.Applet;
import java.io.File;
import java.net.MalformedURLException;

/**
 * 
 */
public class Materiel_EmetteurSonore implements EmetteurSonore {
    Materiel materiel;



    private File tickFile;

    private AudioClip tick;


    /**
     * Default constructor
     */
    public Materiel_EmetteurSonore(Materiel materiel) {
        this.materiel = materiel;

        tickFile = new File("songs/son1.mp3");
        try {
            tick = new AudioClip(tickFile.toURI().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void emettreSonTempo() {
       /* final Media media1  = new Media(new File("songs/son1.mp3").toURI().toString());
        final MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.play();

        */

        tick.play();
    }

    @Override
    public void emettreSonMesure() {
        final Media media2  = new Media(new File("songs/son2.mp3").toURI().toString());
        final MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.play();
    }
}