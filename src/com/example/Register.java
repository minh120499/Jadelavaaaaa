package com.example;

import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Register {
    private JFrame frame = new JFrame("Hello world");
    private JTextField uField = new JTextField();
    private JTextField name = new JTextField();
    private JTextField email = new JTextField();
    private JTextField phone = new JTextField();
    private JPasswordField pField = new JPasswordField();
    private JPasswordField rpField = new JPasswordField();
    private JTextField address = new JTextField();
    private JPanel createbox = new JPanel();
    private JLabel umess = new JLabel();
    private JLabel pmess = new JLabel();
    private JLabel rpmess = new JLabel();
    private JLabel namemess = new JLabel();
    private JLabel phmess = new JLabel();
    private JLabel mailmess = new JLabel();
    private JLabel addmess = new JLabel();

    public Register() {
        createbox();

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(Constrains.X, Constrains.Y, Constrains.WIDTH, Constrains.HEIGHT);

        JLabel head = new JLabel();
        head.setText("Register");
        head.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        head.setBorder(new EmptyBorder(10, 0, 0, 0));
        head.setVerticalAlignment(JLabel.BOTTOM);
        head.setHorizontalAlignment(JLabel.CENTER);

        frame.add(head, BorderLayout.NORTH);
        frame.add(createbox, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void createbox() {
        createbox.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Username:
        JLabel uLabel = new JLabel("Username: ", SwingConstants.LEFT);
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        createbox.add(uLabel, gbc);

        uField = new JTextField();
        uField.setColumns(15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        uField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        createbox.add(uField, gbc);

        umess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        umess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        createbox.add(umess, gbc);

        // Password:
        JLabel pLabel = new JLabel("Password: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        createbox.add(pLabel, gbc);

        pField = new JPasswordField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        createbox.add(pField, gbc);

        pmess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        pmess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        createbox.add(pmess, gbc);

        // Re - Password:
        JLabel rpLabel = new JLabel("Re-password: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        createbox.add(rpLabel, gbc);

        rpField = new JPasswordField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        createbox.add(rpField, gbc);

        rpmess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        rpmess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        createbox.add(rpmess, gbc);

        // Full name:
        JLabel nameLabel = new JLabel("Full name: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        createbox.add(nameLabel, gbc);

        name = new JTextField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        createbox.add(name, gbc);

        namemess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        namemess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        createbox.add(namemess, gbc);

        // Phone:
        JLabel phoneLabel = new JLabel("Phone: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        createbox.add(phoneLabel, gbc);

        phone = new JTextField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        createbox.add(phone, gbc);

        phmess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        phmess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        createbox.add(phmess, gbc);

        // Email:
        JLabel emailLabel = new JLabel("Email: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        createbox.add(emailLabel, gbc);

        email = new JTextField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        createbox.add(email, gbc);

        mailmess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        mailmess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        createbox.add(mailmess, gbc);

        // Address:
        JLabel addressLabel = new JLabel("Address: ", SwingConstants.LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        createbox.add(addressLabel, gbc);

        address = new JTextField(15);
        pField.setFont(new Font("San-Serif", Font.PLAIN, 10));
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        createbox.add(address, gbc);

        addmess.setFont(new Font("Tahoma", Font.PLAIN, 10));
        addmess.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        createbox.add(addmess, gbc);

        // buttons
        JButton rLog = new JButton("Register");
        rLog.addActionListener(create());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridwidth = 1;
        createbox.add(rLog, gbc);

        JButton bButton = new JButton("Back to login");
        bButton.addActionListener(login());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        createbox.add(bButton, gbc);
    }

    private ActionListener login() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(12);
                frame.dispose();
                new Login();
            }

        };
    }

    private void resetMess() {
        umess.setText("");
        pmess.setText("");
        rpmess.setText("");
        namemess.setText("");
        pmess.setText("");
        mailmess.setText("");
        addmess.setText("");
    }

    private boolean validate() {
        // String username = uField.getText();
        String password = String.valueOf(pField.getPassword());
        String repassword = String.valueOf(rpField.getPassword());
        String fullname = name.getText();
        String sphone = phone.getText();
        String semail = email.getText();
        String saddress = address.getText();
        Boolean rs = true;

        if (password.length() > 30 || password.length() < 6) {
            pmess.setText("password mustbetween 6 and 30");
            rs = false;
        }

        if (!password.equals(repassword)) {
            rpmess.setText("confirm password not match");
            rs = false;
        }

        if (!Pattern.matches("[a-zA-Z\s]+", fullname)) {
            namemess.setText("username invalid");
            rs = false;
        }

        if (!Pattern.matches("(09|08|03)[0-9]{8}", sphone)) {
            phmess.setText("phone invalid");
            rs = false;
        }

        if (!Pattern.matches("[\\w.]+@[a-z.]+(.com|.com.vn)", semail)) {
            mailmess.setText("phone invalid");
            rs = false;
        }

        if (!Pattern.matches("[\\w]+", saddress)) {
            addmess.setText("address invalid");
            rs = false;
        }

        return rs;
    }

    private ActionListener create() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                resetMess();
                validate();
                try {
                    String username = uField.getText();
                    String password = String.valueOf(pField.getPassword());
                    // String repassword = String.valueOf(rpField.getPassword());
                    String fullname = name.getText();
                    String sphone = phone.getText();
                    String semail = email.getText();
                    String saddress = address.getText();
                    String id = "";
                    String lastLoginDate = "";
                    String loginAttemp = "";
                    String status = "";
                    String createDate = "";
                    String modifiedDate = "";

                    Connection conn = ConnectDB.getConnection();
                    Statement stmt = conn.createStatement();
                    String sql = String.format("Select * from `stds` where name = '%s'", username);
                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        umess.setText("Already username");
                        return;
                    } else if (!validate()) {
                        return;
                    }

                    sql = String.format(
                            "INSERT INTO users (id, username, password, fullname, phone, email, address, lastLoginDate, loginAttemp, status, createDate, modifiedDate) values ('%s', '%s', '%s', '%s','%s','%s','%s','%s','%s','%s','%s','%s')",
                            id, username, password, fullname, sphone, semail, saddress, lastLoginDate, loginAttemp,
                            status,
                            createDate, modifiedDate);
                    stmt.executeQuery(sql);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }
}
