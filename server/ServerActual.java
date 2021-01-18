import java.net.*;
import java.io.*;

public class ServerActual {

    static final int portNumber = 42069;

    public ServerActual() {
        try {
            ServerSocket ss = new ServerSocket(portNumber);
            Socket cs = ss.accept();
            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

    }

    public void stop() {

    }

}
