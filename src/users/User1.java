package users;

/**
 * Created by ivans on 17/04/2017.
 */
public class User1 {
    public static void main(String[] args) {
        new Thread(new EnableMsg(),"User1").start();
    }
}
