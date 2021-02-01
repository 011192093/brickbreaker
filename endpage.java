import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;



public class endpage {

    JLabel button2;
    JButton top;
    JTextArea area;
    String nam;
    String score;
    OutputStreamWriter osw;


    public endpage(String name, String a) {
        nam = "name";
        score = "a";
        //System.out.println(a);
        JFrame f = new JFrame();
        f.setSize(615, 540);
        f.setVisible(true);


        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        f.setContentPane(panel);

        JButton button = new JButton("play again?");
        button.setBackground(Color.cyan);
        button.setFont(new Font("Serif", Font.BOLD, 40));
        button.setBounds(170, 30, 240, 70);
        panel.add(button);

        top = new JButton("click here to see Today's top scorers!!!");
        top.setBackground(Color.cyan);
        top.setFont(new Font("Serif", Font.BOLD, 30));
        top.setBounds(30, 180, 520, 40);
        panel.add(top);

        area = new JTextArea();
        area.setFont(new Font("Arial", Font.BOLD, 20));
        area.setBackground(Color.PINK);
        area.setBounds(30, 230, 520, 200);
        area.setText("top scorers:");

        area.setEditable(false);
        area.setVisible(false);
        panel.add(area);


        if (Integer.parseInt(a) == 180) {
            button2 = new JLabel("You won, your score is " + a);
        } else {
            button2 = new JLabel("Sorry,You lost, your score is " + a);
        }
        button2.setBackground(Color.PINK);
        button2.setFont(new Font("Arial", Font.BOLD, 20));
        button2.setBounds(130, 100, 370, 50);
        panel.add(button2);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println(name);
                brick s = new brick(name);
            }
        });

        try {
            Socket socket = new Socket("127.0.0.1", 1999);
            System.out.println("connected to server");


            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            BufferedWriter writer = new BufferedWriter(osw);
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);



            top.addActionListener(new ActionListener() {
                boolean count= true;
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count == true) {
                        area.setVisible(true);
                        try {
                            writer.write("hi" + "\n");
                            writer.write(name + "\n");
                            writer.write(a + "\n");
                            System.out.println("hi");
                            writer.flush();

                            String a = reader.readLine();
                            area.setText(area.getText() + "\n" + a);
                            String b = reader.readLine();
                            area.setText(area.getText() + "\n" + b);
                            String c = reader.readLine();
                            area.setText(area.getText() + "\n" + c);
                            String d = reader.readLine();
                            area.setText(area.getText() + "\n" + d);
                            String f = reader.readLine();
                            area.setText(area.getText() + "\n" + f);


                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        count=false;
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

