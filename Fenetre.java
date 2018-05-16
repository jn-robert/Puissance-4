import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    private BoutonJeton boutonJeton;
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
// pour la fin de partie;
    private JButton recommencer;
    private JButton quitter;
    private JButton acceuil;

    public Fenetre(Model model) {
        this.model = model;
        creerWidget1();
        ajouterWidgetVersion1();
        pack();
        setTitle("Puissance 4");
        setVisible(true);
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

        classique.addActionListener(controlButon);
        perssonalise.addActionListener(controlButon);
        retour.addActionListener(controlButon);
    }

    public void creerWidjetChoixPartie(){
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
        plateau = new JButton[model.getLongeurPuissance4()][model.getLargeurPuissance4()];
        boutonJeton = new BoutonJeton(model,this);
        jetonVide = new ImageIcon("jetonVide.png");
        jetonJaune = new ImageIcon("jetonJaune.png");
        jetonRouge = new ImageIcon("jetonRouge.png");
        new Grille(model.getLongeurPuissance4(),model.getLargeurPuissance4());
        if (model.isP1()){
            joueurCourant= new JLabel("Joueur rouge commence");
        }
        else joueurCourant = new JLabel("joueur jaune commence");
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
        choixPartie.add(panelLargeur);
        choixPartie.add(panelLongeur);
        choixPartie.add(jvalider);
        setContentPane(choixPartie);
    }

    public void ajouterWidgetJeu(){
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
    }


    public void dessine(int i, int j, Icon ic){
        plateau[i][j].setIcon(ic);
    }


    public void afficheMessage(String msg){
        JOptionPane d = new JOptionPane();
        d.showMessageDialog(this, msg, "Message", JOptionPane.ERROR_MESSAGE);
        JDialog fenErr = d.createDialog(this, "Message");
    }
    public void display(){
        setVisible(true);
    }

    public void undisplay(){
        setVisible(false);
    }

    public void setBoutonJeton(BoutonJeton boutonJeton) {
        this.boutonJeton = boutonJeton;
    }

    public BoutonPersonaliserPartie getBoutonPersonaliserPartie() {
        return boutonPersonaliserPartie;
    }

    public void setBoutonPersonaliserPartie(BoutonPersonaliserPartie boutonPersonaliserPartie) {
        this.boutonPersonaliserPartie = boutonPersonaliserPartie;
    }

    public JButton getQuitter() {
        return quitter;
    }

    public void setQuitter(JButton quitter) {
        this.quitter = quitter;
    }

    public JButton getAcceuil() {
        return acceuil;
    }

    public void setAcceuil(JButton acceuil) {
        this.acceuil = acceuil;
    }

    public JButton getRecommencer() {
        return recommencer;
    }

    public void setRecommencer(JButton recommencer) {
        this.recommencer = recommencer;
    }

    public Model getModel() {
        return model;
    }

    public JLabel getTypePartie() {
        return typePartie;
    }

    public void setTypePartie(JLabel typePartie) {
        this.typePartie = typePartie;
    }

    public JButton getUnJoueur() {
        return unJoueur;
    }

    public void setUnJoueur(JButton unJoueur) {
        this.unJoueur = unJoueur;
    }

    public JButton getJoueurVsJoueur() {
        return joueurVsJoueur;
    }

    public void setJoueurVsJoueur(JButton joueurVsJoueur) {
        this.joueurVsJoueur = joueurVsJoueur;
    }

    public JLabel getParametrerLaPartie() {
        return parametrerLaPartie;
    }

    public void setParametrerLaPartie(JLabel parametrerLaPartie) {
        this.parametrerLaPartie = parametrerLaPartie;
    }

    public JButton getClassique() {
        return classique;
    }

    public void setClassique(JButton classique) {
        this.classique = classique;
    }

    public JButton getPerssonalise() {
        return perssonalise;
    }

    public void setPerssonalise(JButton perssonalise) {
        this.perssonalise = perssonalise;
    }

    public JButton getRetour() {
        return retour;
    }

    public void setRetour(JButton retour) {
        this.retour = retour;
    }

    public BoutonJeton getBoutonJeton() {
        return boutonJeton;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public JButton[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(JButton[][] plateau) {
        this.plateau = plateau;
    }

    public ImageIcon getJetonVide() {
        return jetonVide;
    }

    public void setJetonVide(ImageIcon jetonVide) {
        this.jetonVide = jetonVide;
    }

    public ImageIcon getJetonJaune() {
        return jetonJaune;
    }

    public void setJetonJaune(ImageIcon jetonJaune) {
        this.jetonJaune = jetonJaune;
    }

    public ImageIcon getJetonRouge() {
        return jetonRouge;
    }

    public void setJetonRouge(ImageIcon jetonRouge) {
        this.jetonRouge = jetonRouge;
    }

    public JLabel getJoueurCourant() {
        return joueurCourant;
    }

    public void setJoueurCourant(JLabel joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public JLabel getTailleGrille() {
        return tailleGrille;
    }

    public void setTailleGrille(JLabel tailleGrille) {
        this.tailleGrille = tailleGrille;
    }

    public JTextField getLargeur() {
        return largeur;
    }

    public void setLargeur(JTextField largeur) {
        this.largeur = largeur;
    }

    public JTextField getLongeur() {
        return longeur;
    }

    public void setLongeur(JTextField longeur) {
        this.longeur = longeur;
    }

    public JButton getValiderPartie() {
        return validerPartie;
    }

    public void setValiderPartie(JButton validerPartie) {
        this.validerPartie = validerPartie;
    }

    public JLabel getOu() {
        return ou;
    }

    public void setOu(JLabel ou) {
        this.ou = ou;
    }

    public ControlBouton getControlBut() {
        return controlBut;
    }

    public void setControlBut(ControlBouton controlBut) {
        this.controlBut = controlBut;
    }

    public ControlBouton getControlButon() {
        return controlButon;
    }

    public void setControlButon(ControlBouton controlButon) {
        this.controlButon = controlButon;
    }
}

