import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
            fen.setNbJoueurs(true);
        }

        if (e.getSource() == fen.getUnJoueur()){
            fen.changerVersion(2);
            fen.setNbJoueurs(false);
        }

        if (e.getSource()==fen.getxJoueur()){
            fen.changerVersion(7);
        }

        if (e.getSource() == fen.getRetour() || e.getSource()== fen.getAcceuil()){
            fen.changerVersion(1);
        }

        if (e.getSource() == fen.getClassique() && fen.isNbJoueurs()){
            model.partieClassique();
            fen.changerVersion(3);
        }

        if (e.getSource() == fen.getClassique() && !fen.isNbJoueurs()){
            model.partieClassiqueIA();
            fen.changerVersion(6);
        }

        if (e.getSource()==fen.getPerssonalise() ){
            fen.changerVersion(4);
        }

        if (e.getSource()==fen.getValiderPartie()){
            fen.changerVersion(9);
        }

        if (e.getSource()==fen.getQuitter()){
            System.exit(0);
        }

        if (e.getSource()==fen.getRecommencer() && fen.isNbJoueurs()){
            model.reset();
            fen.changerVersion(3);
        }

        if (e.getSource()==fen.getRecommencer() && !fen.isNbJoueurs()){
            model.reset();
            fen.changerVersion(6);
        }
    }

}