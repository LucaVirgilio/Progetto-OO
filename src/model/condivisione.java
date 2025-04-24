package model;


public class condivisione {
    private Utente utente;
    private ToDo todo;

    public condivisione(Utente utente, ToDo todo) {
        this.utente = utente;
        this.todo = todo;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ToDo getTodo() {
        return todo;
    }

    public void setTodo(ToDo todo) {
        this.todo = todo;
    }
}
