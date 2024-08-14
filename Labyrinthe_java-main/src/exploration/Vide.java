/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Vide extends Case {
    private boolean devoiler;

    /**
     *
     * @param plateau
     * @param lig
     * @param col
     */
    public Vide(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
        /* ajout de code éventuel */
        devoiler = false;
    }

    /**
     *
     * @param j
     */
    @Override
    public void arrive(Joueur j) {
        /*
         * À son arrivée, le joueur est positionné dans cette case , rien n'est fais
         * pour une pierre
         */
        j.setPosition(this);// on fais de la case vide la nouvelle position du joueur
        this.devoiler = true;
    }

    /**
     *
     * @param j
     * @param d
     */
    @Override
    public void propageJ(Joueur j, Direction d) {
        super.propageJ(j, d);
        /* la pierre ou le joueur est propagée à la case voisine dans la direction d */
    }

    public void propageP(Joueur j, Direction d) {

        super.propageP(j, d);
        /* la pierre ou le joueur est propagée à la case voisine dans la direction d */
    }

    public String toString() {
        return "--";
    }

    public String toStr() {
        return "-";
    }

    public boolean isDevoiler() {
        return devoiler;
    }
}
