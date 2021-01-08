import java.awt.*;

public class obstacle {
    int map[][];
    int i;
    int j;
    int  x=50;
    int y=50;
    int brick=0;
    public obstacle(int a,int b){
        map=new int[a][b];
        System.out.println(map[0].length);
        for( i=0;i<map.length;i++){
            for( j=0;j<map[0].length;j++){
                map[i][j]=1;
                System.out.print("hi");
            }
            System.out.println();
        }
        System.out.println(map.length);

    }
    public void paint (Graphics g) {
        Graphics2D ad=(Graphics2D)g;
        System.out.println(map.length + " " +map[0].length);
        for( i=0;i<map.length;i++){
            for( j=0;j<map[0].length;j++){
                if(map[i][j]>0){
                    brick++;
                    ad.setPaint(Color.RED);
                    ad.fillRect(x, y, 50, 20);
                    ad.setPaint(Color.BLACK);
                    ad.setStroke(new BasicStroke(3));
                    ad.drawRect(x, y, 50, 20);
                    System.out.print("i");
                }

                x=x+50;


            }

            y=y+30;
            x=50;
            System.out.println();

        }
        System.out.println(brick);
    }
}
