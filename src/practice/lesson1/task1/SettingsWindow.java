package practice.lesson1.task1;

import lections.lec1.GameWindow;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 430;
    private static final int WINDOW_WIDTH = 350;
    private static final int MIN_MAP_SIZE = 3;
    private static final int MAX_MAP_SIZE = 10;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MAX_WIN_LENGTH = 10;
    JButton start = new JButton("Start new game");
    ButtonGroup btnGroupOfGameModes = new ButtonGroup();
    JRadioButton humVsAi = new JRadioButton("Human vs AI");
    JRadioButton humVsHum = new JRadioButton("Human vs Human");
    JLabel mapSize = new JLabel("Choose size of the map");
    JLabel winLength = new JLabel("Choose win length");
    JSlider mapSizeSlider = new JSlider(MIN_MAP_SIZE, MAX_MAP_SIZE, MIN_MAP_SIZE);
    JSlider winLengthSlider = new JSlider(MIN_WIN_LENGTH, MAX_WIN_LENGTH, MIN_WIN_LENGTH);


    public SettingsWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Game Settings");
        add(start, BorderLayout.SOUTH);
        JPanel panelOfSettings = new JPanel(new GridLayout(10, 1));
        add(panelOfSettings, BorderLayout.NORTH);
        panelOfSettings.add(new JLabel("Choose game mode"));
        btnGroupOfGameModes.add(humVsAi);
        btnGroupOfGameModes.add(humVsHum);
        panelOfSettings.add(humVsAi);
        humVsAi.setSelected(true);
        panelOfSettings.add(humVsHum);
        panelOfSettings.add(mapSize);
        panelOfSettings.add(mapSizeSlider);
        mapSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mapSize.setText("Map size is: " + mapSizeSlider.getValue());
            }
        });
        panelOfSettings.add(winLength);
        panelOfSettings.add(winLengthSlider);
        winLengthSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winLength.setText("Win Length is: " + winLengthSlider.getValue());
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(humVsAi.isSelected() ? 0 : 1, mapSizeSlider.getValue(),
                        mapSizeSlider.getValue(), winLengthSlider.getValue());
                setVisible(false);
            }
        });
    }
}
