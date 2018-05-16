import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonPersonaliserPartie implements ActionListener {
    Fenetre fen;
    Model model;

    public BoutonPersonaliserPartie(Fenetre fen, Model model) {
        this.fen = fen;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            model.setLargeurPuissance4(Integer.parseInt(fen.getLargeur().getText()));
            model.setLongeurPuissance4(Integer.parseInt(fen.getLongeur().getText()));
        }
        catch (NumberFormatException e1){
            fen.afficheMessage("Il faut saisir des nombre entiers");
            return;
        }
        if (model.getLargeurPuissance4()<4 || model.getLargeurPuissance4()>20 ){
            fen.afficheMessage("la largeur doit etre comprise entre 4 et 20 ");
            return;
        }
        if (model.getLongeurPuissance4()<4 || model.getLongeurPuissance4()>20){
            fen.afficheMessage("la longeur doit etre comprise entre 4 et 20");
            return;
        }
        model.init();
        fen.changerVersion(3);
        }

    }

