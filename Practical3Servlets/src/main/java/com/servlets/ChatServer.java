package com.servlets;

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!!");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String messageFromClient, messageToClient;

            while (true) {
                messageFromClient = reader.readLine();

                if (messageFromClient == null || messageFromClient.equalsIgnoreCase("exit")) {
                    System.out.println("Client Disconnected..");
                    break;
                }
                System.out.println("Client: " + messageFromClient);

                System.out.print("Server: ");
                messageToClient = console.readLine();
                writer.println(messageToClient);

                if (messageToClient.equalsIgnoreCase("exit")) {
                    System.out.println("Server terminated chat.");
                    break;
                }
            }

            reader.close();
            writer.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
