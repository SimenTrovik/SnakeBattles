package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    private String userName;
    private String serverHost;
    private int serverPort;

    public Client(String userName, String host, int portNumber){
        this.userName = userName;
        this.serverHost = host;
        this.serverPort = portNumber;
    }

    public void startClient(){
        try{
            InetAddress ip = InetAddress.getByName(serverHost);
            Socket socket = new Socket(ip.getHostAddress(), serverPort);
            Thread.sleep(1000); // waiting for network communicating.

            ServerThread serverThread = new ServerThread(socket, userName);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();
            while(serverAccessThread.isAlive()){

                   //do stuff

            }
        }catch(IOException ex){
            System.err.println("Fatal Connection error!");
            ex.printStackTrace();
        }catch(InterruptedException ex){
            System.out.println("Interrupted");
        }
    }

}