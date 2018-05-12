import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Fenetre extends JFrame {

    private JLabel nbJ;
    private JLabel ou;
    private JButton bc;
    private JButton bc2;
    private ControlBouton controlBut;


    private JLabel nbJ2;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton br;
    private ControlBouton controlButon;

    Model model;
    JButton[][] plateau;
    BoutonJeton2 boutonJeton2;
    ImageIcon jetonVide;
    ImageIcon jetonJaune;
    ImageIcon jetonRouge;
    JLabel joueurCourant;


    public Fenetre(Model model) {

        this.model = model;

        creerWidget1();
        ajouterWidgetVersion1();

//        setSize(280,280);                                // Fixe la taille par défaut
        pack();
        setTitle("Puissance 4");
        setVisible(true);                                // Affiche la fenetre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void creerWidget1() {

        // joueur
        bc = new JButton("1 joueur");
        controlBut = new ControlBouton(this);
        bc.addActionListener(controlBut);
        bc2 = new JButton("2 joueur");
        controlBut = new ControlBouton(this);
        bc2.addActionListener(controlBut);


        //Text
        nbJ = new JLabel("Nombre de Joueurs : ");
        ou = new JLabel("OU");


    }

    public void creerWidget2(){
        nbJ2 = new JLabel("Selectionnez la taille de la Grille  : ");

        b1 = new JButton("classique");
        b2 = new JButton(" 14 * 12 ");
        b3 = new JButton(" Personnalisé");
        br = new JButton("Retour");

        controlButon = new ControlBouton(this);

        b1.addActionListener(controlButon);
        br.addActionListener(controlButon);
    }

    public void creerJeu(){
        plateau = new JButton[6][7];
        boutonJeton2 = new BoutonJeton2(model,this);
        jetonVide = new ImageIcon("jetonVide.png");
        jetonJaune = new ImageIcon("jetonJaune.png");
        jetonRouge = new ImageIcon("jetonRouge.png");
        if (model.isP1()){
            joueurCourant= new JLabel("Joueur rouge commence");
        }
        else joueurCourant = new JLabel("joueur jaune commence");
    }



    public void ajouterWidgetVersion1(){
        JPanel pgrandPanel = new JPanel(new GridLayout(5,3));
        JPanel pgiga = new JPanel();
        Border border=BorderFactory.createTitledBorder("");
        pgrandPanel.setBorder(border);


        pgrandPanel.add(nbJ);
        pgrandPanel.add(bc);
        pgrandPanel.add(ou);
        pgrandPanel.add(bc2);
        pgiga.add(pgrandPanel);

        setContentPane(pgiga);

    }

    public void ajouterWidgetVersion2(){
        JPanel pgrandPane1 = new JPanel(new GridLayout(5,3));
        Border border=BorderFactory.createTitledBorder("");
        pgrandPane1.setBorder(border);
        JPanel pgrand = new JPanel();
        JPanel pgrandM = new JPanel();

        pgrandPane1.add(nbJ);
        pgrandPane1.add(b1);
        pgrandPane1.add(b2);
        pgrandPane1.add(b3);
        pgrandPane1.add(br);

        pgrand.add(pgrandPane1);

        pgrandM.add(pgrand);

        setContentPane(pgrandM);
    }

    public void ajouterWidgetJeu(){
        JPanel puissance4 = new JPanel();
        puissance4.setLayout(new BoxLayout(puissance4,BoxLayout.Y_AXIS));
        JPanel nomJoeur = new JPanel();
        nomJoeur.add(joueurCourant);
        JPanel Jplateau= new JPanel();
        Jplateau.setLayout(new GridLayout(6,7));

        Dimension tailleJeton=new Dimension(60, 60);
        for(int i=0;i<plateau.length;i++){
            for(int j=0;j<plateau[i].length;j++){
                plateau[i][j] = new JButton();
                plateau[i][j].addActionListener(boutonJeton2);
                plateau[i][j].setPreferredSize(tailleJeton);
                plateau[i][j].setIcon(jetonVide);
                plateau[i][j].setBorderPainted(false);
                plateau[i][j].setName(i+";"+j);
                Jplateau.add(plateau[i][j]);

            }
        }
        puissance4.add(nomJoeur);
        puissance4.add(Jplateau);
        setContentPane(puissance4);
    }

    public void changerVersion(int n){
        if (n == 1){
            creerWidget1();
            ajouterWidgetVersion1();
            pack();
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (n == 2){
            creerWidget2();
            ajouterWidgetVersion2();
            pack();
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (n == 3){
            creerJeu();
            ajouterWidgetJeu();
            pack();
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }


    public void dessine(int i, int j, Icon ic){
        plateau[i][j].setIcon(ic);
    }


    public void afficheErreur(String msgErreur){
        JOptionPane d = new JOptionPane();
        d.showMessageDialog(this, msgErreur, "Message", JOptionPane.ERROR_MESSAGE);
        JDialog fenErr = d.createDialog(this, "Message");
    }


    public JLabel getNbJ() {
        return nbJ;
    }

    public void setNbJ(JLabel nbJ) {
        this.nbJ = nbJ;
    }

    public JLabel getOu() {
        return ou;
    }

    public void setOu(JLabel ou) {
        this.ou = ou;
    }

    public JButton getBc() {
        return bc;
    }

    public void setBc(JButton bc) {
        this.bc = bc;
    }

    public JButton getBc2() {
        return bc2;
    }

    public void setBc2(JButton bc2) {
        this.bc2 = bc2;
    }

    public ControlBouton getControlBut() {
        return controlBut;
    }

    public void setControlBut(ControlBouton controlBut) {
        this.controlBut = controlBut;
    }

    public JLabel getNbJ2() {
        return nbJ2;
    }

    public void setNbJ2(JLabel nbJ2) {
        this.nbJ2 = nbJ2;
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JButton getB2() {
        return b2;
    }

    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    public JButton getB3() {
        return b3;
    }

    public void setB3(JButton b3) {
        this.b3 = b3;
    }

    public JButton getBr() {
        return br;
    }

    public void setBr(JButton br) {
        this.br = br;
    }

    public ControlBouton getControlButon() {
        return controlButon;
    }

    public void setControlButon(ControlBouton controlButon) {
        this.controlButon = controlButon;
    }
}

