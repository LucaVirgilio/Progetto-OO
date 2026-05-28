package gui;

import model.Studente;
import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistraStudente {
    private JPanel RegistraStudente;
    private JTextField textNome;
    private JLabel Nome;
    private JTextField textCognome;
    private JLabel Cognome;
    private JTextField textEmail;
    private JTextField textLogin;
    private JTextField textPassword;
    private JLabel Email;
    private JLabel Login;
    private JLabel Password;
    private JTextField textMatricola;
    private JTextField textAnno;
    private JLabel Matricola;
    private JLabel Anno;
    private JButton RegisterButton;
    private JComboBox Annobox;
    public JFrame frame;
    private Controller controller;

    public RegistraStudente(JFrame frameChiamante,Controller controller) {
        this.controller = controller;
        frame = new JFrame("Registra Studente");
        frame.setContentPane(RegistraStudente);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //Bottone Conferma Registrazione Studente
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = textNome.getText().trim();
                    String cognome = textCognome.getText().trim();
                    String email = textEmail.getText().trim();
                    String login = textLogin.getText().trim();
                    String password = textPassword.getText().trim();
                    String matricola = textMatricola.getText().trim();
                    String anno = Annobox.getSelectedItem().toString();
                    if (nome.isEmpty() || cognome.isEmpty() || email.isEmpty()
                            || login.isEmpty() || password.isEmpty()
                            || matricola.isEmpty() || anno.isEmpty())
                    { throw new Exception("Compila tutti i campi");}

                    if (controller.utenteEsistente(login)) {
                            JOptionPane.showMessageDialog(frame, "Utente già registrato");
                            return;
                        }

                    Studente s = new Studente(nome, cognome, email, login, password, matricola, anno);
                    controller.aggiungiUtente(s);
                    JOptionPane.showMessageDialog(null,
                            "Registrazione completata");
                    frame.dispose();
                    frameChiamante.setVisible(true);

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(frame,
                            ex.getMessage());


                }
            }
        });


    }

}
