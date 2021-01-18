import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerActual {

    static final int portNumber = 42069;
    private boolean running = false;
    ServerSocket ss = null;

    private List<ClientThread> clients;

    public ServerActual() {
        clients = new ArrayList<ClientThread>();
        try {
            this.ss = new ServerSocket(portNumber, 0, InetAddress.getLocalHost());
            System.out.println("Running server on port: "+ss.getLocalPort());
            acceptClients(ss);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+portNumber);
            System.exit(1);
        }
    }

    public List<ClientThread> getClients() {
        return clients;
    }

    public void testSocket(Socket s) {
        while(running) {
            if (s.isConnected()) {
                System.out.println("Socket is connected");
                break;
            }
        }
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    private void acceptClients(ServerSocket serverSocket) {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                //System.out.println("accepts : " + socket.getRemoteSocketAddress());
                System.out.println("Client connected!");

                ClientThread client = new ClientThread(this, socket);
                Thread thread = new Thread(client);
                thread.start();
                clients.add(client);

            } catch (IOException ex) {
                System.out.println("Accept failed on : "+portNumber);
            }
        }
    }

}
