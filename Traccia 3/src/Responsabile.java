public class Responsabile extends Utente {
    public Responsabile(String nome, String cognome, String email, String login, String password) {
        super(nome, cognome, email, login, password);
    }

    public double creaSpostamento() {
        return 0;
    }

    public double creaLezione() {
        return 0;
    }

    public double gestireOrari() {
        return 0;
    }
    public boolean approvaRichiesta() {
     return true;
    }
    public double gestireRichiesta() {
        return 0;
    }
}
