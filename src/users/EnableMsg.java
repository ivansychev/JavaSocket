package users;

import server.utils.InSocketListener;
import server.utils.OutSocketListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ivans on 17/04/2017.
 */
public class EnableMsg implements Runnable {


    public EnableMsg() {
    }

    @Override
    public void run() {
        System.out.println("Welcome to Client side");

        Socket fromserver = null;
        BufferedReader in = null;
        PrintWriter out =null;
        BufferedReader inu = null;


        try {
            fromserver = new Socket("localhost", 5555);
            in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
            out = new PrintWriter(fromserver.getOutputStream(), true);
            inu = new BufferedReader(new InputStreamReader(System.in));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        new Thread(new OutSocketListener(out,inu),Thread.currentThread().getName()).start();
        new Thread(new InSocketListener(in),Thread.currentThread().getName()).start();
    }

}
