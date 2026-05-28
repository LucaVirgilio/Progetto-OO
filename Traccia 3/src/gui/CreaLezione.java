package gui;

import javax.swing.*;
import controller.Controller;
import model.Docente;
import model.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class CreaLezione {
    private JPanel pannellolezione;
    private JTextField txtOraInizio;
    private JTextField txtOraFine;
    private JTextField txtAula;
    private JButton BottoneConferma;
    protected JFrame frame;
    private JLabel Insegnamento;
    private JLabel Giorno;
    private JLabel OraInizio;
    private JLabel OraFine;
    private JLabel AulaString;
    private JComboBox InsegnamentoBox;
    private JComboBox GiornoBox;
    private JComboBox<Aula> AulaBox;
    private JButton IndietroButton;
    private Controller controller;
    private Docente docenteLoggato;
    private TableDocente tableresponsabile;
    private TableResponsabile tableResponsabile;

    public CreaLezione(Controller controller, JFrame frame4, TableResponsabile tableResponsabile) {
        this.controller = controller;
        this.docenteLoggato = docenteLoggato;

        frame = new JFrame("Crea lezione");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(pannellolezione);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Aggiorna Aule
        AulaBox.removeAllItems();

        for (Aula a : controller.getAule()) {
            AulaBox.addItem(a);
        }

        GiornoBox.addItem("Lunedì");
        GiornoBox.addItem("Martedì");
        GiornoBox.addItem("Mercoledì");
        GiornoBox.addItem("Giovedì");
        GiornoBox.addItem("Venerdì");
        for (Insegnamento i : controller.getInsegnamenti()) {
            InsegnamentoBox.addItem(i);
        }

        //Bottone Conferma Creazione Lezione
        BottoneConferma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Insegnamento insegnamento = (Insegnamento) InsegnamentoBox.getSelectedItem();
                    String giorno = GiornoBox.getSelectedItem().toString();
                    String oraInizio = txtOraInizio.getText().trim();
                    String oraFine = txtOraFine.getText().trim();
                    try {

                        LocalTime.parse(oraInizio);

                        LocalTime.parse(oraFine);

                    }
                    catch (DateTimeParseException ex) {

                        throw new Exception(
                                "Inserisci orario formato HH:mm"
                        );
                    }
                    Aula aula = (Aula) AulaBox.getSelectedItem();

                    if (Insegnamento == null || giorno.isEmpty() || oraInizio.isEmpty() || oraFine.isEmpty() || aula == null) {
                        throw new Exception("Compila tutti i campi");
                    }

                    Lezione lezione = new Lezione(insegnamento, giorno, oraInizio, oraFine, aula);
                    controller.aggiungiLezione(lezione);
                    tableResponsabile.aggiornaTabella();

                    JOptionPane.showMessageDialog(
                            null,
                            "Lezione creata"
                    );

                    frame4.setVisible(true);
                    frame.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}
