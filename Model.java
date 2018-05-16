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
    private int largeurPuissance4;
    private int longeurPuissance4;
    private int nombreDeVictoireJoueurJaune;
    private int nombreDeVictoireJoueurRouge;
    private int nombreDePartie;
    private int nombreEgalite;
    public Model(){
        nombreDeVictoireJoueurRouge=0;
        nombreDeVictoireJoueurJaune=0;
        nombreDePartie=1;
        nombreEgalite=0;
        j1 = new Pion("rouge");
        j2 = new Pion("jaune");
        boolean r= ( Math.random() >= 0.5 );
        if (r){
            p1 = true;
            p2=false;
        }
        else{
            p2 = true;
            p1=false;
        }

    }

    public void rempli(int i, int j, Pion p){
        grille[i][j] = p;
    }

    public boolean test(int i, int y, Pion[][] grille){
        boolean result=false;
        while (!Grille.estGagnee(i,y,grille) && i<grille.length-3 && y<grille[i].length-3 ){
            i++;
        }
        if (Grille.estGagnee(i,y,grille)){
            result = true;
        }
        return result;
    }

    public void reset(){
        init();
        nombreDeVictoireJoueurJaune=0;
        nombreDeVictoireJoueurRouge=0;
        nombreEgalite=0;
    }

    public void init(){
        jeu = new int [longeurPuissance4][largeurPuissance4];
        grille = new Pion[longeurPuissance4][largeurPuissance4];
    }

    public void partieJouer(String gagnant){
        nombreDePartie--;

    }

    public int getNombreDeVictoireJoueurJaune() {
        return nombreDeVictoireJoueurJaune;
    }

    public void setNombreDeVictoireJoueurJaune(int nombreDeVictoireJoueurJaune) {
        this.nombreDeVictoireJoueurJaune = nombreDeVictoireJoueurJaune;
    }

    public int getNombreDeVictoireJoueurRouge() {
        return nombreDeVictoireJoueurRouge;
    }

    public void setNombreDeVictoireJoueurRouge(int nombreDeVictoireJoueurRouge) {
        this.nombreDeVictoireJoueurRouge = nombreDeVictoireJoueurRouge;
    }

    public int getNombreDePartie() {
        return nombreDePartie;
    }

    public void setNombreDePartie(int nombreDePartie) {
        this.nombreDePartie = nombreDePartie;
    }

    public Pion getJ1() {
        return j1;
    }

    public Pion getJ2() {
        return j2;
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

    public Pion[][] getGrille() {
        return grille;
    }

    public int getLargeurPuissance4() {
        return largeurPuissance4;
    }

    public void setLargeurPuissance4(int largeurPuissance4) {
        this.largeurPuissance4 = largeurPuissance4;
    }

    public int getLongeurPuissance4() {
        return longeurPuissance4;
    }

    public void setLongeurPuissance4(int longeurPuissance4) {
        this.longeurPuissance4 = longeurPuissance4;
    }

    public void partieClassique() {
        largeurPuissance4=7;
        longeurPuissance4=6;
        nombreDePartie=1;
        init();
    }
}