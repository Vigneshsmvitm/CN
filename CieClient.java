/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgclient;

/**
 *
 * @author Lab6
 */
import java.net.*;
import java.util.Scanner;

public class CieClient {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        // Ask user to enter a number
        System.out.print("Enter a number: ");
        String number = scanner.nextLine();

        sendData = number.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9000);
        clientSocket.send(sendPacket); // Send number to server

        // Receive cube result from server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String messageReceived = new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Cube received from server: " + messageReceived);

        clientSocket.close();
    }
}
