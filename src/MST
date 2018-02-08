package InteractiveMST;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MST extends java.applet.Applet implements Runnable, MouseListener, MouseMotionListener {

    static int n = 10, x = -1;
    int[] sourceNode = new int[n];
    int[][] cords = new int[n][n], dist = new int[n][n];
    Algorithm algorithm = new Algorithm();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public void init() {
        setBackground(Color.DARK_GRAY);
        setPreferredSize(screenSize);
        setMinimumSize(screenSize);
        addMouseListener(this);
        addMouseMotionListener(this);
        gen();
    }

    public void start() {
        Thread th = new Thread(this);
        th.start();
    }

    public void stop() {

    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.PLAIN, 16));
        g.fill3DRect(5, 5, 200, 20, true);
        for (int i = 1; i < cords[0].length; i++)
            g.drawLine(cords[0][sourceNode[i]] + 15, cords[1][sourceNode[i]] + 15, cords[0][i] + 15, cords[1][i] + 15);
        for (int i = 0; i < cords[0].length; i++) {
            g.setColor(Color.WHITE);
            g.fillOval(cords[0][i], cords[1][i], 30, 30);
            g.setColor(Color.BLACK);
            g.drawString((i+1) + "", cords[0][i] + 11, cords[1][i] + 20);
        }
        g.drawString("Randomize Node Location", 10, 20);
    }

    public void run() {
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        while (true) {
            distMatrix();
            sourceNode = algorithm.primsAlgorithm(dist, n);
            repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {

            }
        }
    }

    public void gen() {
        Random ran = new Random();
        for (int j = 0; j < n; j++) {
            cords[0][j] = ran.nextInt(screenSize.width - 200) + 100;
            cords[1][j] = ran.nextInt(screenSize.height - 200) + 100;
        }
        distMatrix();
    }

    public void distMatrix() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = (int) Math.sqrt(Math.pow(cords[0][i] - cords[0][j], 2) + Math.pow(cords[1][i] - cords[1][j], 2));
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 5 && e.getX() <= 205 && e.getY() >= 5 && e.getY() <= 25)
            gen();
    }

    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < n; i++)
            if (e.getX() >= cords[0][i] && e.getX() <= cords[0][i] + 50 && e.getY() >= cords[1][i] && e.getY() <= cords[1][i] + 50)
                x = i;
    }

    public void mouseReleased(MouseEvent e) {
        x = -1;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        if (x != -1) {
            cords[0][x] = e.getX() - 15;
            cords[1][x] = e.getY() - 20;
        }
    }

    public void mouseMoved(MouseEvent e) {

    }
}
