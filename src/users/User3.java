package users;

/**
 * Created by ivans on 17/04/2017.
 */
public class User3 {
    public static void main(String[] args) {
        new Thread(new EnableMsg(),"User3").start();
    }
}
