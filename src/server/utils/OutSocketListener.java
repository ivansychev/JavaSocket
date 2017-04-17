package server.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ivans on 17/04/2017.
 */
public class OutSocketListener implements Runnable {

    private PrintWriter out;
    private BufferedReader inu;

    public OutSocketListener(PrintWriter out, BufferedReader inu) {
        this.out = out;
        this.inu = inu;
    }

    @Override
    public void run() {
        String fuser;
        try {
            while ((fuser = inu.readLine())!=null)
            {
                if (fuser.equalsIgnoreCase("close")) break;
                if (fuser.equalsIgnoreCase("exit")) break;
                out.println(Thread.currentThread().getName() + " : " + fuser);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
