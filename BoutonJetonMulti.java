import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonJetonMulti implements ActionListener {

    private Model model;
    private Fenetre fen;
    private int tailleTab;
    static int compteurJetons = 0;

    public BoutonJetonMulti(Model model, Fenetre fen) {
        this.model = model;
        this.fen = fen;
        tailleTab = (model.getLargeurPuissance4()) * (model.getLongeurPuissance4());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jeton = (JButton) e.getSource();
        int j = Integer.parseInt(String.valueOf(jeton.getName()));
        if (compteurJetons < tailleTab) {
            for (int k = 0; k < model.getListBoolJoueurs().size(); k++) {
                if (model.getListBoolJoueurs().get(k)) {
                    int i = model.testColonne(j);
                    try {
                        model.getGrille();
                        model.rempli(i, j, model.getListJoueur().get(k));
                        fen.dessine(i, j, fen.getListJetons().get(k));
                        if (!model.test(model.getGrille())) {
                            model.getListBoolJoueurs().set(k,false);
                            if (k+1<model.getListBoolJoueurs().size()) {
                                k=k+1;
                            }else {
                                k=0;
                            }
                            model.getListBoolJoueurs().set(k, true);
                            fen.getJoueurCourant().setText("Joueur " + model.getListJoueur().get(k) + " joue");
                            return;
                        } else {
                            fen.afficheMessage("Puissance 4 ! joueur " + model.getListJoueur().get(k) + " gagne");
                            fen.changerVersion(5);
                        }
                        compteurJetons++;
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        fen.afficheMessage("Colonne pleine ,veuillez jouer ailleurs");
                        return;
                    }
                }
            }
        }
    }
}