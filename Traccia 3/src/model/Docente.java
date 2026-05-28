package model;
import java.util.List;

public class Docente extends Utente {
    private String insegnamentoPrincipale;


    public Docente(String nome, String cognome, String email, String login, String password, String insegnamentoPrincipale) {
        super(nome, cognome, email, login, password);
        this.insegnamentoPrincipale = insegnamentoPrincipale;
    }

    public String getInsegnamentoPrincipale() {
        return insegnamentoPrincipale;
    }

    @Override
    public String toString() {
        return nome + " " + cognome;
    }
        }


