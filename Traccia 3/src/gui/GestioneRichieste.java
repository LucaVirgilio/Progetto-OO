package gui;

import controller.Controller;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneRichieste {
    private JPanel panelRichieste;
    private JTable TableRichieste;
    private JButton approvaButton;
    private JButton indietroButton;
    private JButton rifiutaButton;
    private JFrame frameRichieste;
    private Controller controller;
    private DefaultTableModel model;

    public GestioneRichieste(Controller controller) {
        this.controller = controller;

        frameRichieste = new JFrame("Richieste");
        frameRichieste.setContentPane(panelRichieste);
        frameRichieste.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRichieste.setLocationRelativeTo(null);
        frameRichieste.setSize(500, 500);
        initTable();
        frameRichieste.setVisible(true);

        approvaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int riga = TableRichieste.getSelectedRow();
                    if (riga == -1) {
                        throw new Exception("Seleziona una richiesta");
                    }
                    RichiestaSpostamento r = controller.getRichieste().get(riga);
                    Lezione l = r.getLezione();

                    // applica modifica
                    l.setgiornoSettimana(r.getNuovoGiorno());
                    l.setOraInizio(r.getNuovaOraInizio());
                    l.setOraFine(r.getNuovaOraFine());

                    r.setApprovata(true);

                    refreshAll();
                    TableResponsabile.refreshGlobal();

                    JOptionPane.showMessageDialog(null, "Richiesta approvata");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        rifiutaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int riga = TableRichieste.getSelectedRow();

                if (riga == -1) return;

                controller.getRichieste().remove(riga);

                refreshAll();
            }
        });

        indietroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameRichieste.dispose();
            }
        });

    }

    private void initTable() {
        String[] colonne = {
                "Insegnamento",
                "Giorno Attuale",
                "Nuovo Giorno",
                "Ora Inizio",
                "Ora Fine",
                "Stato"
        };
        model = new DefaultTableModel(colonne, 0);
        TableRichieste.setModel(model);
        refreshAll();
    }

    private void refreshAll() {
        model.setRowCount(0);

        for (RichiestaSpostamento r : controller.getRichieste()) {
            Object[] row = {

                    r.getLezione().getInsegnamento().getNomeInsegnamento(),
                    r.getLezione().getGiornoSettimana(),
                    r.getNuovoGiorno(),
                    r.getNuovaOraInizio(),
                    r.getNuovaOraFine(),
                    r.isApprovata() ? "APPROVATA" : "IN ATTESA"
            };

            model.addRow(row);
        }

    }
}
