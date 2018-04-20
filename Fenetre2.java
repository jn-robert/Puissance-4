import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Fenetre2 extends JFrame{
    private JLabel nbJ;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton br;
    private ControlBouton2 controlButonn;


    public Fenetre2(String s) {

        creerWidget();
        initAttribut();
        ajouterWidgetVersion1();

        setSize(280,280);                                // Fixe la taille par défaut
        setVisible(true);                                // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void creerWidget() {
        nbJ = new JLabel("Selectionnez la taille de la Grille  : ");

        b1 = new JButton("classique");
        b2 = new JButton(" 14 * 12 ");
        b3 = new JButton(" Personnalisé");
        br = new JButton("Retour");
        controlButonn = new ControlBouton2(this);
        br.addActionListener(controlButonn);

    }
    private  void initAttribut(){
    }
    private void ajouterWidgetVersion1(){
        JPanel pgrandPane1 = new JPanel(new GridLayout(5,3));
        Border border=BorderFactory.createTitledBorder("");
        pgrandPane1.setBorder(border);
        JPanel pgrand = new JPanel();
        JPanel pgrandM = new JPanel();

        pgrandPane1.add(nbJ);
        pgrandPane1.add(b1);
        pgrandPane1.add(b2);
        pgrandPane1.add(b3);
        pgrandPane1.add(br);

        pgrand.add(pgrandPane1);

        pgrandM.add(pgrand);

        setContentPane(pgrandM);
    }
}
