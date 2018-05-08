import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    Image imgIut;
    JButton jbPartieClassique;
    ControlBoutonPartieClassique cbClassique;
    JLabel jlJjoeur1;
    JLabel jlJoeur2;
    JButton [] tabJetons;
    Fenetre(){
        setVisible(true);
        creerWidjetMenu();
        setMenu();
        pack();
    }

    public void creerWidjetMenu(){
        setTitle("Parametres de la partie ");
        imgIut=Toolkit.getDefaultToolkit().getImage("logoIut.jpg");
        setIconImage(imgIut);
        jbPartieClassique=new JButton("Partie Classqiue");
        cbClassique= new ControlBoutonPartieClassique(this);
        jbPartieClassique.addActionListener(cbClassique);
    }

    public void setMenu(){
        JPanel jpartieClassique= new JPanel();
        jpartieClassique.add(jbPartieClassique);

        setContentPane(jpartieClassique);




    }
    public void lancerPartie(int n){
        if (n==1){
            setVisible(true);
            partieClassique();
            pack();
        }
        else partiePersonnaliser();
    }

    public void partieClassique() {
        creerWidjetPartieClassique();
        placerWidjetPartieClassique();
        }


    public void creerWidjetPartieClassique() {
    jlJjoeur1=new JLabel("Joueur 1");
    jlJoeur2= new JLabel("Joueur 2");
    tabJetons = new JButton[5];


    }


    public void placerWidjetPartieClassique() {
        JPanel jPanelNom=new JPanel();
        jPanelNom.setLayout(new BoxLayout(jPanelNom,BoxLayout.Y_AXIS));
        jPanelNom.add(jlJjoeur1);
        jPanelNom.add(jlJoeur2);

        JPanel jPanelGrille = new JPanel();
        jPanelGrille.setLayout(new GridLayout(tabJetons.length,1));
        for(int i=0;i<tabJetons.length;i++){
            jPanelGrille.add(tabJetons[i]);
        }
        JPanel jPanelPuissance4 = new JPanel();
        jPanelPuissance4.setLayout(new BoxLayout(jPanelPuissance4,BoxLayout.Y_AXIS));

        setContentPane(jPanelPuissance4);

    }

    public void partiePersonnaliser(){
        creerWidjetMenu();

    }

}

