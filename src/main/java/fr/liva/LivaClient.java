package fr.liva;

import java.net.UnknownHostException;
import java.util.Scanner;

public class LivaClient {

    public static void main(String[] args) throws UnknownHostException {

        LivaClientSocket livaClientSocket = new LivaClientSocket("Client", 2222);

        livaClientSocket.sendMessage("Connected");
        livaClientSocket.sendMessage("OnlinePlayers");

        Scanner scanner = new Scanner(System.in);


        while (true) {
            String line = scanner.nextLine();

            livaClientSocket.sendMessage(line);
        }
    }
}
