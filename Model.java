import java.util.List;
import java.util.Random;

public class Model {
    private  Pion j1;
    private Pion j2;
    private Pion jOrdi;
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
    private Pion PionFin;

    public Model(){

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

    public void IA_jouer(Pion[][] grille, int profondeur){
        int max = - 10000;
        int tmp,maxi=0,maxj=0;

        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                if (grille[i][j] == null){
                    grille[i][j]=j1;
                    tmp = min(grille,profondeur-1);

                    if (tmp>max){
                        max=tmp;
                        maxi=i;
                        maxj=j;
                    }

                    grille[i][j]=null;
                }
            }
        }

        grille[maxi][maxj]=j1;
    }

    public int max(Pion[][] grille, int profondeur){
        if (profondeur==0 ||gagnant(grille)!=null){
            return eval(grille);
        }
        int max = -10000;
        int tmp;

        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                if (grille[i][j] == null){
                    grille[i][j]=jOrdi;
                    tmp=min(grille,profondeur-1);

                    if (tmp> max){
                        max= tmp;
                    }
                    grille[i][j] = null;
                }
            }
        }
        return max;
    }

    public int min(Pion[][] grille, int profondeur){
        if (profondeur==0 ||gagnant(grille)!=null){
            return eval(grille);
        }
        int min = 10000;
        int tmp;

        for (int i=0;i<6;i++){
            for (int j=0;j<7;j++){
                if (grille[i][j] == null){
                    grille[i][j]=j1;
                    tmp=max(grille,profondeur-1);

                    if (tmp< min){
                        min= tmp;
                    }
                    grille[i][j] = null;
                }
            }
        }
        return min;
    }

    public int eval(Pion[][] grille){
        int nb_de_pions = 0;
        Pion vainqueur ;

        //On compte le nombre de pions présents sur le plateau
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grille[i][j] != null){
                    nb_de_pions++;
                }
            }
        }

        if((vainqueur = gagnant(grille)) != null){
            if( vainqueur == j1 ){
                return 1000 - nb_de_pions;
            }
            else if( vainqueur == jOrdi ){
                return -1000 + nb_de_pions;
            }
            else{
                return 0;
            }
        }

        //On compte le nombre de séries de 2 pions alignés de chacun des joueurs

        nb_series(grille,2);

        return series_j1 - series_jOrdi;
    }

    public void nb_series(Pion[][] grille,int n){
        series_j1=0;
        series_jOrdi=0;

        int compteur1=0;
        int compteur2=0;

        for (int i=0;i<6;i++){
            if (grille[i][i] == j1){
                compteur1++;
                compteur2=0;

                if (compteur1==n){
                    series_j1++;
                }
            }
            else if (grille[i][i] == jOrdi){
                compteur2++;
                compteur1 =0;
                if (compteur2==n){
                    series_jOrdi++;
                }
            }
        }

        compteur1=0;
        compteur2=0;

        for(int i=0;i<6;i++){
            if(jeu[i][2-i] == 1){
                compteur1++;
                compteur2 = 0;
                if(compteur1 == n){
                    series_j1++;
                }
            }
            else if(jeu[i][2-i] == 2){
                compteur2++;
                compteur1 = 0;
                if(compteur2 == n){
                     series_jOrdi++;
                }
            }
        }

        //En ligne

        for(int i=0;i<6;i++){
            compteur1 = 0;
            compteur2 = 0;

            //Horizontalement

            for(int j=0;j<7;j++){
                if(grille[i][j] == j1){
                    compteur1++;
                    compteur2 = 0;
                    if(compteur1 == n){
                         series_j1++;
                    }
                }
                else if(grille[i][j] == jOrdi){
                    compteur2++;
                    compteur1 = 0;
                    if(compteur2 == n){
                         series_jOrdi++;
                    }
                }
            }

            compteur1 = 0;
            compteur2 = 0;

            //Verticalement

            for(int j=0;j<7;j++){
                if(grille[j][i] == j1){
                    compteur1++;
                    compteur2 = 0;
                    if(compteur1 == n){
                        series_j1++;
                    }
                }
                else if(grille[j][i] == jOrdi){
                    compteur2++;
                    compteur1 = 0;
                    if(compteur2 == n){
                        series_jOrdi++;
                    }
                }
            }
        }
    }

    public Pion gagnant(Pion[][] grille){

        nb_series(grille,3);


        if(p1Ordi){
            return j1;
        }
        else if(pOrdi){
            return jOrdi;
        }
        else{
            //Si le jeu n'est pas fini et que personne n'a gagné, on renvoie 0
            for(int i=0;i<6;i++){
                for(int j=0;j<7;j++){
                    if(grille[i][j] == null){
                        return null;
                    }
                }
            }
        }

        //Si le jeu est fini et que personne n'a gagné, on renvoie 3
        return PionFin;
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
