package fr.liva;

import fr.liva.launcher.LauncherPanel;
import fr.liva.view.ViewChat;
import fr.thomarz.TClientSocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LivaClient extends TClientSocket {

    private LauncherPanel panel;

    public LivaClient(String name, int port, LauncherPanel panel, InetAddress ip) throws UnknownHostException {
        super(name, port, ip);
        this.panel = panel;
    }

    @Override
    public void onReceive(String message) {
        String channel = getChannel(message);
        String[] args = getArgs(message);

        if (channel.equalsIgnoreCase("Leave")) {
            Main.livaClient = null;
            panel.refreshRightBox();
            panel.openWindow("Déconnection", message.replaceFirst(channel + " ", ""));
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
        } else if (channel.equalsIgnoreCase("Message")) {
            String msg = message.replaceFirst(channel + " ", "");

            ViewChat viewChat = (ViewChat) panel.getView(ViewChat.class);
            viewChat.getChatBox().setText(viewChat.getChatBox().getText() + msg + "\n");
        }
    }

    @Override
    public void onDisconnect() {
        super.onDisconnect();

        Main.livaClient = null;

        panel.refreshRightBox();

        panel.openWindow("Déconnection", "Vous avez été déconnecté du serveur.");

        ViewChat viewChat = (ViewChat) panel.getView(ViewChat.class);
        viewChat.getChatBox().setText("");
    }
}
