package mobile.tiy.ironchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by danarchy on 5/11/16.
 */
public class WebChatClient {

    public String sendMessage(String userMessage) throws Exception {
        // connect to the server on the target port
        Socket clientSocket = new Socket("172.168.4.15", 8005);

        // once we connect to the server, we also have an input and output stream
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//        Scanner inputScanner = new Scanner(System.in);
//        while (true) {
//            System.out.print(">");
//            String userInput = inputScanner.nextLine();
            out.println(userMessage);


            String serverResponse; //This is where the client listens for the server's response
            while (true) {
                serverResponse = in.readLine();
                if (serverResponse != null && serverResponse.equalsIgnoreCase("server-done")) {
                    break;
                }
                System.out.println("Server::" + serverResponse);
                return serverResponse;
            }
//            if (userMessage.equalsIgnoreCase("exit")) {
//                break;
//            }
//        }

        // close the connection
        clientSocket.close();
        return serverResponse;
    }
}
