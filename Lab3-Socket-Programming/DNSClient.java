import java.io.*;
import java.net.*;

public class DNSClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();

            socket.bind(new InetSocketAddress(9876));
            socket.connect(new InetSocketAddress("127.0.0.1", 3456));

            PrintWriter writer = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("Enter your domain name:");
            String request = in.readLine();

            // Send website name to server
            writer.println(request);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Receive IP address from server
            String response = reader.readLine();

            System.out.println("Resolving your request: " + response.trim());

            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
