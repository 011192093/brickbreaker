import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class bone extends JPanel implements KeyListener, ActionListener {
    Image i,i1;
    int initial_tray_pos=260;
    int initial_ball_xpos=100;
    int initial_ball_ypos=300;
    int ball_xspeed=1;
    int ball_yspeed=3;

    Timer timer;
    public bone(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        this.setPreferredSize(new Dimension(600,500));
        i=new ImageIcon("E:\\background.png").getImage();
        i1=new ImageIcon("E:\\background.png").getImage();

        timer=new Timer(2,this);
        timer.start();
    }
    public void paint (Graphics g){
        //background
        Graphics2D a=(Graphics2D)g;
        a.drawImage(i, 8, 0,null);
        a.drawImage(i1, 8, 130,null);
        //border
        a.setPaint(Color.ORANGE);
        a.fillRect(0,0, 7,500);
        a.fillRect(0,0, 600,7);
        a.fillRect(593,0, 7,500);
        a.fillRect(0, 493,600,7);
        //tray
        GradientPaint color=new GradientPaint(0,0,Color.YELLOW,420,0,Color.RED);
        a.setPaint(color);
        a.fillRect(initial_tray_pos, 450, 50,10);
        a.setStroke(new BasicStroke(3));
        a.setColor(Color.black);
        a.drawRect(initial_tray_pos, 450, 50,10);
        //ball
        GradientPaint color1=new GradientPaint(0,0,Color.BLUE,420,0,Color.ORANGE);
        a.setPaint(color1);
        a.fillOval(initial_ball_xpos,initial_ball_ypos,20,20);
        a.dispose();
    }


    @Override
    public void keyTyped(KeyEvent ke) { }
    @Override
    public void keyReleased(KeyEvent ke) { }


    @Override
    public void keyPressed(KeyEvent ke) {
        char press= ke.getKeyChar();
        if(press=='a'||press=='A'){
            if(initial_tray_pos>7){
                initial_tray_pos=initial_tray_pos-30;
                repaint();

            }
            else if(initial_tray_pos<=7){
                initial_tray_pos=7;
                repaint();
            }

        }
        else if(press=='d'||press=='D'){
            if(initial_tray_pos<543){
                initial_tray_pos=initial_tray_pos+30;
                repaint();
            }
            else if(initial_tray_pos>=543){
                initial_tray_pos=543;
                repaint();
            }
        }

    }



    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.start();
        if(new Rectangle(initial_ball_xpos,initial_ball_ypos,20,20).intersects(new Rectangle(initial_tray_pos, 450, 50,10)))
        {
            ball_yspeed=ball_yspeed*(-1);
            ball_xspeed=ball_xspeed*(-1);

        }
       if(initial_ball_xpos>=573){
            ball_xspeed=ball_xspeed*(-1);
        }
        if(initial_ball_xpos<=7){
            ball_xspeed=ball_xspeed*(-1);
        }
        initial_ball_xpos= initial_ball_xpos+ball_xspeed;
        if(initial_ball_ypos>=473){
            ball_yspeed=ball_yspeed*(-1);
        }
        if(initial_ball_ypos<=7){
            ball_yspeed=ball_yspeed*(-1);
        }
        initial_ball_ypos= initial_ball_ypos+ball_yspeed;
        repaint();
    }


}
