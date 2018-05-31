import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonJetonVsIA implements ActionListener {
    Model model;
    Fenetre fen;

    int tailleTab;
    static int compteurJetons=0;


    public BoutonJetonVsIA(Model model, Fenetre fen) {
        this.model = model;
        this.fen = fen;
        tailleTab = (model.getLargeurPuissance4())*(model.getLongeurPuissance4());
    }

    public void actionPerformed(ActionEvent e) {
        JButton jeton = (JButton) e.getSource();
        int j = Integer.parseInt(String.valueOf(jeton.getName()));
        if (compteurJetons< tailleTab) {
            if (model.isP1Ordi()) {
                int i = testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ1());
                    fen.dessine(i, j, fen.getJetonRouge());
                    if (!model.test(model.getGrille())) {
                        model.setP1Ordi(false);
                        model.setpOrdi(true);
                        fen.getJoueurCourant().setText("(IA) Jeton jaune joue");
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

            } else if (model.ispOrdi()) {
                int i = testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ2());
                    fen.dessine(i, j, fen.getJetonJaune());
                    if (!model.test(model.getGrille())){
                        model.setP1Ordi(true);
                        model.setpOrdi(false);
                        fen.getJoueurCourant().setText("(Vous) jeton rouge joue");
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

    public int testColonne(int colonne){
        int test = model.getLongeurPuissance4()-1;
        for (int i=model.getLongeurPuissance4()-1; i>=0; i--){
            if (model.getGrille()[i][colonne] != null){
                test--;
            }
        }
        return test;
    }


}
