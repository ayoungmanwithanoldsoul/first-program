package p9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OfficialLogIn extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    OfficialLogIn() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText = userTextField.getText();
            String pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("user") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                dispose();

                // Open a new frame for addition
                openAdditionFrame();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }

        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }

    private void openAdditionFrame() {
        JFrame additionFrame = new JFrame();
        additionFrame.setTitle("Addition Operation");
        additionFrame.setBounds(10, 10, 400, 400);
        additionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Components for addition frame
        JLabel num1Label = new JLabel("Enter First Number:");
        num1Label.setBounds(20, 20, 150, 30);
        JTextField num1TextField = new JTextField();
        num1TextField.setBounds(180, 20, 150, 30);

        JLabel num2Label = new JLabel("Enter Second Number:");
        num2Label.setBounds(20, 60, 150, 30);
        JTextField num2TextField = new JTextField();
        num2TextField.setBounds(180, 60, 150, 30);

        JButton addButton = new JButton("Add");
        addButton.setBounds(180, 100, 100, 30);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 140, 150, 30);
        JTextField resultTextField = new JTextField();
        resultTextField.setBounds(180, 140, 150, 30);
        resultTextField.setEditable(false);

        // ActionListener for addition frame
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(num1TextField.getText());
                    int num2 = Integer.parseInt(num2TextField.getText());
                    int result = num1 + num2;
                    resultTextField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(additionFrame, "Invalid input. Please enter valid numbers.");
                }
            }
        });

        // Adding components to addition frame
        additionFrame.add(num1Label);
        additionFrame.add(num1TextField);
        additionFrame.add(num2Label);
        additionFrame.add(num2TextField);
        additionFrame.add(addButton);
        additionFrame.add(resultLabel);
        additionFrame.add(resultTextField);

        additionFrame.setLayout(null);
        additionFrame.setVisible(true);
    }

    public static void main(String[] a) {
        OfficialLogIn frame = new OfficialLogIn();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
