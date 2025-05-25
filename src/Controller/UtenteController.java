package controller;

import Interfacce.IntarfacciaPrincipale;
import Interfacce.UtenteInterfaccia;
import model.Utente;

import javax.swing.*;
import java.awt.event.*;

public class UtenteController{
    private UtenteInterfaccia view;
    private Utente model;

    public UtenteController(UtenteInterfaccia view , Utente model){
        this.view = view;
        this.model = model;

        this.view.getLoginButton().addActionListener(e ->{
            String nomeUtente = view.getNomeUtente();
            String password = view.getPassword();

            if(nomeUtente.equals(model.getNomeUtente()) && password.equals(model.getPassword())) {
                JOptionPane.showMessageDialog(view, "Login effettuato");
                view.dispose();
                new InterfacciaPrincipale();
            }else{
                JOptionPane.showMessageDialog(view,"Login errato");
            }

        });
    }
}


