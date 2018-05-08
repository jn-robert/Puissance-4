import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonJeton implements ActionListener {
    private static int jouer =0;
    Model model;
    Vue vue;

    public BoutonJeton(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        JButton jeton =(JButton)e.getSource();
        if(jouer%2==0){
            jeton.setIcon(vue.jetonRouge);
        }
        else jeton.setIcon(vue.jetonJaune);
        jouer++;
    }
}
