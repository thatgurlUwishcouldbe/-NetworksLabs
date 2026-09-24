import java.io.*;
import java.net.*;

public class DNSServer {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3456);

        System.out.println("DNS Server is running on port 3456...");
        System.out.println("Waiting for client...");

        Socket client = server.accept();

        BufferedReader input = new BufferedReader(
                new InputStreamReader(client.getInputStream()));

        PrintWriter output = new PrintWriter(
                client.getOutputStream(), true);

        String website = input.readLine();
        String ipAddress;

        if (website.equalsIgnoreCase("www.stc.com.sa")) {
            ipAddress = "212.118.156.22";

        } else if (website.equalsIgnoreCase("www.ksu.edu.sa")) {
            ipAddress = "52.174.29.241";

        } else {
            ipAddress = "Website not found";
        }

        System.out.println("Website: " + website);
        System.out.println("IP Address: " + ipAddress);

        output.println(ipAddress);

        client.close();
        server.close();
    }
}
