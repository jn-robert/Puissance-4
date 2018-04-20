import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.compare;
import static java.lang.Double.parseDouble;

public class ControlBouton2 implements ActionListener {
    Fenetre2 fen2;
    Fenetre fen;

    public ControlBouton2() {
    }

    public ControlBouton2(Fenetre2 fen2) {
        this.fen2 = fen2;
    }

    public void actionPerformed(ActionEvent e) {
        Fenetre fen = new Fenetre();
        fen.setVisible(true);
        fen2.dispose();

    }

}
