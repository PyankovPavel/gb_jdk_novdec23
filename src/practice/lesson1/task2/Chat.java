package practice.lesson1.task2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Chat extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 100;
    JLabel loginLabel = new JLabel("Login:");
    JTextField login = new JTextField();
    JLabel passwordLabel = new JLabel("Password:");
    JTextField password = new JTextField();
    JLabel serverIPLabel = new JLabel("Server IP:");
    JTextField serverIp = new JTextField();
    JLabel messageInputPLabel = new JLabel("Input your message:");
    JTextField messageInput = new JTextField();
    JTextArea messagesArea = new JTextArea();
    JButton sendMessage = new JButton("Send");
    JButton connectToServer = new JButton("Connect to server");
    JPanel upPanel = new JPanel(new GridLayout(2, 4));
    JPanel bottomPanel = new JPanel(new GridLayout(1, 4));
    String path = "src/practice/lesson1/task2/chatHistory";


    Chat() throws IOException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat");
        setResizable(true);
        upPanel.add(loginLabel);
        upPanel.add(login);
        upPanel.add(passwordLabel);
        upPanel.add(password);
        upPanel.add(serverIPLabel);
        upPanel.add(serverIp);
        upPanel.add(connectToServer);
        connectToServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                    String textFromFile = br.readLine();
                    while (textFromFile != null) {
                        textFromFile = textFromFile + "\n";
                        System.out.printf(textFromFile);
                        messagesArea.append(textFromFile);
                        textFromFile = br.readLine();
                    }
                } catch (IOException f) {
                    throw new RuntimeException(f);
                }
            }
        });
        add(upPanel, BorderLayout.NORTH);
        add(messagesArea);
        bottomPanel.add(messageInput);
        bottomPanel.add(sendMessage);
        messageInput.addKeyListener(new KeyAdapter() { // добавляем слушателя на Enter
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    messagesArea.append(login.getText() + ": " + messageInput.getText() + "\n");
                    try (FileWriter fw = new FileWriter(path, true)) {
                        fw.write(login.getText() + ": " + messageInput.getText() + "\n");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Log: " + login.getText() + " said: " + messageInput.getText());
                }
            }
        });
        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagesArea.append(login.getText() + ": " + messageInput.getText() + "\n");
                try (FileWriter fw = new FileWriter(path, true)) {
                    fw.write(login.getText() + ": " + messageInput.getText() + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Log: " + login.getText() + " said: " + messageInput.getText());
            }
        });
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new Chat();
    }
}
