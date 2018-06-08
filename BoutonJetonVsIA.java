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
        if (compteurJetons< tailleTab) {
            if (model.isP1Ordi()) {
                JButton jeton = (JButton) e.getSource();
                int j = Integer.parseInt(String.valueOf(jeton.getName()));
                int i = model.testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ1());
                    fen.dessine(i, j, fen.getJetonRouge());
                    if (!model.test(model.getGrille())) {
                        model.setP1Ordi(false);
                        model.setpOrdi(true);
                        fen.getJoueurCourant().setText("(IA) Jeton jaune joue");
//                        try {
//                            Thread.currentThread().sleep(2000);
//                        }
//                        catch (InterruptedException exInt) {}
                        j=model.coupsIA();
                        model.setTroisDangerAligne(false);
                        i = model.testColonne(j);
                        model.getGrille();
                        model.rempli(i, j, model.getJ2());
                        fen.dessine(i, j, fen.getJetonJaune());
                        if (!model.test(model.getGrille())){
                            model.setP1Ordi(true);
                            model.setpOrdi(false);
                            fen.getJoueurCourant().setText("(Vous) jeton rouge joue");
                            return;
                        }else{
                            fen.afficheMessage("Puissance 4! IA gagne");
                            fen.changerVersion(5);
                        }
                        compteurJetons++;
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
            }
        }else {
            fen.afficheMessage("Egalite");
            fen.changerVersion(5);
        }
    }
}
