package projekt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

    public class Logic extends JPanel implements ActionListener, KeyListener {
    public static volatile int Bit1Y = 120;
    private int Bit2Y = 120;
    private int BallPX = 283, BallPY = 155;
    private int BallX = 2, BallY = 3;
    private Timer time;

    public Logic() {
        addKeyListener(this);
        time = new Timer(10, this);
        setFocusable(true);
        time.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 400);
        g.setColor(Color.white);
        g.drawLine(290, 0, 290, 400);
        g.fillRect(0, Bit1Y, 10, 100);
        g.fillRect(572, Bit2Y, 10, 100);
        g.fillRect(BallPX, BallPY, 14, 14);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        BallPX += BallX;
        BallPY += BallY;
        if (BallPY < 0) {
            BallY = -BallY;
        }
        if (BallPY > 350) {
            BallY = -BallY;
        }
        if (new Rectangle(BallPX, BallPY, 14, 14).intersects(new Rectangle(0, Bit1Y, 10, 100))) {
            BallX = -BallX;
        }
        if (new Rectangle(BallPX, BallPY, 14, 14).intersects(new Rectangle(572, Bit2Y, 10, 100))) {
            BallX = -BallX;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 40) {
            Bit1Y += 5;

        }
        if (e.getKeyCode() == 38) {
            Bit1Y -= 5;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}