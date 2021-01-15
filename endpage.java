import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class endpage extends JFrame {
    //brick work;
       public endpage(String name,String a){
           System.out.println(a);
        //work=new brick();
       // this.add(work);
        this.setSize(615,540);
        this.setVisible(true);
        //this.pack();

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        this.setContentPane(panel);
        JButton button=new JButton("start again?");
           button.setBackground(Color.cyan);
           button.setFont(new Font("Serif", Font.BOLD, 40));
        button.setBounds(170,30,240,70);
        panel.add(button);

           JButton button2=new JButton(a);
           button2.setBackground(Color.PINK);
           button2.setFont(new Font("Arial", Font.BOLD, 20));
           button2.setBounds(120,100,370,50);
           panel.add(button2);




        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(name);
                brick s=new brick(name);
            }
        });

    }


}
