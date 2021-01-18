package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ClientPanel extends JPanel{
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 800;

    ClientPanel() {

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

    }




    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    System.out.println("LEFT");
                    break;
                case KeyEvent.VK_RIGHT:
                    System.out.println("RIGHT");
                    break;
                case KeyEvent.VK_UP:
                    System.out.println("UP");
                    break;
                case KeyEvent.VK_DOWN:
                    System.out.println("DOWN");
                    break;

            }
        }
    }
}
