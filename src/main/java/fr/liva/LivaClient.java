package fr.liva;

import fr.liva.launcher.LauncherPanel;
import fr.liva.view.ViewChat;
import fr.thomarz.TClientSocket;

import java.net.UnknownHostException;

public class LivaClient extends TClientSocket {

    private LauncherPanel panel;

    public LivaClient(String name, int port, LauncherPanel panel) throws UnknownHostException {
        super(name, port);
        this.panel = panel;
    }

    @Override
    public void onReceive(String message) {
        String channel = getChannel(message);
        String[] args = getArgs(message);

        if (channel.equalsIgnoreCase("Connect")) {
            System.out.println("a");
            ViewChat viewChat = (ViewChat) panel.getView(ViewChat.class);
            viewChat.getChatBox().setText(viewChat.getChatBox().getText() + "Connexion au serveur: " + args[0] + "\n");
        } else if (channel.equalsIgnoreCase("Chat")) {
            try {
                String msg = message.replaceFirst(channel + " ", "").replaceFirst(args[0] + " ", "");

                if (msg.length() == 0) {
                    return;
                }

                ViewChat viewChat = (ViewChat) panel.getView(ViewChat.class);
                viewChat.getChatBox().setText(viewChat.getChatBox().getText() + args[0] + ": " + msg + "\n");
            } catch (Exception e) {

            }
        }
    }
}
