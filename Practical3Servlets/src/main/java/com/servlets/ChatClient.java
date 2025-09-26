package com.servlets;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            System.out.println("Connected to Server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String messageFromServer, messageToServer;

            while (true) {
                System.out.print("Client: ");
                messageToServer = console.readLine();
                writer.println(messageToServer);

                if (messageToServer.equalsIgnoreCase("exit")) {
                    System.out.println("Client terminated chat.");
                    break;
                }

                messageFromServer = reader.readLine();

                if (messageFromServer == null || messageFromServer.equalsIgnoreCase("exit")) {
                    System.out.println("Server Disconnected..");
                    break;
                }
                System.out.println("Server: " + messageFromServer);
            }

            reader.close();
            writer.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
