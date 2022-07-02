package com.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.*;
import java.awt.*;

public class Login {
    JFrame frame = new JFrame("Hello world");
    private JPanel loginBox = new JPanel();
    private JTextField uField = new JTextField();
    private JPasswordField pField = new JPasswordField();
    private JLabel message = new JLabel();

    public Login() {
        loginBox = loginBox();

        frame.setLayout(new GridLayout(3, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(Constrains.X, Constrains.Y, Constrains.WIDTH, Constrains.HEIGHT);

        JLabel head = new JLabel();
        head.setText("Hello world");
        head.setFont(new Font(Font.DIALOG, Font.BOLD, 28));
        head.setBorder(new EmptyBorder(0, 0, 30, 0));
        head.setVerticalAlignment(JLabel.BOTTOM);
        head.setHorizontalAlignment(JLabel.CENTER);

        frame.add(head);
        frame.add(loginBox);
        frame.setVisible(true);
    }

    public JPanel loginBox() {
        JPanel box = new JPanel();
        box.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Username:
        JLabel uLabel = new JLabel("Username: ", SwingConstants.LEFT);
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        box.add(uLabel, gbc);

        uField = new JTextField();
        uField.setColumns(15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        uField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        box.add(uField, gbc);

        // Password:
        JLabel pLabel = new JLabel("Password: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        box.add(pLabel, gbc);

        pField = new JPasswordField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        box.add(pField, gbc);

        // Message:
        message.setFont(new Font("Tahoma", Font.PLAIN, 10));
        message.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        box.add(message, gbc);

        // check box
        JCheckBox checkBox = new JCheckBox("Remeber password");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        box.add(checkBox, gbc);

        // buttons
        JButton bLog = new JButton("Login");
        bLog.addActionListener(login());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridwidth = 1;
        box.add(bLog, gbc);

        JButton rButton = new JButton("Register");
        rButton.addActionListener(create());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        box.add(rButton, gbc);
        return box;
    }

    private ActionListener login() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = ConnectDB.getConnection();
                    Statement stsm = conn.createStatement();
                    String username = uField.getText();
                    char[] password = pField.getPassword();
                    String sql = String.format("select * from stds where `name` = '%s' AND password = '%s'", username,
                            String.valueOf(password));
                    String sql1 = String.format("select * from stds where `name` = '%s'", username);

                    ResultSet rs = stsm.executeQuery(sql1);

                    if (rs.next() == false) {
                        message.setText("Invalid username");
                        conn.close();
                        return;
                    }

                    rs = stsm.executeQuery(sql);
                    if (rs.next() == false) {
                        message.setText("Password wrong");
                        conn.close();
                        return;
                    } else {
                        message.setText("");
                        conn.close();
                        System.out.println("login ok");
                    }

                    conn.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        };
    }

    private ActionListener create() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Register();
            }

        };
    }

}
