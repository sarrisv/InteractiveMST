package InteractiveMST;

import javax.swing.*;

public class Main {

    static JFrame f = new JFrame("Interactive Algorithm application");

    public static void main(String[] args) {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaunchScreen launch = new LaunchScreen();

        f.getContentPane().add(launch);
        launch.init();
        launch.start();
        f.pack();
        f.setResizable(true);
        f.setVisible(true);
    }

    public static void runMST() {
        f.setVisible(false);
        MST interactiveMST = new MST();
        
        f.getContentPane().removeAll();
        f.getContentPane().add(interactiveMST);
        interactiveMST.init();
        interactiveMST.start();
        f.pack();
        f.setVisible(true);
    }
}
