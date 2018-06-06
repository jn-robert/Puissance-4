import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonMultijoueur implements ActionListener {
    Model model;
    Fenetre vue;

    public ButtonMultijoueur(Model model, Fenetre vue){
        this.model=model;
        this.vue=vue;
    }

    public void actionPerformed(ActionEvent e){
        try {
           int nbJoueur = Integer.parseInt(vue.getNbJoueur().getText());
           if (nbJoueur <= 6 && nbJoueur >= 3){
               model.multijoueur(nbJoueur);
           }
        } catch (NumberFormatException e1) {
            vue.afficheMessage("Il faut saisir des nombre entiers");
            return;
        }

        model.init();
        vue.changerVersion(7);
    }
}
