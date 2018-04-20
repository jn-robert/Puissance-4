import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class ControlBouton implements ActionListener {
    Fenetre fen;
    Fenetre2 fen2;

    public ControlBouton(Fenetre2 fenetre2) {
    }

    public ControlBouton(Fenetre fen) {
        this.fen = fen;
    }

    public void actionPerformed(ActionEvent e) {
        Fenetre2 fen2 = new Fenetre2("puissance 4");
        fen2.setVisible(true);
        fen.dispose();

    }

}