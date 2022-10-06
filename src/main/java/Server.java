import fr.thomarz.TServerSocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Server extends TServerSocket {

    public Server(int port) throws UnknownHostException {
        super("MyServer", port, InetAddress.getByName("127.0.0.1"));
    }

    @Override
    public void onReceive(String client, String message) {
        if (message.startsWith("Chat")) {
            sendMessage("*", message);
        }
    }
}
