import java.net.*;

public class UDPServer {
        public static void main(String[] args) throws Exception {

                DatagramSocket server = new DatagramSocket(5001);

                System.out.println("UDP Server is running...");
                System.out.println("Waiting for message...");

                byte[] receiveData = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(
                                receiveData, receiveData.length);

                server.receive(receivePacket);

                String message = new String(
                                receivePacket.getData(),
                                0,
                                receivePacket.getLength());

                System.out.println("Client message: " + message);

                String reply = "Hello, UDP message received";
                byte[] sendData = reply.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                                sendData,
                                sendData.length,
                                receivePacket.getAddress(),
                                receivePacket.getPort());

                server.send(sendPacket);

                server.close();
        }
}
