import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonJeton2 implements ActionListener {
    Model model;
    Vue vue;

    int tailleTab;
    static int compteurJetons=0;


    public BoutonJeton2(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
        tailleTab = (model.getGrille().length)*(model.getGrille()[0].length);

    }

    public void actionPerformed(ActionEvent e) {
        JButton jeton = (JButton) e.getSource();
        int j = Integer.parseInt(String.valueOf(jeton.getName().charAt(2)));
        int posi = Integer.parseInt(String.valueOf(jeton.getName().charAt(0)));
        if (!model.test(posi, j, model.getGrille()) && compteurJetons< tailleTab) {
            if (model.isP1()) {
                int i = testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ1());
                    vue.dessine(i, j, vue.jetonRouge);
                    if (!model.test(posi, j,model.getGrille())) {
                        model.setP1(false);
                        model.setP2(true);
                        return;
                    }else {
                        System.out.println("gagnee");
                        vue.afficheErreur(model.getJ1()+" gagne");
                        System.exit(0);
                    }
                    compteurJetons++;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    vue.afficheErreur("Colonne pleine ,veuillez jouer ailleurs");
                    return;
                }

//            model.afficheGrille();
                vue.joueurCourant.setText("Jeton jaune joue");
            } else if (model.isP2()) {
                int i = testColonne(j);
                try {
                    model.getGrille();
                    model.rempli(i, j, model.getJ2());
                    vue.dessine(i, j, vue.jetonJaune);
                    if (!model.test(posi, j,model.getGrille())){
                        model.setP1(true);
                        model.setP2(false);
                        return;
                    }else {
                        System.out.println("gagnee");
                        vue.afficheErreur(model.getJ2()+" gagne");
                        System.exit(0);
                    }
                    compteurJetons++;
                } catch (ArrayIndexOutOfBoundsException ex) {
                    vue.afficheErreur("Colonne pleine ,veuillez jouer ailleurs");
                }
//            model.afficheGrille();
                vue.joueurCourant.setText("jeton rouge joue");
            }
        }else {
//            if (model.test(posi, j, model.getGrille()) && model.isP1()){
//                vue.afficheErreur(model.getJ1()+" gagne");
//            }if (model.test(posi, j, model.getGrille()) && model.isP2()){
//                vue.afficheErreur(model.getJ2()+" gagne");
//            }else {
                vue.afficheErreur("Egalite");
                System.exit(0);
//            }
        }
    }

    public int testColonne(int colonne){
        int test = vue.plateau.length-1;
        for (int i=vue.plateau.length-1; i>=0; i--){
            if (model.getGrille()[i][colonne] != null){
                test--;
            }
        }
        return test;
    }


}