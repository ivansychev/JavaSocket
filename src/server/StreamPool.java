package server;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivans on 17/04/2017.
 */
public class StreamPool {
    private static Set<PrintWriter> streamPool = new HashSet<>();
    public static Object lock = new Object();

    public static Set<PrintWriter> getStreamPool() {
        return streamPool;
    }
}
