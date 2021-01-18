package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    //private static final int portNumber = 42069;
    //
    //private Socket socket = null;
    //
    //public Client() {
    //	try {
    //		InetAddress ip = InetAddress.getByName("fray.no");
    //		socket = new Socket(ip.getHostAddress(), portNumber);
    //		System.out.println("Connected to fray.no at port "+portNumber);
    //		sendMessage();
    //	} catch (IOException e) {
    //		System.err.println("Could not connect to server");
    //	}
    //}
    //
    //private void sendMessage() throws IOException {
    //	PrintWriter pr = new PrintWriter(socket.getOutputStream());
    //
    //	pr.println("Hello");
    //	pr.flush();
    //}

    private String userName;
    private String serverHost;
    private int serverPort;
    private Scanner userInputScanner;

    public Client(String userName, String host, int portNumber){
        this.userName = userName;
        this.serverHost = host;
        this.serverPort = portNumber;
    }

    public void startClient(Scanner scan){
        try{
            InetAddress ip = InetAddress.getByName(serverHost);
            Socket socket = new Socket(ip.getHostAddress(), serverPort);
            Thread.sleep(1000); // waiting for network communicating.

            ServerThread serverThread = new ServerThread(socket, userName);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();
            while(serverAccessThread.isAlive()){
                if(scan.hasNextLine()){
                    serverThread.addNextMessage(scan.nextLine());
                }
                // NOTE: scan.hasNextLine waits input (in the other words block this thread's process).
                // NOTE: If you use buffered reader or something else not waiting way,
                // NOTE: I recommends write waiting short time like following.
                // else {
                //    Thread.sleep(200);
                // }
            }
        }catch(IOException ex){
            System.err.println("Fatal Connection error!");
            ex.printStackTrace();
        }catch(InterruptedException ex){
            System.out.println("Interrupted");
        }
    }

}