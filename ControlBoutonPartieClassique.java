import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBoutonPartieClassique extends Component implements ActionListener {

    Fenetre fen;
    ControlBoutonPartieClassique(){}

    ControlBoutonPartieClassique(Fenetre fen){
        this.fen=fen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==fen.jbPartieClassique){
            fen.lancerPartie(1);
        }
        else fen.lancerPartie(2);

    }
}
