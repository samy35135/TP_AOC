package TP_AOC.v1.Materiel.Interface;


/**
 * 
 */
public interface Clavier {

    /**
     * Retourne true si le bouton i est enfoncé, false si il est relaché,
     * Le 1 est start, le 2 est stop, le  3 est Inc et le 4 est dec.
     * @param i
     */
    public boolean touchePressee(int i);

}