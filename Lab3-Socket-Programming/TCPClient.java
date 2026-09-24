import java.io.*;
import java.net.*;

public class TCPClient {
        public static void main(String[] args) throws Exception {

                BufferedReader userInput = new BufferedReader(
                                new InputStreamReader(System.in));

                Socket socket = new Socket("localhost", 5000);

                BufferedReader input = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));

                PrintWriter output = new PrintWriter(
                                socket.getOutputStream(), true);

                System.out.print("Write a message: ");
                String message = userInput.readLine();

                output.println(message);

                String reply = input.readLine();

                System.out.println("Server reply: " + reply);

                socket.close();
        }
}