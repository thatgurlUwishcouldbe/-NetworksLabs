import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        BufferedReader userInput = new BufferedReader(
                new InputStreamReader(System.in));

        DatagramSocket client = new DatagramSocket();

        System.out.print("Write a message: ");
        String message = userInput.readLine();

        byte[] sendData = message.getBytes();

        InetAddress address = InetAddress.getByName("localhost");

        DatagramPacket sendPacket = new DatagramPacket(
                sendData, sendData.length, address, 5001);

        client.send(sendPacket);

        byte[] receiveData = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(
                receiveData, receiveData.length);

        client.receive(receivePacket);

        String reply = new String(
                receivePacket.getData(),
                0,
                receivePacket.getLength());

        System.out.println("Server reply: " + reply);

        client.close();
    }
}
