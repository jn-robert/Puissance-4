import java.util.Scanner;

public class TestPuissance4_2 {
    final static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Pion j1 = new Pion("Bleu");
        Pion j2 = new Pion("Rouge");
        boolean p1;
        boolean p2;
        int choix1;
        int choix2;
        Pion[] grille = new Pion[]{
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null,
                null, null, null, null, null, null, null
        };

        int i = 0;

        p1 = true;
        p2 = false;

        while (!Grille.estGagnee(i, grille) && i < grille.length) {
            if (p1) {

                do {
                    System.out.println("j1 choisi la colonne : 1, 2, 3, 4, 5, 6, 7");
                    choix1 = input.nextInt() - 1;
                }
                while (choix1 < 0 || choix1 > 6);

                while ( choix1<42 && grille[choix1] != null ){
                    choix1 = choix1 + 7;
                    System.out.println(choix1);
                }
                if ( choix1<42 && grille[choix1] == null ) {
                    grille[choix1] = j1;
                    if (!test(i, grille)) {
                        p1 = false;
                        p2 = true;
                    } else {
                        System.out.println("j1 gagne");
                        break;
                    }
                }
                if (choix1 > 41){
                    System.out.println("colonne pleine");
                }
            } else if (p2) {
                do {
                    System.out.println("j2 choisi la colonne : 1, 2, 3, 4, 5, 6, 7");
                    choix2 = input.nextInt() - 1;
                }
                while (choix2 < 0 || choix2 > 6);

                while (grille[choix2] != null ) {
                    choix2 = choix2 + 7;
                }
                if (grille[choix2] == null ) {
                    grille[choix2] = j2;
                    if (!test(i, grille)) {
                        p1 = true;
                        p2 = false;
                    } else {
                        System.out.println("j2 gagne");
                        break;
                    }
//                }
                }
            }
        }
    }
    public static boolean test(int i, Pion[] grille){
        boolean result=false;
        while (!Grille.estGagnee(i,grille) && i<grille.length-3){
            i++;
        }
        if (Grille.estGagnee(i,grille)){
            result = true;
        }
        return result;
    }
}
