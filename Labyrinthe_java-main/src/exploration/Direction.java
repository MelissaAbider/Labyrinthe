/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Direction {

    private final static char INVALIDE = '\0';
    private final static char[] SYMBOLES = { '↖', '↑', '↗', '←', Direction.INVALIDE, '→', '↙', '↓', '↘' };

    /**
     * Restitue une nouvelle instance de direction aléatoire
     * 
     * @return une instance de Direction
     */
    public static Direction getDirectionAlea() {
        int dLig = (int) (Math.random() * 3 - 1);
        int dCol;
        // il faut éviter que dLig et dCol vaillent tous deux 0
        if (dLig == 0)
            dCol = 2 * (int) (Math.random() * 2) - 1;
        else
            dCol = (int) (Math.random() * 3 - 1);
        return new Direction(dLig, dCol);
    }

    /**
     *
     * @param invite
     * @return une direction choisie par le joueur entre
     *         "gauche", "droite", "haut", "bas", "haut gauche", "bas gauche", "haut
     *         droite", "bas droite"
     */
    public static Direction getDirectionJoueur(String invite) {
        Direction retour;
        do {
            String choix = Lire.S(invite + " (g|d|h|b|hg|bg|hd|bd)");
            retour = getDirection(choix);
        } while (retour == null);
        return retour;
    }

    /**
     *
     * @param choix
     * @return
     */
    public static Direction getDirection(String choix) {
        Direction retour;
        switch (choix) {
            case "hg":
                retour = new Direction(-1, -1);
                break;
            case "h":
                retour = new Direction(-1, 0);
                break;
            case "hd":
                retour = new Direction(-1, +1);
                break;
            case "g":
                retour = new Direction(0, -1);
                break;
            case "d":
                retour = new Direction(0, +1);
                break;
            case "bg":
                retour = new Direction(+1, -1);
                break;
            case "b":
                retour = new Direction(+1, 0);
                break;
            case "bd":
                retour = new Direction(+1, +1);
                break;
            default:
                retour = null;
        }
        return retour;
    }

    private int dLig;

    /**
     * @param dLig nombre entier entre -1 et 1 qui exprime un différentiel par
     *             rapport à un numéro de ligne donné
     */
    public void setdLig(int dLig) {
        this.dLig = dLig;
    }

    /**
     *
     * @return
     */
    public int getdLig() {
        return this.dLig;
    }

    /**
     * @param dCol the dCol to set
     */
    private int dCol;

    /**
     *
     * @param dCol
     */
    public void setdCol(int dCol) {
        this.dCol = dCol;
    }

    /**
     *
     * @return
     */
    public int getdCol() {
        return this.dCol;
    }

    /**
     *
     * @return
     */
    public char getSymbole() {
        return Direction.SYMBOLES[(this.getdCol() + 1) + 3 * (this.getdLig() + 1)];
    }

    /**
     *
     * @param dLig
     * @param dCol
     */
    public Direction(int dLig, int dCol) {
        this.setdLig(dLig);
        this.setdCol(dCol);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "" + getSymbole();
    }

}
