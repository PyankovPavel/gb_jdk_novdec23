package practice.lesson1.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame {
    private static final int WINDOW_HEIGHT = 255;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 100;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");

    boolean isServerWorking;

    Server() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = true;
                System.out.println("Server is ON");
            }
        });
        add(btnStop);
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isServerWorking = false;
                System.out.println("Server is OFF");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Server();
    }
}
