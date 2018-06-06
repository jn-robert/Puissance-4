import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {
    private  Pion j1;
    private Pion j2;
    private Pion jOrdi;
    private Pion pionTemp;
    private boolean p1;
    private boolean p2;
    private boolean p1Ordi;
    private boolean pOrdi;
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
    private int series_j1;
    private int series_jOrdi;
    private boolean troisDangerAligne=false;

    private ArrayList<Pion> listJoueur;

    public Model(){
        //a revoir
        nombreDeVictoireJoueurRouge=0;
        nombreDeVictoireJoueurJaune=0;
        nombreDePartie=1;
        nombreEgalite=0;
        j1 = new Pion("rouge");
        j2 = new Pion("jaune");
        jOrdi = new Pion("jaune");
        boolean r= ( Math.random() >= 0.5 );

        if (r){
            p1 = true;
            p2=false;
            p1Ordi=true;
            pOrdi=false;
        }
        else{
            p2 = true;
            p1=false;
            pOrdi=true;
            p1Ordi=false;
        }

    }

    public void setNombreDeJoueur(int nbJoueur){
        listJoueur = new ArrayList<>();
        switch (nbJoueur)
        {
            case 2:
                listJoueur.add(new Pion("rouge"));
                listJoueur.add(new Pion("jaune"));
                break;
            case 3:
                listJoueur.add(new Pion("rouge"));
                listJoueur.add(new Pion("jaune"));
                listJoueur.add(new Pion("bleu"));
                break;
            case 4:
                listJoueur.add(new Pion("rouge"));
                listJoueur.add(new Pion("jaune"));
                listJoueur.add(new Pion("bleu"));
                listJoueur.add(new Pion("orange"));
                break;
            case 5:
                listJoueur.add(new Pion("rouge"));
                listJoueur.add(new Pion("jaune"));
                listJoueur.add(new Pion("bleu"));
                listJoueur.add(new Pion("orange"));
                listJoueur.add(new Pion("vert"));
                break;
            case 6:
                listJoueur.add(new Pion("rouge"));
                listJoueur.add(new Pion("jaune"));
                listJoueur.add(new Pion("bleu"));
                listJoueur.add(new Pion("orange"));
                listJoueur.add(new Pion("vert"));
                listJoueur.add(new Pion("violet"));
                break;
        }

    }

    public void rempli(int i, int j, Pion p){
        grille[i][j] = p;
    }

    public boolean test(Pion[][] grille){
        boolean result=false;
        for(int i=0; i<grille.length;i++){
            for(int j=0; j<grille[i].length;j++){
                if (Grille.estGagnee(i,j,grille)){
                    result = true;
                }        
            }
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

    public void partieClassiqueIA(){
        largeurPuissance4=7;
        longeurPuissance4=6;
        nombreDePartie=1;
        init();
    }

    public int coupsIA(){
        boolean test=true;
        int colonne = 0;
        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                if (grille[i][j]!=null){
                    test=false;
                }
            }
        }
        if (test){
            colonne=7/2;
        }
        if (!test){
            colonne=nbAlignes();
            if (!troisDangerAligne){
                colonne = (int) (Math.random() * 7);
            }
        }
        return colonne;
    }

    public int nbAlignes(){
        int colonne = 0;
        for (int i=0;i<longeurPuissance4;i++) {
            for (int j = 0; j < largeurPuissance4; j++) {
                try {
                    // tests contres
                    if (grille[i][j] == j1 && grille[i][j + 1] == j1 && grille[i][j + 2] == j1 && grille[i][j+3]==null) {
                        int ligne = testColonne(j+3);
                        rempli(ligne, j+3, j1);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j+3;
                        }
                        rempli(ligne,j+3,null);
                    }
                    else if (grille[i][j] == j1 && grille[i][j + 1] == j1 && grille[i][j + 2] == j1 && grille[i][j-1]==null) {
                        int ligne = testColonne(j-1);
                        rempli(ligne, j-1, j1);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j-1;
                        }
                        rempli(ligne,j-1,null);
                    }
                    else if (grille[i][j] == j1 && grille[i + 1][j] == j1 && grille[i + 2][j] == j1 && grille[i+3][j]==null) {
                        int ligne = testColonne(j);
                        rempli(ligne,j,j1);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j;
                        }
                        rempli(ligne,j,null);
                    }
                    else if (grille[i][j] == j1 && grille[i + 1][j] == j1 && grille[i + 2][j] == j1 && grille[i-1][j]==null) {
                        int ligne = testColonne(j);
                        rempli(ligne,j,j1);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j;
                        }
                        rempli(ligne,j,null);
                    }
                    else if (grille[i][j]==j1 && grille[i+1][j+1]==j1 && grille[i+2][j+2]==j1 && grille[i+3][j+3]==null) {
                        int ligne = testColonne(j + 3);
                        rempli(ligne, j + 3, j1);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j + 3;
                        }
                        rempli(ligne, j + 3, null);
                    }
                    else if (grille[i][j]==j1 && grille[i+1][j+1]==j1 && grille[i+2][j+2]==j1 && grille[i-1][j-1]==null){
                        int ligne = testColonne(j-1);
                        rempli(ligne,j-1,j1);
                        if (test(grille)){
                            troisDangerAligne=true;
                            colonne=j-1;
                        }
                        rempli(ligne,j-1,null);
                    }
                    else if (grille[i][j]==j1 && grille[i+1][j-1]==j1 && grille[i+2][j-2]==j1 && grille[i+3][j-3]==null) {
                        int ligne = testColonne(j - 3);
                        rempli(ligne, j - 3, j1);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j - 3;
                        }
                        rempli(ligne, j - 3, null);
                    }
                    else if (grille[i][j]==j1 && grille[i+1][j-1]==j1 && grille[i+2][j-2]==j1 && grille[i-1][j+1]==null){
                        int ligne = testColonne(j+1);
                        rempli(ligne,j+1,j1);
                        if (test(grille)){
                            troisDangerAligne=true;
                            colonne=j+1;
                        }
                        rempli(ligne,j+1,null);
                    }
                    // tests gagne
                    if (grille[i][j] == j2 && grille[i][j + 1] == j2 && grille[i][j + 2] == j2 && grille[i][j+3]==null) {
                        int ligne = testColonne(j+3);
                        rempli(ligne, j+3, j2);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j+3;
                        }
                        rempli(ligne,j+3,null);
                    }
                    else if (grille[i][j] == j2 && grille[i][j + 1] == j2 && grille[i][j + 2] == j2 && grille[i][j-1]==null) {
                        int ligne = testColonne(j-1);
                        rempli(ligne, j-1, j2);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j-1;
                        }
                        rempli(ligne,j-1,null);
                    }
                    else if (grille[i][j] == j2 && grille[i + 1][j] == j2 && grille[i + 2][j] == j2 && grille[i+3][j]==null) {
                        int ligne = testColonne(j);
                        rempli(ligne,j,j2);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j;
                        }
                        rempli(ligne,j,null);
                    }
                    else if (grille[i][j] == j2 && grille[i + 1][j] == j2 && grille[i + 2][j] == j2 && grille[i-1][j]==null) {
                        int ligne = testColonne(j);
                        rempli(ligne,j,j2);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j;
                        }
                        rempli(ligne,j,null);
                    }
                    else if (grille[i][j]==j2 && grille[i+1][j+1]==j2 && grille[i+2][j+2]==j2 && grille[i+3][j+3]==null) {
                        int ligne = testColonne(j + 3);
                        rempli(ligne, j + 3, j2);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j + 3;
                        }
                        rempli(ligne, j + 3, null);
                    }
                    else if (grille[i][j]==j2 && grille[i+1][j+1]==j2 && grille[i+2][j+2]==j2 && grille[i-1][j-1]==null){
                        int ligne = testColonne(j-1);
                        rempli(ligne,j-1,j2);
                        if (test(grille)){
                            troisDangerAligne=true;
                            colonne=j-1;
                        }
                        rempli(ligne,j-1,null);
                    }
                    else if (grille[i][j]==j2 && grille[i+1][j-1]==j2 && grille[i+2][j-2]==j2 && grille[i+3][j-3]==null) {
                        int ligne = testColonne(j - 3);
                        rempli(ligne, j - 3, j2);
                        if (test(grille)) {
                            troisDangerAligne = true;
                            colonne = j - 3;
                        }
                        rempli(ligne, j - 3, null);
                    }
                    else if (grille[i][j]==j2 && grille[i+1][j-1]==j2 && grille[i+2][j-2]==j2 && grille[i-1][j+1]==null){
                        int ligne = testColonne(j+1);
                        rempli(ligne,j+1,j2);
                        if (test(grille)){
                            troisDangerAligne=true;
                            colonne=j+1;
                        }
                        rempli(ligne,j+1,null);
                    }
                }catch (ArrayIndexOutOfBoundsException ex){}
            }
        }
        return colonne;
    }

    public int testColonne(int colonne){
        int test = longeurPuissance4-1;
        for (int i=longeurPuissance4-1; i>=0; i--){
            if (grille[i][colonne] != null){
                test--;
            }
        }
        return test;
    }

    public boolean isP1Ordi() {
        return p1Ordi;
    }

    public void setP1Ordi(boolean p1Ordi) {
        this.p1Ordi = p1Ordi;
    }

    public boolean ispOrdi() {
        return pOrdi;
    }

    public void setpOrdi(boolean pOrdi) {
        this.pOrdi = pOrdi;
    }
}
