package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Main {
    private static final int PORT = 1155;
    UsersHandler usersHandler  = new UsersHandler(new UserAuthorizator(new UserDb()));

    public static void main(String[] args){
        new Main().run();
        System.out.println("server GG");
    }

    public Main() {}

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new UserThread(socket, usersHandler).start();

                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        } catch (IOException exc) {
            System.out.println("server GG");
            exc.printStackTrace();
        }
    }

}
