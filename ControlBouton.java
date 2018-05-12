import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class ControlBouton implements ActionListener {
    Fenetre fen;
//    Fenetre2 fen2;

    public ControlBouton() {}

    public ControlBouton(Fenetre fen) {
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {
//        Fenetre2 fen2 = new Fenetre2("puissance 4");
//        fen2.setVisible(true);
//        fen.dispose();

        if (e.getSource() == fen.getBc()){
            fen.changerVersion(2);
        }
        if (e.getSource() == fen.getBc2()){
            fen.changerVersion(2);
        }

        if (e.getSource() == fen.getBr()){
            fen.changerVersion(1);
        }

        if (e.getSource() == fen.getB1()){
            fen.changerVersion(3);
        }

    }

}