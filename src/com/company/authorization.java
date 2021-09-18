package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class authorization extends JFrame{
    private JTextField textField1;
    private JButton submitButton;
    private JPanel pane;
    private JPasswordField passwordField1;

    public void authorizationFrame(){
        setTitle("App");
        setSize(300, 200);
        add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public authorization(){
        authorizationFrame();
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userValue = textField1.getText();
                String passValue = passwordField1.getText();
                if (userValue.equals("admin") && passValue.equals("admin") ){
                    dispose();
                    new allPanels();
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
        });
    }

    public static void main(String[] args) {
        authorization au = new authorization();
    }
}
