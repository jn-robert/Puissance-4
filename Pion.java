public class Pion {
    public final String couleur;
    private int nbVictoire = 0;

    public Pion(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return couleur;
    }

    public int getNbVictoire() {
        return nbVictoire;
    }

    public void setNbVictoire(int nbVictoire) {
        this.nbVictoire = nbVictoire;
    }
}
