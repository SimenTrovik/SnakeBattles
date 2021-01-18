import javax.swing.*;
import java.awt.*;

public class ServerPanel extends JPanel {

    static final int SCREEN_WIDTH = 500;
    static final int SCREEN_HEIGHT = 300;

    ServerActual server;

    ServerPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setFocusable(true);

        JPanel topBtnsPanel = new JPanel();
        topBtnsPanel.setLayout(new BoxLayout(topBtnsPanel, BoxLayout.LINE_AXIS));

        JButton startBtn = new JButton("Start server");
        startBtn.addActionListener(e -> startServer());
        JButton stopBtn = new JButton("Stop server");
        stopBtn.addActionListener(e -> stopServer());

        topBtnsPanel.add(startBtn);
        topBtnsPanel.add(stopBtn);

        this.add(topBtnsPanel);

        server = new ServerActual();
    }

    private void startServer() {
        System.out.println("Starting server!");
        server.start();
    }

    private void stopServer() {
        System.out.println("Stopping server!");
        server.stop();
    }
}
