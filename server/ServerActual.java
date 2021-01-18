import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ServerActual implements Runnable {

    static final int portNumber = 42069;
    public boolean running = false;
    ServerSocket ss;

    private List<ClientThread> clients;

    public ServerActual() {

    }

    @Override
    public void run() {
        start();
        while (running) {
            try {
                Socket socket = ss.accept();
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

    public List<ClientThread> getClients() {
        return clients;
    }

    public void serverSetup() {
        clients = new ArrayList<ClientThread>();
        try {
            this.ss = new ServerSocket(portNumber, 0, InetAddress.getLocalHost());
            System.out.println("Running server on port: "+ss.getLocalPort());
            //acceptClients(ss);
        } catch (IOException e) {
            System.err.println("Could not listen on port: "+portNumber);
            System.exit(1);
        }
    }

    public void start() {
        running = true;
        serverSetup();
    }

    public void stop() {
        try {
            if (running == true && !ss.isClosed()) {
                ss.close();
                ss = null;
                if (ss == null) {
                    System.out.println("Server successfully stopped!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
