import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonJeton implements ActionListener {
    Model model;
    Fenetre fen;

    int tailleTab;
    static int compteurJetons=0;


    public BoutonJeton(Model model, Fenetre fen) {
        this.model = model;
        this.fen = fen;
        tailleTab = (model.getLargeurPuissance4())*(model.getLongeurPuissance4());

    }

    public void actionPerformed(ActionEvent e) {
        JButton jeton = (JButton) e.getSource();
        int j = Integer.parseInt(String.valueOf(jeton.getName()));
        if (compteurJetons< tailleTab) {
            if (model.isP1()) {
                int i = model.testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ1());
                    fen.dessine(i, j, fen.getJetonRouge());
                    if (!model.test(model.getGrille())) {
                        model.setP1(false);
                        model.setP2(true);
                        fen.getJoueurCourant().setText("Jeton jaune joue");
                        return;
                    }else{
                        fen.afficheMessage("Puissance 4 ! "+model.getJ1()+" gagne");
                        fen.changerVersion(5);
                    }
                    compteurJetons++;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    fen.afficheMessage("Colonne pleine ,veuillez jouer ailleurs");
                    return;
                }

            } else if (model.isP2()) {
                int i = model.testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ2());
                    fen.dessine(i, j, fen.getJetonJaune());
                    if (!model.test(model.getGrille())){
                        model.setP1(true);
                        model.setP2(false);
                        fen.getJoueurCourant().setText("jeton rouge joue");
                        return;
                    }else{
                        fen.afficheMessage("Puissance 4! "+model.getJ2()+" gagne");
                        fen.changerVersion(5);
                    }
                    compteurJetons++;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    fen.afficheMessage("Colonne pleine ,veuillez jouer ailleurs");
                }
            }
        }else {
                fen.afficheMessage("Egalite");
                fen.changerVersion(5);
        }
    }
}
