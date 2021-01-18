package client;

import java.util.Scanner;

public class ClientMain {

    private static final String host = "fray.no";
    private static final int portNumber = 42069;

    public static void main(String[] args) {

        String name = "p1";
        System.out.println("connecting as player 1");



        Client client = new Client(name, host, portNumber);
        client.startClient();
    }

}