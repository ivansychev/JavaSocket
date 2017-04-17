package server.utils;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by ivans on 17/04/2017.
 */
public class InSocketListener implements Runnable {
    BufferedReader in ;

    public InSocketListener(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        String fserver;
        try {
            while ((fserver = in.readLine())!=null)
            {
                System.out.println(fserver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
