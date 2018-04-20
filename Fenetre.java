import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by ahoureux on 27/03/18.
 */

public class Fenetre extends JFrame {

    private JLabel nbJ;
    private JLabel ou;
    private JButton bc;
    private JButton bc2;
    private ControlBouton controlBut;


    public Fenetre() {

        creerWidget();
        initAttribut();
        ajouterWidgetVersion1();

        setSize(280,280);                                // Fixe la taille par défaut
        setVisible(true);                                // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void creerWidget() {

        // joueur
        bc = new JButton("1 joueur");
        controlBut = new ControlBouton(this);
        bc.addActionListener(controlBut);
        bc2 = new JButton("2 joueur");
        controlBut = new ControlBouton(this);
        bc2.addActionListener(controlBut);


        //Text
        nbJ = new JLabel("Nombre de Joueurs : ");
        ou = new JLabel("OU");


    }
    public void initAttribut(){

    }

    public void ajouterWidgetVersion1(){
        JPanel pgrandPanel = new JPanel(new GridLayout(5,3));
        JPanel pgiga = new JPanel();
        Border border=BorderFactory.createTitledBorder("");
        pgrandPanel.setBorder(border);


        pgrandPanel.add(nbJ);
        pgrandPanel.add(bc);
        pgrandPanel.add(ou);
        pgrandPanel.add(bc2);
        pgiga.add(pgrandPanel);

        setContentPane(pgiga);

    }
    }

