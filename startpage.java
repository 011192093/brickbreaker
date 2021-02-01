import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class startpage {

    public static void main(String[] args) {

        JFrame frame=new JFrame("Brick Breaker");
        frame.setSize(600,500);
        //frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        frame.setContentPane(panel);

        JLabel label1 =new JLabel("Welcome to Brick-Breaker");
        label1.setFont(new Font("Serif", Font.BOLD, 40));
        label1.setBounds(50,50,500,50);

        JButton button1=new JButton("START PLAYING");
        button1.setBackground(Color.orange);
        button1.setFont(new Font("Serif", Font.BOLD, 30));
        button1.setBounds(100,150,380,50);

        JLabel label=new JLabel("Enter Your Name Here");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(105,220,250,50);

        JTextField field =new JTextField("unknown");
        field.setFont(new Font("Arial", Font.BOLD, 20));
        field.setBounds(320,230,150,30);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setBackground(Color.BLACK);



       panel.repaint();
       panel.add(label1);
       panel.add(button1);
       panel.add(label);
       panel.add(field);


       System.out.println(field.getText());

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            brick s = new brick(field.getText());


        }
    });




    }


}
