public class Studente extends Utente {
    public String matricola;
    protected int anno;

    public Studente(String nome, String cognome, String email, String login, String password, String matricola, int anno) {
        super(nome, cognome, email, login, password);
        this.matricola = matricola;
        this.anno = anno;
    }
    public int anno(){
        return anno;
    }
    public double visualizzaOrario(){
        return 0;
    }
    public double visualizzaAula(){
        return 0;
    }
}

