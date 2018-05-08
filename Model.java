public class Model {
    private  Pion j1;
    private Pion j2;
    private boolean p1;
    private boolean p2;
    private int choix1;
    private int choix2;
    private Pion[] grille;

    public Model(){
        j1 = new Pion("Bleu");
        j2 = new Pion("Rouge");

        grille = new Pion[42];

        int i = 0;

        p1 = true;
        p2 = false;
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

    public Pion[] getGrille() {
        return grille;
    }

    public void setGrille(Pion[] grille) {
        this.grille = grille;
    }

    public boolean test(int i, Pion[] grille){
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
