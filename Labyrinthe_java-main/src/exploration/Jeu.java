/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Jeu {

    private Joueur joueur;
    private Plateau grille;

    /**
     *
     * @return
     */
    public Joueur getJoueur() {
        return this.joueur;
    }

    /**
     *
     * @param joueur
     */
    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    /**
     *
     * @return
     */
    public Plateau getGrille() {
        return grille;
    }

    /**
     *
     * @param grille
     */
    public void setGrille(Plateau grille) {
        this.grille = grille;
    }

    /**
     *
     * @return
     */
    public Plateau getPlateau() {
        return grille;
    }

    /**
     *
     * @param plateau
     */
    public void setPlateau(Plateau plateau) {
        this.grille = plateau;
    }

    /**
     * Restitue vrai si le jeu est terminé, c'est-à-dire si le joueur a gagné ou
     * perdu
     * 
     * @return un booléen
     */
    public boolean isFini() {
        return this.getJoueur().isGagnant() || this.getJoueur().isPerdant();
    }

    /**
     * À chaque tour, on demande au joueur s'il veut avancer ou lancer une pierre.
     * Cela se termine quand le joueur gagne ou perd
     */
    public void joue() {

        do {
            this.grille.dessinePlateau(this.joueur);
            System.out
                    .println("le joueur " + getJoueur().getNom() + " a " + getJoueur().getNbPierres() + " Pierres\n\n");
            char rep = Lire.c("Avancer ou lancer une pierre(A/P) ");
            if (rep == 'A') {
                getJoueur().avance(Direction.getDirectionJoueur("Choisis une direction"));
            } else if (rep == 'P') {
                getJoueur().lancePierre(Direction.getDirectionJoueur("Choisis une direction"));

            } else
                System.out.println("veillez saisir  A ou P ");

        } while (!(getJoueur().isGagnant() || getJoueur().isPerdant())); // on boucle tand que le joueur n'est ni
                                                                         // gagnant ni perdant
        System.out.println("\nvoici les cases du plateaux\n");
        this.grille.toString(this.joueur);
        System.out.println("\n");

    }

    /**
     *
     * @param nbLig
     * @param nbCol
     * @param nbPierres nombre de pierres du joueur en pourcentage du nombre de
     *                  cases du plateau
     * @param liste     liste des catégories de cases - qui inclut le pourcentage
     *                  voulu de cette catégorie
     */
    public Jeu(int nbLig, int nbCol, int nbPierres, Categorie... liste) {
        this.setPlateau(new Plateau(nbCol, nbLig, this, liste));
        // création et affection de la case départ au plateau
        Case c = new Depart(this.getPlateau(), 1, 0);
        this.getPlateau().setCaseDeGrille(1, 0, c);
        /*
         * On crée un joueur avec :
         * - un nom demandé à l'utilisateur,
         * - une case de départ à la ligne 1 et la colonne 0 (case du bord haut droit)
         * - un nombre de pierres initial calculé par rapport au nombre de pierres en
         * pourcentage et au nombre de cases du plateau
         */
        this.setJoueur(
                new Joueur(Lire.S("Nom du joueur? "), this.getPlateau().get(1, 0), nbPierres * nbCol * nbLig / 100));
        // la joueur est ajouté au jeu avec son nom qui est demander grace à la classe
        // Lire.java
        // la case à numlig=1 et numCol=0 lui est ajouté comme case de départ, cette
        // case etant récupéré depuis la plateau

    }

}
