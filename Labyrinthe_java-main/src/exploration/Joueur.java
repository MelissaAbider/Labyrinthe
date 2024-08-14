/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Joueur {

    private String nom;
    private Case position;
    private int nbPierres;
    private boolean gagnant;
    private boolean perdant;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Restitue la position courante du joueur
     * 
     * @return la référence à la case où se trouve le joueur
     */
    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
        /* ajout de code éventuel */
    }

    /**
     * Restitue le nombre de pierres actuellement en possession du joueur
     * 
     * @return un entier qui représente un nombre de pierres
     */
    public int getNbPierres() {
        return this.nbPierres;
    }

    public void setNbPierres(int nbPierres) {
        this.nbPierres = nbPierres;
    }

    /**
     * Restitue vrai si le joueur est gagnant (il est arrivé en bas à droite du
     * plateau)
     * 
     * @return un booléen qui indique si le joueur a gagné
     */
    public boolean isGagnant() {
        return this.gagnant;
    }

    public void setGagnant(boolean gagnant) {
        this.gagnant = gagnant;
    }

    /**
     * Restitue vrai si le joueur a perdu (explosion sur une mine)
     * 
     * @return un booléen qui indique si le joueur a perdu
     */
    public boolean isPerdant() {
        return this.perdant;
    }

    public void setPerdant(boolean perdant) {
        this.perdant = perdant;
    }

    public Joueur(String nom, Case depart, int nbPierres) {
        this.setNom(nom);
        this.setPosition(depart);
        this.setNbPierres(nbPierres);
        // Au départ, le joueur n'a ni perdu, ni gagné
        this.setGagnant(false);
        this.setPerdant(false);
    }

    // on n'implémentera pas cette méthode en considérant comme la pierre que c'est
    // aux case d'effectué le deplacement de d'affecter la position au joueur
    public void avance(Direction d) {
        this.getPosition().propageJ(this, d);

        // le joueur avance à la position qui suit sa position courante en fonction de
        // sa direction
    }

    // pareil on considère que c'est la case que lance la pierre à son voisine ,
    // sachant la position de départ de la piere est celle du joueur
    public void lancePierre(Direction d) {

        // le joueur lance une pierre dans la case voisine à partir de sa position dans
        // la direction d
        if (this.nbPierres > 0)
            this.getPosition().propageP(this, d);

        else
            System.out.println("Vous n'avez plus de pierre");
    }

    /**
     * Incrémentation du nombre de pierres de n unités
     * Sert quand le joueur arrive dans une case qui contient des pierres
     * 
     * @param n entier qui représente le nombre de pierres à ajouter
     */
    public void incNbPierres(int n) {
        this.setNbPierres(this.getNbPierres() + n);
    }

    /**
     * Décrémentation du nombre de pierres d'une unité lorsqu'une pierre est perdue
     */
    public void decNbPierres() {
        this.setNbPierres(this.getNbPierres() - 1);
    }

    public void perd() {
        this.setPerdant(true);
    }

    public void gagne() {
        this.setGagnant(true);
    }

    public String toString() {
        return "♜";
    }
}
