public class Appli {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                Fenetre vue = new Fenetre(model);
            }
        });
    }
}

