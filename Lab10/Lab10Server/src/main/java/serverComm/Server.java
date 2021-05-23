package serverComm;

import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

@EqualsAndHashCode
public class Server {
    public static final int PORT = 8100;
    protected ServerSocket sSocket;
    protected List<String> users = new LinkedList<>();
    protected Map<Socket, String> login = new HashMap<>();
    protected Map<String, Set<String>> friendship = new HashMap<>();

    public Server() {
        try {
            sSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for client ...");
                Socket socket = sSocket.accept();
                socket.setSoTimeout(10 * 10000);
                // Execute the client's request in a new thread
                new ClientThread(socket, this).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}