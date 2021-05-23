package clientComm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Server's IP address
        int PORT = 8100; // Server's port
        // Send a request to the server
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Scanner scan = new Scanner(System.in);
            String command;
            //send the command for the server
            do {
                System.out.println("\nIntroduce a new command:");
                command = scan.nextLine();
                if (command.equalsIgnoreCase("read")) {
                    out.flush();
                } else {
                    out.println(command);
                    String response = in.readLine();
                    System.out.println(response);
                }
            } while (!command.equalsIgnoreCase("exit"));
            socket.shutdownInput();
        } catch (UnknownHostException e) {
            System.err.println("Server not responding" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
