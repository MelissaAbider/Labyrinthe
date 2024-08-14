package exploration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 * @author Abider
 */
public class Exploration {

    /**
     * Lance un jeu avec quatre catégories de cases : "Pierres", "Mines",…. Pour
     * chaque catégorie,
     * le nombre représente le nombre d'éléments de la catégorie pour 100 cases du
     * plateau.
     * Si le plateau comporte 200 cases, il y aura 6 cases contenant des pierres, 16
     * cases comportant des mines,…
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char rej;
        int nbL, nbCol, ppi = 0, pmi = 0, pob = 0, ppas = 0;

        do {

            System.out.println("veillez entrez le pourcentage des cases entre 3 et 20:");
            do {
                ppi = Lire.i("% de pierres ");
            } while (ppi < 3 || ppi > 20);
            do {
                pmi = Lire.i("% de mines ");
            } while (pmi < 3 || pmi > 20);
            do {
                ppas = Lire.i("% de passages ");
            } while (ppas < 3 || ppas > 20);
            do {
                pob = Lire.i("% de obstacles ");
            } while (pob < 3 || pob > 20);

            Categorie pierres = new Categorie(ppi, "Pierres"),
                    mines = new Categorie(pmi, "Mine"),
                    transferts = new Categorie(ppas, "Transfert"),
                    obstacles = new Categorie(pob, "Obstacle");

            System.out.println("veillez entrez les dimensions du plateau ");

            do {
                nbL = Lire.i("  nombre de ligne entre 4 et 26 ");
            } while (nbL < 4 || nbL > 26);
            do {
                nbCol = Lire.i(" nombre de colonne 4 et 26 ");
            } while (nbCol < 4 || nbCol > 26);
            // les +2 servent pour dessiner les bordures du plateau
            Jeu jeu = new Jeu(nbL + 2, nbCol + 2, 4, pierres, mines, transferts, obstacles); // nbLig et nbCol seront
                                                                                             // ceux du plateau
            jeu.joue();
            // la liste des catégories seront celle fournie pour créer le plateau
            do {
                rej = Lire.c("voulez vous rejouer ?");
            } while (rej != 'N' && rej != 'n' && rej != 'O' && rej != 'o');
        } while (rej == 'O' || rej == 'o');

    }
}
