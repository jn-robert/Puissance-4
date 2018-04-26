package Puissance;

public class TestPuissance4 {
    public static void main(String[] args){
        Pion j1 = new Pion("Bleu"); //renommer Pion en joueur(dimitri)
        Pion[] grille = new Pion[]{
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                j1, null, null, null, null, null, null,
                null, j1, null, null, null, null, null,
                null, null, j1, null, null, null, null,
                null, null, null, j1, null, null, null
        };

        // faire jeu coup par coup
        int i=0;
        while (!Grille.estGagnee(i,grille) && i<grille.length-3){
            i++;
        }
        if(Grille.estGagnee(i,grille))
            System.out.println("Gagnee");

        System.out.println("End");
    }
}
