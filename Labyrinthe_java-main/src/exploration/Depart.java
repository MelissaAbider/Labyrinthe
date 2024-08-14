/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author Abider
 */
public class Depart extends Case{
    
    public Depart(Plateau plateau, int lig, int col) {
            super(plateau, lig, col);

    }


    @Override
    public void propageJ(Joueur j, Direction d)
    {
        super.propageJ(j, d);
        /* la pierre continue son chemin à la case de destination */
    }
    public String toString(){
        return "▶▶";
    }

    @Override
    public void arrive(Joueur j) {
        System.out.println("vous être revenu à la case depart ");
    }
   
}
