package project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class Logic extends JPanel implements ActionListener, KeyListener {
    public static volatile int Bit1Y = 120;
    private int Bit2Y = 120;
    private int BallPX = 283, BallPY = 155;
    private int BallX = 2, BallY = 2;

    private int score = 0 ;
    JLabel scoree = new JLabel(String.valueOf(score));
    private Timer time;

    public Logic() {
        addKeyListener(this);
        time = new Timer(10, this);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 400);
        g.setColor(Color.white);
        g.drawLine(290, 0, 290, 400);
        g.fillRect(0, Bit1Y, 10, 100);
        g.fillRect(572, 0, 10, 400);
        g.fillRect(BallPX, BallPY, 14, 14);
    }
    int BallConst = BallY;
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
        if (new Rectangle(BallPX, BallPY, 14, 14).intersects(new Rectangle(572, 0, 10, 400))) {
            BallX = -BallX;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 40) {
            System.out.println(0);
            Bit1Y += 10;
            if(Bit1Y >= 262){
                Bit1Y = 262 ;
            }

        }
        if (e.getKeyCode() == 38) {
            System.out.println(1);
            Bit1Y -= 10;
            if(Bit1Y <= 0){
                Bit1Y = 0 ;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 32){
            time.start();
            System.out.println(2);
        }
    }
}