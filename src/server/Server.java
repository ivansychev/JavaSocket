package server;


import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by ivans on 17/04/2017.
 */
public class Server {

    private ServerSocket serverSocket;
    private ConnectionListener connectionListener;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.connectionListener = new ConnectionListener(this.serverSocket);
        new Thread(new ConnectionListener(serverSocket)).start();
    }
}
