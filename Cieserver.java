/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgserver;

/**
 *
 * @author Lab6
 */
import java.net.*;

public class Cieserver {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9000);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.println("---- Server is running ----");

        // Receive number from client
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String receivedNumber = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("Number received from client: " + receivedNumber);

        int number = Integer.parseInt(receivedNumber.trim());
        int cube = number * number * number;

        String cubeString = Integer.toString(cube);
        sendData = cubeString.getBytes();

        // Send cube back to client
        InetAddress clientAddress = receivePacket.getAddress();
        int clientPort = receivePacket.getPort();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
        serverSocket.send(sendPacket);

        System.out.println("Cube sent to client: " + cubeString);

        serverSocket.close();
    }
}
