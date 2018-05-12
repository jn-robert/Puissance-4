import java.util.List;
import java.util.Random;

public class Model {
    private  Pion j1;
    private Pion j2;
    private boolean p1;
    private boolean p2;
    private int choix1;
    private int choix2;
    private int [][] jeu;
    private Pion[][] grille;
    private Pion[] grille1D;

    public Model(){
        j1 = new Pion("rouge");
        j2 = new Pion("jaune");
        jeu = new int [6][7];
        grille = new Pion[6][7];

        boolean r= ( Math.random() >= 0.5 );
        if (r){
            p1 = true;
            p2=false;
        }
        else{
            p2 = true;
            p1=false;
        }

        grille1D = new Pion[42];

    }

    public int[][] getJeu() {
        return jeu;
    }

    public void setJeu(int[][] jeu) {
        this.jeu = jeu;
    }


    public Pion getJ1() {
        return j1;
    }

    public void setJ1(Pion j1) {
        this.j1 = j1;
    }

    public Pion getJ2() {
        return j2;
    }

    public void setJ2(Pion j2) {
        this.j2 = j2;
    }

    public boolean isP1() {
        return p1;
    }

    public void setP1(boolean p1) {
        this.p1 = p1;
    }

    public boolean isP2() {
        return p2;
    }

    public void setP2(boolean p2) {
        this.p2 = p2;
    }

    public int getChoix1() {
        return choix1;
    }

    public void setChoix1(int choix1) {
        this.choix1 = choix1;
    }

    public int getChoix2() {
        return choix2;
    }

    public void setChoix2(int choix2) {
        this.choix2 = choix2;
    }
    public Pion[][] getGrille() {
        return grille;
    }

    public void setGrille(Pion[][] grille) {
        this.grille = grille;
    }

    public boolean test(int i, int y,Pion[][] grille){
        boolean result=false;
        while (!Grille.estGagnee(i,y,grille) && i<grille.length-3){
            i++;
        }
        if (Grille.estGagnee(i,y,grille)){
            result = true;
        }
        return result;
    }


    public void rempli(int i, int j, Pion p){
        grille[i][j] = p;
    }

}