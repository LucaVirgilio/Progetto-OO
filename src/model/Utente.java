package model;

import java.util.ArrayList;
import java.util.List;

    public class Utente {
    private String login;
    private String password;
    private String nomeUtente;
    private List<condivisione> condivisioni;


    public Utente(String login, String password, String nomeUtente) {
        this.login = login;
        this.password = password;
        this.nomeUtente = nomeUtente;
        this.condivisioni = new ArrayList<>();
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public List<condivisione> getCondivisioni() {
        return condivisioni;
    }


    public void aggiungiCondivisione(ToDo todo) {
        condivisione condivisione = new condivisione(this, todo);
        condivisioni.add(condivisione);
        System.out.println("Condivisione aggiunta: " + this.nomeUtente + " -> " + todo.getTitolo());
    }


    public void rimuoviCondivisione(ToDo todo) {
        condivisioni.removeIf(c -> c.getTodo().equals(todo));
        System.out.println("Condivisione rimossa: " + this.nomeUtente + " -> " + todo.getTitolo());
    }
}
