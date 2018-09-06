package ru.geekbrains.JavaCore2HW4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestChat extends JFrame {
    private JTextArea ChatMsgArea;
    private JTextField MsgField;

    public static void main(String[] args) {
        new TestChat().setVisible(true);
    }
    private TestChat() {
        init();
    }
    private void init() {
        setTitle("Test Chat");
        setBounds(300,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
        ChatMsgArea = new JTextArea();
        ChatMsgArea.setPreferredSize(new Dimension(400,400));
        add(ChatMsgArea);

        MsgField = new JTextField();
        MsgField.setToolTipText("Type your message here...");
        MsgField.addActionListener(e -> addMessage());

        JPanel BottomPanel = new JPanel();
        add(BottomPanel);
        BottomPanel.setLayout(new BoxLayout(BottomPanel, BoxLayout.X_AXIS));
        BottomPanel.add(MsgField);
        JButton SendButton = new JButton("Send");
        SendButton.addActionListener(e -> addMessage());
        BottomPanel.add(SendButton);

    }
    private void addMessage() {
        if (MsgField.getText().trim().isEmpty()) return;
        DateFormat df = new SimpleDateFormat("(HH:mm:ss)");
        ChatMsgArea.append("\n" + df.format(new Date())+ " : " + MsgField.getText());
        MsgField.setText("");
    }
}