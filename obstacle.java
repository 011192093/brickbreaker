import java.awt.*;

public class obstacle {
    int  bricks [][];
    int i;
    int j;
    int  x=50;
    int y=60;
    int brick=0;

    int width;
    int height;

    public obstacle(int a,int b){
        bricks =new int[a][b];
        //System.out.println( bricks [0].length);
        for( i=0;i< bricks .length;i++){
            for( j=0;j< bricks [0].length;j++){
                bricks [i][j]=1;
               // System.out.print("inside 1st loop");
            }
            System.out.println();
        }
        width = 500/b;
        height = 200/a;



    }
    public void paint (Graphics g) {
        Graphics2D ad=(Graphics2D)g;
        //System.out.println( bricks .length + " " + bricks [0].length);
        for( i=0;i< bricks .length;i++){
            for( j=0;j< bricks [0].length;j++){
                if( bricks [i][j]>0){
                    GradientPaint color=new GradientPaint(0,0,Color.BLACK,520,0,Color.darkGray);
                    ad.setPaint(color);
                   ad.fillRect(j*width +x, i * height +y, width, height);

                    ad.setStroke(new BasicStroke(5));
                    ad.setPaint(Color.black);
                    ad.drawRect(j * width + x, i * height + y, width, height);

                }
            }
        }
    }

    public void invisible(int a,int b){

        bricks [a][b]=0;
    }
}
