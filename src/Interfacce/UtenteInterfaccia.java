package Interfacce;

import javax.swing.*;
import java.awt.*;


public class UtenteInterfaccia extends JFrame {

    private JTextField t1;
    private JPasswordField t2;
    private JButton btn;


    public UtenteInterfaccia() {
        super("Login Utente");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);


        JLabel l1 = new JLabel("Nome Utente:");
        l1.setBounds(85, 100, 125, 25);
        this.add(l1);

        t1 = new JTextField(15);
        t1.setBounds(165, 100, 125, 25);
        this.add(t1);


        JLabel l2 = new JLabel("Password:");
        l2.setBounds(100, 150, 100, 25);
        this.add(l2);

        t2 = new JPasswordField(15);
        t2.setBounds(165, 150, 125, 25);
        this.add(t2);

        btn = new JButton("Login");
        btn.setBounds(165, 200, 125, 25);
        this.add(btn);
    }

    public String getNomeUtente() {
        return t1.getText();
    }

    public String getPassword() {
        return new String(t2.getPassword());
    }

    public JButton getLoginButton() {
        return btn;
    }

}