/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Sortie extends Case {

    public Sortie(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
    }

    public void arrive(Joueur j) {
        /*
         * À son arrivée, le joueur est positionné dans cette case , rien n'est fais
         * pour une pierre
         */
        j.setPosition(this);// on fais de la case vide la nouvelle position du joueur
        System.out.println("\nVous avez gagné \n");
        j.setGagnant(true);

    }

    public void propageP(Joueur j, Direction d) // pour propager le joueur dans la direction d
    {
        /* ajout de code */
        System.out.println("la pierre a atteind la sortie");
        j.decNbPierres();
    }

    public String toString() {
        return "▷▷";
    }

    public String toStr() {
        return "▷";
    }

}
