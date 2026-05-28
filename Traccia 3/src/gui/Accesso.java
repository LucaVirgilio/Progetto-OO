package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Docente;
import model.Responsabile;
import model.Studente;
import model.Utente;
import controller.Controller;

public class Accesso {
    private JButton Accedi;
    private JTextField textLogin;
    private JTextField textPassword;
    private JLabel Login;
    private JLabel Password;
    private JPanel PanelAccesso;
    private JButton annullaButton;
    public static JFrame frame;
    private Controller controller;

    public Accesso(JFrame framehome, Controller controller) {
        this.controller = controller;
        frame = new JFrame("Accesso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(PanelAccesso);
        frame.pack();
        frame.setVisible(true);


        Accedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = textLogin.getText();
                String password = textPassword.getText();

                Utente u = controller.login(login, password);

                //Messaggio Credenziali Errate
                if(u == null) {
                    JOptionPane.showMessageDialog(null,
                            "Credenziali errate");
                    return;
                }

                //Messaggio di benvenuto
                JOptionPane.showMessageDialog(null,
                        "Benvenuto "+ u.getNome() +" "+u.getCognome());

                if (u instanceof Studente) {
                    Studente studenteLoggato =  (Studente) u;
                    TableStudente tablestudente= new TableStudente(frame, controller,studenteLoggato);
                    frame.dispose();
                    tablestudente.frame1.setVisible(true);


                }
                else if(u instanceof Responsabile) {
                    Responsabile responsabileLoggato = (Responsabile) u;
                    TableResponsabile tableresponsabile = new TableResponsabile(frame,controller,responsabileLoggato);
                    tableresponsabile.frame4.setVisible(true);
                    frame.dispose();
                    }
                else{
                    Docente docenteLoggato = (Docente) u;
                    TableDocente tabledocente = new TableDocente(frame,controller,docenteLoggato);
                    tabledocente.frame2.setVisible(true);
                    frame.dispose();
                }

                }
        });
        annullaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framehome.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
