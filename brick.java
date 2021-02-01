import javax.swing.*;

public class brick extends JFrame{
    bone work;
    brick(String name){
        System.out.println(name);
         work=new bone(name);
         this.add(work);

        this.setSize(600,500);
        this.setVisible(true);
        this.pack();

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
