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
public class DGClient
{
    public static void main(String[] args) throws Exception 
    {
        String line = "connected with client";
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        sendData = line.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9000);
        clientSocket.send(sendPacket);
        System.out.println("******client display terminal******");
        while(true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String messageReceived = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
            System.out.println("Message received from server is: " + messageReceived);
        }
    }
}
