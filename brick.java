import javax.swing.*;

public class brick {
    public static void main(String[] args) {

        JFrame frame=new JFrame("Brick Breaker");
        frame.setSize(600,500);
        bone work=new bone();
        frame.add(work);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

}
