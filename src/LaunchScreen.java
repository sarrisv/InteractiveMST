package InteractiveMST;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LaunchScreen extends java.applet.Applet implements Runnable, MouseListener {

    Font title = new Font("Helvetica", Font.BOLD, 30);
    Font description = new Font("Helvetica", Font.PLAIN, 15);
    Font button = new Font("Helvetica", Font.PLAIN, 20);

    public void init() {
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(500, 300));
        setMinimumSize(new Dimension(500, 300));
        addMouseListener(this);
    }

    public void start() {
        Thread th = new Thread();
        th.start();
    }

    public void stop() {
        Main.runMST();
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fill3DRect(140, 200, 90, 30, true);
        g.fill3DRect(240, 200, 90, 30, true);

        g.setColor(Color.BLACK);
        g.setFont(title);
        g.drawString("Interactive", 170, 50);
        g.drawString("Minimum Spanning Tree", 75, 90);

        g.setFont(description);
        g.drawString("Move the nodes and the minimum spanning tree will update in real time", 20, 160);

        g.setFont(button);
        g.drawString("Begin", 160, 220);
        g.drawString("Settings", 250, 220);
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true) {
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 140 && e.getX() <= 230 && e.getY() >= 200 && e.getY() <= 230)
            stop();
        if (e.getX() >= 240 && e.getX() <= 330 && e.getY() >= 200 && e.getY() <= 230)
            MST.n = Integer.parseInt(JOptionPane.showInputDialog("How many nodes would you like?"));
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
