import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Player {
    String name;
    int score;

    public Player(String name, int  score) {
        this.name = name;
        this.score = score;
    }
}

public class gameclient implements Runnable {
    BufferedWriter writer;
    BufferedReader reader;
    ArrayList<gameclient> client;
    String name;
    File file;
    ArrayList<Player> bat;
    public gameclient(Socket socket, ArrayList<gameclient> client) {
        try {
            file=new File("E:\\final.txt");
             bat=new ArrayList<>();
            OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());

            writer = new BufferedWriter(osw);
            reader = new BufferedReader(isr);


            this.client = client;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("hi")) {

                    String one=reader.readLine();
                    String two=reader.readLine();
                    int twwo=Integer.parseInt(two);
                    System.out.println(line+" "+one+" "+two);
                    BufferedReader r;
                    try {
                        r = new BufferedReader(new FileReader(file));
                        String s;

                        Scanner sc = new Scanner(file);
                        Player person;
                        int count=0;
                        while(sc.hasNext()){
                            String name = sc.next();
                            String scoree = sc.next();
                            int scor = Integer.parseInt(scoree);
                            if(name.matches(one)){
                                if(twwo<=scor){
                                    System.out.println("matched with "+name+",wil not enter");
                                    person=new Player (name,scor);
                                    bat.add(person);
                                    count++;
                                }
                                else{
                                    person=new Player (name,twwo);
                                    bat.add(person);
                                    count++;
                                }
                            }
                            else{
                                person=new Player (name,scor);
                                bat.add(person);
                            }

                        }
                        if(count==0){
                            person=new Player (one,twwo);
                            bat.add(person);
                        }

                        System.out.println();

                        
                        for(Player p:bat){
                            System.out.println(p.name+" "+p.score);
                        }


                        bat.sort(new Comparator<Player>(){
                            @Override
                            public int compare(Player t, Player t1) {
                                if(t.score > t1.score){//big to small
                                    return -1;
                                }
                                else if(t.score < t1.score){
                                    return 1;
                                }
                                else
                                    return 0;
                            }

                        });


                        PrintWriter q=new PrintWriter(file);
                        q.print("");
                        q.close();

                        System.out.println();
                        for(Player p:bat){
                            PrintWriter writer1 = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                            writer1.println(p.name +" "+p.score);
                            writer1.close();
                        }


                        sc.close();
                        System.out.println();
                        while ((s = r.readLine()) != null) {

                            String str[] = s.split(" ");

                            String z = str[0];
                            String y = str[1];

                            System.out.println(z + " " + y);
                            writer.write(z + " " + y + "\n");
                            writer.flush();

                        }


                        r.close();

                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }


                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}