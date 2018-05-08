import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Vue extends JFrame {
    Model model;
    JButton[][] plateau;
    BoutonJeton2 boutonJeton2;
    ImageIcon jetonVide;
    ImageIcon jetonJaune;
    ImageIcon jetonRouge;
    JLabel joueurCourant;


    public Vue(Model model){
        this.model=model;
        creerWdijet();
        placerWidjet();
        setTitle("Puissance 4");
        pack();
        this.setVisible(true);

    }


    private void creerWdijet() {
        plateau = new JButton[6][7];
        boutonJeton2 = new BoutonJeton2(model,this);
        jetonVide = new ImageIcon("jetonVide.png");
        jetonJaune = new ImageIcon("jetonJaune.png");
        jetonRouge = new ImageIcon("jetonRouge.png");
        if (model.isP1()){
            joueurCourant= new JLabel("Joueur rouge commence");
        }
        else joueurCourant = new JLabel("joueur jaune commence");
    }

    private void placerWidjet() {
        JPanel puissance4 = new JPanel();
        puissance4.setLayout(new BoxLayout(puissance4,BoxLayout.Y_AXIS));
        JPanel nomJoeur = new JPanel();
        nomJoeur.add(joueurCourant);
        JPanel Jplateau= new JPanel();
        Jplateau.setLayout(new GridLayout(6,7));

         Dimension tailleJeton=new Dimension(60, 60);
        for(int i=0;i<plateau.length;i++){
            for(int j=0;j<plateau[i].length;j++){
                plateau[i][j] = new JButton();
                plateau[i][j].addActionListener(boutonJeton2);
                plateau[i][j].setPreferredSize(tailleJeton);
                plateau[i][j].setIcon(jetonVide);
                plateau[i][j].setBorderPainted(false);
                plateau[i][j].setName(i+";"+j);
                Jplateau.add(plateau[i][j]);

            }
        }
        puissance4.add(nomJoeur);
        puissance4.add(Jplateau);
        setContentPane(puissance4);
    }



}
