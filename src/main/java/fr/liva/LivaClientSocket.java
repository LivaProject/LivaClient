package fr.liva;

import fr.thomarz.TClientSocket;

import java.net.UnknownHostException;

public class LivaClientSocket extends TClientSocket {

    public LivaClientSocket(String name, int port) throws UnknownHostException {
        super(name, port);
    }

    public void onReceive(String message) {
        String channel = getChannel(message);
        String[] args = getArgs(message);

        if (channel.equalsIgnoreCase("Test")) {
            if (args.length == 1) {
                System.out.println("Le serveur vous a envoyé " + args[0]);
            }
        }
    }
}
