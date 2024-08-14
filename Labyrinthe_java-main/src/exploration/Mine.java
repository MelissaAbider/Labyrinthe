/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @@author Abider
 */
public class Mine extends Case {
    private boolean mineActive;
    private boolean devoiler;

    public Mine(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
        this.mineActive = true;
        /* ajout de code éventuel */
        devoiler = false;
    }

    public boolean isMineActive() {
        return mineActive;
    }

    public boolean isDevoiler() {
        return devoiler;
    }

    @Override
    public void arrive(Joueur j) {

        /* La mine explose et le joueur perd */
        if (this.mineActive) {
            this.mineActive = false; // la mine à explosé
            j.setPerdant(true);
            System.out.println("\nvous avez perdu , une mine a explosé \n");
        } else
            j.setPosition(this);

    }

    @Override
    public void propageP(Joueur j, Direction d) {
        if (this.mineActive) { // si mine active
            this.mineActive = false; // la mine à explosé donc désactivée
            this.devoiler = true;
            System.out.println("une mine à explosé à " + this.getCoord() + " la pierre est perdu");
            j.decNbPierres();// le joueur perd la pierre
        } else { // la mine etait désactivée donc on propage comme une case vide
            try {
                super.propageP(j, d);
            } catch (Exception e) {
                System.out.println("la pierre a  ateint la bordure " + this.getCoord());
            }
        }

        /* La mine explose, la case devient visible, et le joueur perd la pierre */
    }

    public String toString() {
        return "☀☀";
    }

    public String toStr() {
        return "☀";
    }

}
