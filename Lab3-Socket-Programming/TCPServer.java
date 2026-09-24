import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("Server is running...");
        System.out.println("Waiting for client...");

        Socket client = server.accept();

        BufferedReader input = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        PrintWriter output = new PrintWriter(
                client.getOutputStream(), true);

        String message = input.readLine();

        System.out.println("Client message: " + message);

        output.println("Hello, I received your message");

        client.close();
        server.close();
    }
}