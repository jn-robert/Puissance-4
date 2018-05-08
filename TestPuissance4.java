public class TestPuissance4 {
    public static void main(String[] args){
        Pion j1 = new Pion("Bleu"); //renommer Pion en joueur(dimitri)
        Pion[][] grille = new Pion[][]{
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
        };

        // faire jeu coup par coup

        for(int x=0; x<=5 ;x++){
            for(int y=0; y<=6 ;y++){
                if(Grille.estGagnee(x,y,grille) == true){
                    System.out.println("Victoire : x="+x+" y="+y);
                }
            }
        }
    }
}