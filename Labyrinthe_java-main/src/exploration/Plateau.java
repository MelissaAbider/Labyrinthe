/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Plateau {

    private Case[][] grille;
    private int nbCol;
    private int nbLig;

    /**
     * Restitue la case du plateau de numéro de ligne lig et de numéro de colonne
     * col
     * 
     * @param lig Le numéro de la ligne entre 0 (case du bord haut) et
     *            this.getNbLig()+1 (case du bord bas)
     * @param col Le numéro de la colonne entre 0 (case du bord gauche) et
     *            this.getNbLig()+1 (case du bord droite)
     * @return La référence à une case ou null
     */
    public Case get(int lig, int col) {
        // restitue null quand les numéros de ligne ou de colonne sortent du plateau
        if (lig < 0 || lig > this.getNbLig() + 1 || col < 0 || col > this.getNbCol() + 1)
            return null;
        else
            return this.grille[lig][col];
    }

    /**
     * Conceptuellement, place une case dans la grille du plateau (En fait, c'est
     * l'adresse de la case qui est placée)
     * 
     * @param lig un numéro de ligne
     * @param col un numéro de colonne
     * @param c   une référence à une case à placer
     */
    public void setCaseDeGrille(int lig, int col, Case c) {
        this.grille[lig][col] = c;
    }

    /**
     * Restitue le nombre de colonnes à l'intérieur du plateau.
     * Il faut y ajouter les bords gauche et droit pour obtenir la taille
     * horizontale de la grille
     * 
     * @return un entier supérieur ou égal à 1.
     */
    public int getNbCol() {
        return this.nbCol;
    }

    private void setNbCol(int nbCol) {
        this.nbCol = nbCol;
    }

    /**
     * Restitue le nombre de lignes à l'intérieur du plateau.
     * Il faut y ajouter les bords haut et bas pour obtenir la taille verticale de
     * la grille
     * 
     * @return un entier supérieur ou égal à 1.
     */
    public int getNbLig() {
        return this.nbLig;
    }

    private void setNbLig(int nbLig) {
        this.nbLig = nbLig;
    }

    private void initContenu(Categorie[] liste) {
        int coL, liG;
        // Le ratio est le nombre de cases du plateau (nbLig*nbCol) divisé par 100
        double ratio = (double) this.getNbLig() * this.getNbCol() / 100;
        for (Categorie courante : liste) // Pour chaque catégorie de la liste des catégories
        {
            /*
             * Le nombre de cases de la catégorie à placer effectivement dans le plateau est
             * calculé (règle de trois) à partir
             * du Categorie de cases à placer divisé par 100 et multiplié par le nombre de
             * cases du plateau
             */
            int nbAPlacer = (int) (courante.getPourcentage() * ratio);

            for (int cpte = 1; cpte <= nbAPlacer; cpte++) {
                boolean vide;
                do {

                    // pas de +1 car on tolère de 0 à 9 et non 0 à nbCol pour 10 comme nbLig
                    coL = (int) (Math.random() * this.getNbCol());
                    liG = (int) (Math.random() * this.getNbLig());
                    vide = this.get(liG, coL) == null; // rien n'est encore placé là
                    if (vide)
                        this.setCaseDeGrille(liG, coL, courante.getCase(this, liG, coL)); // la case est placée
                } while (!vide);
            }
        }
        // remplissage des cases vides avec des cases simples (qui ont un comportement
        // par défaut pour les pierres et le joueur)
        for (int lig = 1; lig < this.getNbLig(); lig++)
            for (int col = 1; col < this.getNbCol(); col++) // pas <= car on s'arrête à nbCol-1mag
                if (this.get(lig, col) == null)
                    this.setCaseDeGrille(lig, col, new Vide(this, lig, col));
        // remplissage des bordure du plateau
        for (int lig = 0; lig < this.getNbLig(); lig++)
            for (int col = 0; col < this.getNbCol(); col++) {
                if (lig == 0 || col == 0 || col == this.getNbCol() - 1 || lig == this.getNbLig() - 1)// Construction des
                                                                                                     // bordures
                    this.setCaseDeGrille(lig, col, new Bordure(this, lig, col));
            }
        // définition de la case de sortie
        this.setCaseDeGrille(getNbLig() - 2, this.getNbCol() - 1, new Sortie(this, getNbLig() - 1, this.getNbCol()));

        // initialisation des destination
        Case ca;
        Passage p;
        for (int lig = 1; lig < this.getNbLig(); lig++)
            for (int col = 1; col < this.getNbCol(); col++) {
                if (this.grille[lig][col].getClass().equals(Passage.class))// si c'est un passage
                {
                    do {
                        int l = (int) (Math.random() * (getNbLig() - 2) + 1);
                        int c = (int) (Math.random() * (getNbCol() - 2) + 1);
                        ca = this.get(l, c);
                        p = (Passage) grille[lig][col];
                        p.setDestination(ca);
                    } while (p == ca); // empêche la boucle infinit sur une case
                }
            }
        // initialisation des resistance des case de type obstacle
        for (int lig = 1; lig < this.getNbLig(); lig++)
            for (int col = 1; col < this.getNbCol(); col++) {
                if (this.grille[lig][col].getClass().equals(Obstacle.class))// si c'est un obstacle
                {
                    int res = (int) (Math.random() * (3) + 1);// resistance aléatoire entre 1 et 3

                    Obstacle obs = (Obstacle) grille[lig][col];
                    obs.setResistance(res);
                }
            }

    }

    public Plateau(int nbCol, int nbLig, Jeu jeu, Categorie... liste) {
        this.setNbCol(nbCol);
        this.setNbLig(nbLig);
        /* à compléter */
        this.grille = new Case[this.nbLig][this.nbCol]; // allocation de mémoire pour le grille
        initContenu(liste); // on passe à la méthode la liste des catégorie fornie par le programme et
                            // affecté dans le constructeur du jeu

    }

    public void dessinePlateau(Joueur joueur) {
        for (int lig = 0; lig < this.getNbLig(); lig++) {
            for (int col = 0; col < this.getNbCol(); col++) {
                if (lig == 0 && col > 0 && col < this.getNbCol() - 1)
                    System.out.print(this.get(lig, col).toString() + (char) ('A' + col - 1));
                else if (col == this.getNbCol() - 1 && lig > 0 && lig < this.getNbLig() - 2)
                    System.out.print(this.get(lig, col).toString() + (char) ('A' + lig - 1));
                else if (col == 0 && lig != 1 || lig == this.getNbLig() - 1 || lig == 0 && col == this.getNbCol() - 1)
                    System.out.print(this.get(lig, col).toString() + '░');
                else if (lig == 1 && col == 0)
                    System.out.print(this.get(lig, col).toString());

                else if (lig == this.getNbLig() - 2 && col == this.getNbCol() - 1)
                    System.out.print(this.get(lig, col).toString());
                else if (this.get(lig, col).isDevoiler()
                        && (joueur.getPosition().getCol() != col || joueur.getPosition().getLig() != lig)) // case
                                                                                                           // dévoiler
                                                                                                           // et le
                                                                                                           // joueur
                                                                                                           // n'est pas
                                                                                                           // là , pour
                                                                                                           // eviter
                                                                                                           // d'afficher
                                                                                                           // deux fois
                                                                                                           // la même
                                                                                                           // case
                    System.out.print(this.get(lig, col).toString());
                else if (joueur.getPosition().getCol() == col && joueur.getPosition().getLig() == lig)
                    System.out.print(this.get(lig, col).toStr() + joueur.toString());
                else
                    System.out.print("  ");

            }
            System.out.println("");
        }
    }

    public void toString(Joueur joueur) {
        for (int lig = 0; lig < this.getNbLig(); lig++) {
            for (int col = 0; col < this.getNbCol(); col++) {
                if (lig == 0 && col > 0 && col < this.getNbCol() - 1)
                    System.out.print(this.get(lig, col).toString() + (char) ('A' + col - 1));
                else if (col == this.getNbCol() - 1 && lig > 0 && lig < this.getNbLig() - 2)
                    System.out.print(this.get(lig, col).toString() + (char) ('A' + lig - 1));
                else if (col == 0 && lig != 1 || lig == this.getNbLig() - 1 || lig == 0 && col == this.getNbCol() - 1)
                    System.out.print(this.get(lig, col).toString() + '░');
                else if (joueur.getPosition().getCol() == col && joueur.getPosition().getLig() == lig)
                    System.out.print(this.get(lig, col).toStr() + joueur.toString());
                else
                    System.out.print(this.get(lig, col).toString());
            }
            System.out.println("");
        }
    }
}
