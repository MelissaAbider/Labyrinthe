/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Pierres extends Case {
    private int nbrPierre;
    private boolean devoiler;

    /**
     *
     * @param plateau
     * @param lig
     * @param col
     * @param quantiteMax
     */
    public Pierres(Plateau plateau, int lig, int col, int quantiteMax) {
        super(plateau, lig, col);
        /*
         * ajout de code éventuel
         * Le nombre de pierres réel est tiré entre 1 et quantitéMax
         */
        this.nbrPierre = (int) Math.random() * (quantiteMax - 1) + 1;
        devoiler = false;
    }

    /**
     *
     * @param plateau
     * @param lig
     * @param col
     */
    public Pierres(Plateau plateau, int lig, int col) {
        this(plateau, lig, col, 4); // 4 pierres maximum par défaut
    }

    /**
     *
     * @param j
     */
    @Override
    public void arrive(Joueur j) {
        /*
         * à son arrivée, le joueur est placé dans la case et récupère la pierre qu'elle
         * contient
         */
        j.setPosition(this); // le joueur change de case ou position
        j.incNbPierres(this.nbrPierre);
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
        /*
         * la pierre s'ajoute aux pierres de la case et est perdue — temporairement —
         * pour le joueur
         */
    }

    @Override
    public void propageP(Joueur j, Direction d) {
        // ajout de la pierre du joueur à case et perte de la pierre par le joueur
        this.nbrPierre++;
        j.decNbPierres();
        System.out.println("vous avez perdu la pierre à la case " + this.getCoord());
        /* la pierre continue son chemin à la case de destination */
    }

    public String toString() {
        return "▩▩";
    }

    public String toStr() {
        return "▩";
    }

    public boolean isDevoiler() {
        return devoiler;
    }
}
