package projekt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

public class Logic extends JPanel implements ActionListener, KeyListener {
    public static volatile int Bit1Y = 120;
    private int BallPX = 283, BallPY = 155;
    private int BallX = 2, BallY = 2;
    private Timer time;
    private int score = 0 ;
    private int level = 0 ;
    int timer = 10 ;
    public Logic() {
        addKeyListener(this);
        time = new Timer(timer, this);
        setFocusable(true);
    }
    String scr = "SCORE : " ;
    String lvl = "level : " ;
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 600, 400);
        g.setColor(Color.white);
        g.drawLine(290, 0, 290, 400);
        g.fillRect(0, Bit1Y, 10, 100);
        g.fillRect(572, 0, 10, 400);
        g.fillOval(BallPX, BallPY, 14, 14);
        Font f =  new Font("Arial",Font.BOLD,35);
        g.setFont(f);
        g.drawString(scr , 212 , 335);
        g.drawString(String.valueOf(score), 367 , 335);

        g.drawString(lvl , 225 , 40);
        g.drawString(String.valueOf(level/2), 334 , 40);

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
            score += 50 ;
            level += 1 ;
            BallX = -BallX;
        }
        if (new Rectangle(BallPX, BallPY, 14, 14).intersects(new Rectangle(572, 0, 10, 400))) {
            BallX = -(BallX+1);
        }
        if(BallPX < -20){
            time.stop();
            BallPX = 283;
            BallPY = 155;
            BallX = 2;
            BallY = 2;
            Bit1Y = 120;
            level = 0 ;
            score = 0 ;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    int a = 20 ;

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 40) {
            //System.out.println(0);
            Bit1Y += a;
            if(Bit1Y >= 262){
                Bit1Y = 262 ;
            }

        }
        if (e.getKeyCode() == 38) {
            //System.out.println(1);
            Bit1Y -= a;
            if(Bit1Y <= 0){
                Bit1Y = 0 ;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == 32){
            time.start();
            //System.out.println(2);
        }
        if(e.getKeyCode() == 27){
            time.stop();
            //System.out.println(3);
        }

    }
}