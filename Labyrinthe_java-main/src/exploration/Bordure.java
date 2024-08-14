/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Bordure extends Case{

    public Bordure(Plateau plateau, int lig, int col) {
        super(plateau, lig, col);
    }
    
    public String toString(){
        return "░";
    }

    @Override
    public void propageP(Joueur j, Direction d) { 
        
            j.decNbPierres(); // la pirre est perdu c'est à dire le nombre de  pierre du joueur est décrémenté si la pierre touche une bordure 
            System.out.println("la pierre a  ateint la bordure  elle est donc perdu ");    
    }


    @Override
    public void arrive(Joueur j) { // cette méthode gère l'arrivé d'un joueur dans la case
        System.out.println("vous avez atteind la bordure veillez changé de direction ");
    }
    
}
