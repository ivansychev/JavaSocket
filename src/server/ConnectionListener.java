package server;

import static utils.ConsoleHelper.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by ivans on 17/04/2017.
 */
public class ConnectionListener implements Runnable{

    private ServerSocket serverSocket;

    public ConnectionListener(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (true)
        {
            Socket socket;
            try {
                socket = serverSocket.accept();
                System.out.println(ANSI_BLUE + "New user connected: " + socket.getRemoteSocketAddress() + ANSI_RESET);
                new Thread(new StreamManager(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
