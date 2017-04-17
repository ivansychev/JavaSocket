package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ivans on 17/04/2017.
 */
public class StreamManager implements Runnable{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public StreamManager(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            StreamPool.getStreamPool().add(out);

            String msg;
            while (true) {
                if((msg = in.readLine()).isEmpty())
                {

                }
                else
                {
                    if (msg.equalsIgnoreCase("exit")) break;
                    synchronized (StreamPool.lock) {
                        for (PrintWriter p : StreamPool.getStreamPool()) {
                            if(!p.equals(out))
                            {
                                p.println(msg);
                            }
                        }
                    }
                    System.out.println(msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
