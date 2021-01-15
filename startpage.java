import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startpage {//extends JFrame {

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

        JButton button1=new JButton("start");
        button1.setBackground(Color.orange);
        button1.setFont(new Font("Arial", Font.BOLD, 40));
        button1.setBounds(215,50,150,50);

        JLabel label=new JLabel("Enter your name here");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBounds(100,120,250,50);

        JTextField field =new JTextField("...");
        field.setFont(new Font("Arial", Font.BOLD, 20));
        field.setBounds(310,130,150,30);


       panel.repaint();
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
