import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonJeton2 implements ActionListener {
    Model model;
    Vue vue;

    public BoutonJeton2(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    public int getColonne(JButton jeton){
        System.out.println(jeton.getName().charAt(2));
        return (int)jeton.getName().charAt(2);
    }


    public void actionPerformed(ActionEvent e) {
        JButton jeton = (JButton) e.getSource();
        if model.getJeu()getColonne(jeton)
    +







    }


}