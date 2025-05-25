package Interfacce;
import model.Bacheche;
import model.TitoloBacheca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class InterfacciaPrincipale extends JFrame{
    private JList<Bacheche> listaBacheche;
    private List<Bacheche> Bacheche;
    private DefaultListModel<Bacheche> listaBachecheModel;
    private JPanel ToDoPanel;
    private Bacheche selectedBacheche;
    private JLabel selectedBachecheLabel;

    public InterfacciaPrincipale(){
        Bacheche=new ArrayList<>();
        finiestraGui();
        BachechePredefinite();}



    private void finiestraGui(){

        setTitle("Gestione Bacheche dei ToDo");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel leftPanel = creazioneBachecaPanel();
        add(leftPanel,BorderLayout.WEST);
        JPanel rightPanel = creazioneToDo();
        add(rightPanel,BorderLayout.CENTER);

        creazioneMenuBar();
        setVisible(true);
    }

    private JPanel creazioneBachecaPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(350,0));
        panel.setBorder(BorderFactory.createTitledBorder("Bacheche"));

        listaBachecheModel = new DefaultListModel<>();
        listaBacheche = new JList<>(listaBachecheModel);
        listaBacheche.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaBacheche.addListSelectionListener( e -> {
            if(!e.getValueIsAdjusting()){
                selectedBacheche = listaBacheche.getSelectedValue();
                updateToDoPanel();
            }
        });

        JScrollPane scrollPane = new JScrollPane(listaBacheche);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));

        JButton addBoardBtn = new JButton("Aggiungi Bacheca");
        addBoardBtn.addActionListener(e -> CreaBacheca());

        JButton editBoardBtn = new JButton("Modifica Bacheca");
        editBoardBtn.addActionListener(e -> modificaBacheca());

        JButton deleteBoardBtn = new JButton("Elimina Bacheca");
        deleteBoardBtn.addActionListener(e -> eliminaBacheca());

        buttonPanel.add(addBoardBtn);
        buttonPanel.add(editBoardBtn);
        buttonPanel.add(deleteBoardBtn);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void CreaBacheca() {
        String name = JOptionPane.showInputDialog(this, "Nome della Bacheche");
        if (name != null) {
            Bacheche bacheche = new Bacheche();
            Bacheche.add(bacheche);
            listaBachecheModel.addElement(bacheche);
        }
    }

    private void modificaBacheca () {
        Bacheche selected = listaBacheche.getSelectedValue();
        if(selected != null) {
            JOptionPane.showMessageDialog(this, "Seleziona la bacheca da modificare");
            return;
        }

        String newTitoloBacheca = JOptionPane.showInputDialog( this , "Nuovo nome della Bacheca:" + selected.titoloBacheca());
        if(newTitoloBacheca!= null) {
            selected.settitoloBacheca(newTitoloBacheca);
            listaBacheche.repaint();
            updateToDoPanel();
        }
    }

    private void eliminaBacheca() {
        Bacheche selected = listaBacheche.getSelectedValue();
        if (selected == null) {
            JOptionPane.showMessageDialog(this, "Seleziona la bacheca da eliminare");
            return;
        }

        int result = JOptionPane.showConfirmDialog(this,
                "Sei sicuro di voler eliminare la bacheca \"" + selected.gettitoloBacheca() + "\"?",
                "Conferma eliminazione", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            Bacheche.remove(selected);
            listaBachecheModel.removeElement(selected);
            selectedBacheche = null;
            updateTodoPanel();
        }

    }





}




}


