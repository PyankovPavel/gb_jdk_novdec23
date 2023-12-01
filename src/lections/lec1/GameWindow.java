package lections.lec1;

import practice.lesson1.task1.Map;
import practice.lesson1.task1.SettingsWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 100;

    JButton start = new JButton("New Game");
    JButton exit = new JButton("Exit");

    Map map;
    SettingsWindow settings;

    GameWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Krestiks vs Noliks");
        setResizable(false);
        map = new Map();
        settings = new SettingsWindow(this);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelBottom.add(start);
        panelBottom.add(exit);
        add(panelBottom, BorderLayout.SOUTH);
        add(map);

        setVisible(true);
    }

    public void startNewGame(int mode, int fSizeX, int fSizeY, int winLen) {
        map.startNewGame(mode, fSizeX, fSizeY, winLen);
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}


