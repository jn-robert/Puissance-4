/**
 * Created by osalfran on 24/04/18.
 */
public class Appli {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                Model model = new Model();
                Vue vue = new Vue(model);
            }
        });
    }
}

