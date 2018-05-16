import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class ControlBouton implements ActionListener {
    Fenetre fen;
    Model model;



    public ControlBouton(Fenetre fen,Model model) {
        this.model=model;
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fen.getJoueurVsJoueur()){
            fen.changerVersion(2);
        }
        if (e.getSource() == fen.getUnJoueur()){
            fen.changerVersion(2);
        }
        if (e.getSource() == fen.getRetour()){
            fen.changerVersion(1);
        }

        if (e.getSource() == fen.getClassique()){
            fen.changerVersion(3);
        }
        if (e.getSource()==fen.getPerssonalise()){
            fen.changerVersion(4);
        }
        if (e.getSource()==fen.getQuitter()){
            System.exit(0);
        }
        if (e.getSource()==fen.getRecommencer()){
            fen.changerVersion(3);
        }




    }

}