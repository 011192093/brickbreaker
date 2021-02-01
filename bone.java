
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class bone extends JPanel implements KeyListener, ActionListener {
    Image i,i1;
     int initial_tray_pos=250;
    int initial_ball_xpos=100;
    int initial_ball_ypos=300;
    int ball_xspeed=1;
    int ball_yspeed=2;
    public int score=0;
    boolean start=true;
    String a;
    


    endpage e;
    obstacle ob;
    Timer timer;
    String n;

    public String getN() {
        return n;
    }

    public bone(String name){

        n=name;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        this.setPreferredSize(new Dimension(600,500));
        i=new ImageIcon("E:\\background.png").getImage();
        i1=new ImageIcon("E:\\background.png").getImage();

        timer=new Timer(5,this);
        timer.start();

        ob=new obstacle(6,6);
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
        GradientPaint color=new GradientPaint(0,0,Color.RED,400,0,Color.magenta);
        a.setPaint(color);
        a.fillRect(initial_tray_pos, 450, 100,10);
        a.setStroke(new BasicStroke(3));
        a.setColor(Color.black);
        a.drawRect(initial_tray_pos, 450, 100,10);
        //score show

        a.setPaint(Color.orange);
        a.setFont(new Font("Arial",Font.BOLD,20));
        a.drawString(String.valueOf(getN()+", "+"SCORE:"+score),50,50);
        //ball
        GradientPaint color1=new GradientPaint(0,0,Color.BLUE,420,0,Color.ORANGE);
        a.setPaint(color1);
        a.fillOval(initial_ball_xpos,initial_ball_ypos,20,20);
        //obstacles
        ob.paint((Graphics2D) g);
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
                initial_tray_pos=initial_tray_pos-15;
                repaint();

            }
            else if(initial_tray_pos<=7){
                initial_tray_pos=7;
                repaint();
            }

        }
        else if(press=='d'||press=='D'){
            if(initial_tray_pos<493){
                initial_tray_pos=initial_tray_pos+15;
                repaint();
            }
            else if(initial_tray_pos>=493){
                initial_tray_pos=493;
                repaint();
            }
        }

    }



    @Override
    public void actionPerformed(ActionEvent ae) {

        if (start == true) {
            //timer.start();
            //checking score
            if (score == 180) {
                System.out.println("won"+" "+score);
                start=false;
                 a=score+"";

                e=new endpage(getN(),a);
            }
            //bouncing from tray
            if (new Rectangle(initial_ball_xpos, initial_ball_ypos, 20, 20).intersects(new Rectangle(initial_tray_pos, 450, 100, 10))) {
                ball_yspeed = ball_yspeed * (-1);
                //ball_xspeed = ball_xspeed * (-1);

            }

            //bouncing off borders

            if (initial_ball_xpos >= 573) {
                ball_xspeed = ball_xspeed * (-1);
            }
            if (initial_ball_xpos <= 7) {
                ball_xspeed = ball_xspeed * (-1);
            }
            initial_ball_xpos = initial_ball_xpos + ball_xspeed;

            if (initial_ball_ypos <= 7) {
                ball_yspeed = ball_yspeed * (-1);
            }
            if (initial_ball_ypos >= 473) {
                //ball_yspeed=ball_yspeed*(-1);
                System.out.println("failed" + " " + score);
                start=false;
                 a= score+"";
               // String comment=" sorry, you lost, your score is "+a;

                System.out.println(getN());
                e=new endpage(getN(),a);
            }

            //finding obstacle
            for (int k = 0; k < ob.bricks.length; k++) {
                for (int l = 0; l < ob.bricks[0].length; l++) {
                    if (ob.bricks[k][l] > 0) {
                        int bh = ob.height;
                        int bw = ob.width;
                        int bxpos = l * ob.width + ob.x;
                        int bypos = k * ob.height + ob.y;

                        if (new Rectangle(initial_ball_xpos, initial_ball_ypos, 20, 20).intersects(new Rectangle(bxpos, bypos, bw, bh))) {
                            //ball_xspeed=ball_xspeed*(-1);
                            ball_yspeed = ball_yspeed * (-1);
                            ob.invisible(k, l);
                            score = score + 5;
                        }

                    }
                }
            }

            initial_ball_ypos = initial_ball_ypos + ball_yspeed;
            initial_ball_xpos = initial_ball_xpos + ball_xspeed;
            repaint();
        }
    }



}

