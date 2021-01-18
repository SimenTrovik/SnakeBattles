package client;

import java.util.Scanner;

public class ClientMain {

    private static final String host = "fray.no";
    private static final int portNumber = 42069;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String readName = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input username:");
        while(readName == null || readName.trim().equals("")){
            // null, empty, whitespace(s) not allowed.
            readName = scan.nextLine();
            if(readName.trim().equals("")){
                System.out.println("Invalid. Please enter again:");
            }
        }

        Client client = new Client(readName, host, portNumber);
        client.startClient(scan);
    }

}