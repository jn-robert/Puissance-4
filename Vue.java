import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Vue extends JFrame {
    Model model;
    JButton[][] plateau;
    BoutonJeton boutonJeton;
    ImageIcon jetonVide;
    ImageIcon jetonJaune;
    ImageIcon jetonRouge;

    public Vue(Model model){
        this.model=model;
        creerWdijet();
        placerWidjet();
        setTitle("Puissance 4");
        pack();
        this.setVisible(true);

    }


    private void creerWdijet() {
        plateau = new JButton[7][6];
        boutonJeton = new BoutonJeton(model,this);
        jetonVide = new ImageIcon("jetonVide.png");
        jetonJaune = new ImageIcon("jetonJaune.png");
        jetonRouge = new ImageIcon("jetonRouge.png");
    }

    private void placerWidjet() {
        JPanel Jplateau= new JPanel();
        Jplateau.setLayout(new GridLayout(7,6));

         Dimension tailleJeton=new Dimension(60, 60);
        for(int i=0;i<plateau.length;i++){
            for(int j=0;j<plateau[i].length;j++){
                plateau[i][j] = new JButton();
                plateau[i][j].addActionListener(boutonJeton);
                plateau[i][j].setPreferredSize(tailleJeton);
                plateau[i][j].setIcon(jetonVide);
                plateau[i][j].setBorderPainted(false);
                Jplateau.add(plateau[i][j]);

            }
        }
        setContentPane(Jplateau);
    }



}
