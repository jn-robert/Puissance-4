import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {

    private BoutonJeton boutonJeton;
    private BoutonJetonVsIA boutonJetonVsIA;
    private BoutonPersonaliserPartie boutonPersonaliserPartie;
 // Bouton pour la premiere fenetre ( Joueur vs Ia ou joueur vs joueurs)
    private JLabel  typePartie;
    private JLabel ou;
    private JButton unJoueur;
    private JButton joueurVsJoueur;
    private ControlBouton controlBut;

// Bouton pour la seconde fenetre ou on choisi le type de partie( classique ou personnaliser)
    private JLabel parametrerLaPartie;
    private JButton classique;
    private JButton perssonalise;
    private JButton retour;
    private ControlBouton controlButon;
// Bouton pour le jeu
    private Model model;
    private JButton[][] plateau;
    private ImageIcon jetonVide;
    private ImageIcon jetonJaune;
    private ImageIcon jetonRouge;
    private JLabel joueurCourant;
// pour parametrer la partie
    private JLabel tailleGrille;
    private JTextField largeur;
    private JTextField longeur;
    private JButton validerPartie;
    private JLabel labelLargeur;
    private JLabel labelLongeur;
    private JLabel nbrParties;
    private JRadioButton unePartie;
    private JRadioButton troisPartie;
    private JRadioButton cinqPartie;
    private ButtonGroup boutonNbrparties;
// pour la fin de partie;
    private JButton recommencer;
    private JButton quitter;
    private JButton acceuil;

//    Menu
    private JMenuItem itemInterface1;
    private JMenuItem itemInterface2;
    private ControlMenu controlMen;
    private JMenuBar barMenu;
    private JMenu menu;

    private boolean nbJoueurs;

    public Fenetre(Model model) {
        this.model = model;
        creerWidget1();
        ajouterWidgetVersion1();
        pack();
        setTitle("Puissance 4");
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void creerWidget1() {

        unJoueur = new JButton("Joueur vs ordinateur");
        controlBut = new ControlBouton(this,model);
        unJoueur.addActionListener(controlBut);
        joueurVsJoueur= new JButton("Joueur vs Joueur");
        controlBut = new ControlBouton(this,model);
        joueurVsJoueur.addActionListener(controlBut);

        typePartie = new JLabel("Type de partie :");
        ou = new JLabel("OU");


    }
    public void creerWidget2(){
        parametrerLaPartie = new JLabel("Porfil de la partie :");

        classique = new JButton("classique");
        perssonalise = new JButton(" Personnalisé");
        retour = new JButton("Retour");

        controlButon = new ControlBouton(this,model);
//        controlKey = new ControlKey(model,this);

        classique.addActionListener(controlButon);
        perssonalise.addActionListener(controlButon);
        retour.addActionListener(controlButon);
//        retour.addKeyListener(controlButon);
    }

    public void creerWidjetChoixPartie(){
        nbrParties = new JLabel("Nombre de parties pour gagner : ");
        boutonNbrparties = new ButtonGroup();
        cinqPartie = new JRadioButton("5");
        troisPartie = new JRadioButton("3");
        unePartie = new JRadioButton("1",true);
        boutonNbrparties.add(unePartie);
        boutonNbrparties.add(troisPartie);
        boutonNbrparties.add(cinqPartie);
        labelLargeur = new JLabel("Nombre de colonnes :");
        labelLongeur = new JLabel("Profondeur des colonnes :");
        boutonPersonaliserPartie = new BoutonPersonaliserPartie(this,model);
        tailleGrille = new JLabel("Taille de votre plateau de jeux :");
        largeur = new JTextField("");
        largeur.setColumns(10);
        longeur = new JTextField("");
        largeur.setColumns(10);
        validerPartie = new JButton("Valider");
    }

    public void creerJeu(){
        //        Menu
        itemInterface1 = new JMenuItem("Retour choix joueurs");

        itemInterface2 = new JMenuItem("Retour choix partie");

        controlMen = new ControlMenu(this);
        itemInterface1.addActionListener(controlMen);
        itemInterface2.addActionListener(controlMen);

        plateau = new JButton[model.getLongeurPuissance4()][model.getLargeurPuissance4()];
        boutonJeton = new BoutonJeton(model,this);
        jetonVide = new ImageIcon("jetonVide.png");
        jetonJaune = new ImageIcon("jetonJaune.png");
        jetonRouge = new ImageIcon("jetonRouge.png");
        new Grille(model.getLongeurPuissance4(),model.getLargeurPuissance4());
        if (model.isP1()){
            joueurCourant= new JLabel("Joueur rouge commence");
        }
        if (model.isP2()) {
            joueurCourant = new JLabel("joueur jaune commence");
        }
    }

    public void creerJeuIA(){
        //        Menu
        itemInterface1 = new JMenuItem("Retour choix joueurs");

        itemInterface2 = new JMenuItem("Retour choix partie");

        controlMen = new ControlMenu(this);
        itemInterface1.addActionListener(controlMen);
        itemInterface2.addActionListener(controlMen);

        plateau = new JButton[model.getLongeurPuissance4()][model.getLargeurPuissance4()];
        boutonJetonVsIA = new BoutonJetonVsIA(model,this);
        jetonVide = new ImageIcon("jetonVide.png");
        jetonJaune = new ImageIcon("jetonJaune.png");
        jetonRouge = new ImageIcon("jetonRouge.png");
        new Grille(model.getLongeurPuissance4(),model.getLargeurPuissance4());
        if (model.isP1Ordi()){
            joueurCourant = new JLabel("(Vous) joueur rouge commence");
        }
        if (model.ispOrdi()){
            joueurCourant = new JLabel("(IA) joueur jaune commence");
        }
    }

    public void creerWidjetFin(){
        acceuil = new JButton("Accueil");
        recommencer = new JButton("Rejouer");
        quitter = new JButton("Quitter");
        recommencer.addActionListener(controlButon);
        quitter.addActionListener(controlButon);
        acceuil.addActionListener(controlButon);
    }

    public void ajouterWidgetVersion1(){
        JPanel pgrandPanel = new JPanel(new GridLayout(5,3));
        JPanel pgiga = new JPanel();
        Border border=BorderFactory.createTitledBorder("");
        pgrandPanel.setBorder(border);


        pgrandPanel.add(typePartie);
        pgrandPanel.add(unJoueur);
        pgrandPanel.add(ou);
        pgrandPanel.add(joueurVsJoueur);
        pgiga.add(pgrandPanel);

        setContentPane(pgiga);

    }

    public void ajouterWidgetVersion2(){
        JPanel pgrandPane1 = new JPanel(new GridLayout(5,3));
        Border border=BorderFactory.createTitledBorder("");
        pgrandPane1.setBorder(border);
        JPanel pgrand = new JPanel();
        JPanel pgrandM = new JPanel();

        pgrandPane1.add(parametrerLaPartie);
        pgrandPane1.add(classique);
        pgrandPane1.add(perssonalise);
        pgrandPane1.add(retour);

        pgrand.add(pgrandPane1);

        pgrandM.add(pgrand);

        setContentPane(pgrandM);
    }

    public void ajouterWidjetChoixPartie(){
        JPanel panelNbrPartie = new JPanel();
        JPanel panelLargeur = new JPanel();
        JPanel panelLongeur = new JPanel();
        JPanel choixPartie = new JPanel();
        JPanel jvalider = new JPanel();
        choixPartie.setLayout(new BoxLayout(choixPartie,1));
        panelLargeur.setLayout(new BoxLayout(panelLargeur,0));
        panelLongeur.setLayout(new BoxLayout(panelLongeur,0));
        validerPartie.addActionListener(boutonPersonaliserPartie);
        panelLargeur.add(labelLargeur);
        panelLargeur.add(largeur);
        panelLongeur.add(labelLongeur);
        panelLongeur.add(longeur);
        jvalider.add(validerPartie);
        jvalider.add(retour);
        panelNbrPartie.add(nbrParties);
        panelNbrPartie.add(unePartie);
        panelNbrPartie.add(troisPartie);
        panelNbrPartie.add(cinqPartie);
        choixPartie.add(panelLargeur);
        choixPartie.add(panelLongeur);
        choixPartie.add(panelNbrPartie);
        choixPartie.add(jvalider);
        setContentPane(choixPartie);
    }

    public void ajouterWidgetJeu(){
        creerMenu();
        JPanel puissance4 = new JPanel();
        puissance4.setLayout(new BoxLayout(puissance4,BoxLayout.Y_AXIS));
        JPanel nomJoeur = new JPanel();
        nomJoeur.add(joueurCourant);
        JPanel Jplateau= new JPanel();
        Jplateau.setLayout(new GridLayout(model.getLongeurPuissance4(),model.getLargeurPuissance4()));
        Dimension tailleJeton=new Dimension(60, 60);
        for(int i=0;i<model.getLongeurPuissance4();i++){
            for(int j=0;j<model.getLargeurPuissance4();j++){
                plateau[i][j] = new JButton();
                plateau[i][j].addActionListener(boutonJeton);
                plateau[i][j].setIcon(jetonVide);
                plateau[i][j].setPreferredSize(tailleJeton);
                plateau[i][j].setBorderPainted(false);
                plateau[i][j].setName(""+j);
                Jplateau.add(plateau[i][j]);

            }
        }
        puissance4.add(nomJoeur);
        puissance4.add(Jplateau);
        setContentPane(puissance4);
    }

    public void ajouterWidgetJeuvsIA(){
        creerMenu();
        JPanel puissance4 = new JPanel();
        puissance4.setLayout(new BoxLayout(puissance4,BoxLayout.Y_AXIS));
        JPanel nomJoeur = new JPanel();
        nomJoeur.add(joueurCourant);
        JPanel Jplateau= new JPanel();
        Jplateau.setLayout(new GridLayout(model.getLongeurPuissance4(),model.getLargeurPuissance4()));
        Dimension tailleJeton=new Dimension(60, 60);
        for(int i=0;i<model.getLongeurPuissance4();i++){
            for(int j=0;j<model.getLargeurPuissance4();j++){
                plateau[i][j] = new JButton();
                plateau[i][j].addActionListener(boutonJetonVsIA);
                plateau[i][j].setIcon(jetonVide);
                plateau[i][j].setPreferredSize(tailleJeton);
                plateau[i][j].setBorderPainted(false);
                plateau[i][j].setName(""+j);
                Jplateau.add(plateau[i][j]);

            }
        }
        puissance4.add(nomJoeur);
        puissance4.add(Jplateau);
        setContentPane(puissance4);
    }
    public void ajouterWidjetFin(){
        JPanel jPanel = new JPanel();
        jPanel.add(quitter);
        jPanel.add(recommencer);
        jPanel.add(acceuil);
        setContentPane(jPanel);
    }

    public void changerVersion(int n){
        if (n == 1){
            creerWidget1();
            ajouterWidgetVersion1();
            pack();
            setTitle("Puissance4");
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (n == 2){
            creerWidget2();
            ajouterWidgetVersion2();
            pack();
            setTitle("Puissance4");
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (n == 3){
            creerJeu();
            ajouterWidgetJeu();
            pack();
            setTitle("Puissance4");
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (n==4){
            creerWidjetChoixPartie();
            ajouterWidjetChoixPartie();
            pack();
            setTitle("Puissance4");
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(n==5){
            creerWidjetFin();
            ajouterWidjetFin();
            pack();
            setTitle("Puissance4");
            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if (n==6){
            creerJeuIA();
            ajouterWidgetJeuvsIA();
            setTitle("Puissance 4");
//            setResizable(false);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

    public void creerMenu(){

        barMenu = new JMenuBar();
        menu = new JMenu("Options");

        menu.add(itemInterface1);
        menu.add(itemInterface2);

        barMenu.add(menu);
        setJMenuBar(barMenu);
    }

    public JMenuItem getItemInterface1() {
        return itemInterface1;
    }

    public JMenuItem getItemInterface2() {
        return itemInterface2;
    }


    public void dessine(int i, int j, Icon ic){
        plateau[i][j].setIcon(ic);
    }


    public void afficheMessage(String msg){
        JOptionPane d = new JOptionPane();
        d.showMessageDialog(this, msg, "Message", JOptionPane.ERROR_MESSAGE);
        JDialog fenErr = d.createDialog(this, "Message");
    }

    public JRadioButton getUnePartie() {
        return unePartie;
    }

    public JRadioButton getTroisPartie() {
        return troisPartie;
    }

    public JRadioButton getCinqPartie() {
        return cinqPartie;
    }

    public JButton getQuitter() { return quitter; }

    public JButton getAcceuil() { return acceuil; }

    public JButton getRecommencer() { return recommencer; }

    public JButton getUnJoueur() {
        return unJoueur;
    }

    public JButton getJoueurVsJoueur() {
        return joueurVsJoueur;
    }

    public JButton getClassique() {
        return classique;
    }

    public JButton getPerssonalise() {
        return perssonalise;
    }

    public JButton getRetour() {
        return retour;
    }

    public ImageIcon getJetonJaune() {
        return jetonJaune;
    }

    public ImageIcon getJetonRouge() {
        return jetonRouge;
    }

    public JLabel getJoueurCourant() {
        return joueurCourant;
    }

    public JTextField getLargeur() {
        return largeur;
    }

    public JTextField getLongeur() {
        return longeur;
    }

    public boolean isNbJoueurs() { return nbJoueurs; }

    public void setNbJoueurs(boolean nbJoueurs) { this.nbJoueurs = nbJoueurs; }
}

