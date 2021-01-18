package client;

import javax.swing.*;

public class ClientFrame extends JFrame {
    ClientFrame() {
        this.add(new ClientPanel());
        this.setTitle("SnakeBattles");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
