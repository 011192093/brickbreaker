import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class server {
    public static void main(String[] args) {


        try {
            ServerSocket server = new ServerSocket(1999);
            System.out.println("Waiting for client");
            ArrayList<gameclient> client = new ArrayList<>();
            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("connected");
                    gameclient handle = new gameclient(socket, client);
                    client.add(handle);
                    Thread t = new Thread(handle);
                    t.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
