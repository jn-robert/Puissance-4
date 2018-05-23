import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {

    private Fenetre fen;

    public ControlMenu(){}

    public ControlMenu(Fenetre fen){
        this.fen=fen;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fen.getItemInterface1()){
            fen.changerVersion(1);
        }
        if (e.getSource() == fen.getItemInterface2()){
            fen.changerVersion(2);
        }
    }
}
