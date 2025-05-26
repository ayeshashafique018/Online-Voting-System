package onlinevoting;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new FrontViewPage();
            }
        });
databsaeconnectivity d1 = new databsaeconnectivity();
       d1.Connectivity();
    }
}


