import javax.swing.*;

public class ServerFrame extends JFrame {

    ServerFrame() {
        this.add(new ServerPanel());
        this.setTitle("Server");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
