package practice.lesson2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ServerRun extends JFrame implements Listener {
    private static final int WINDOW_HEIGHT = 100;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");
    JButton btnExit = new JButton("Exit");
    ServerListener server = new Server(this);

    public ServerRun() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ServerRun");
        setResizable(false);

        JPanel panelServer = new JPanel(new GridLayout(1, 2));
        panelServer.add(btnStart);
        panelServer.add(btnStop);
        add(panelServer, BorderLayout.CENTER);

        JPanel panelExit = new JPanel();
        panelExit.add(btnExit);
        add(panelExit, BorderLayout.SOUTH);

        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverListener(true);
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.serverListener(false);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ServerRun();
    }

    @Override
    public void messageRes(String text) {
        System.out.println(text);
    }
}
