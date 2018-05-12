public class Pion {
    public final String couleur;

    public Pion(String couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return couleur;
    }
}
