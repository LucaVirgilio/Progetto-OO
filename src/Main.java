class Operazione {
    void esegui() throws Exception {
        System.out.println("Eseguo un'operazione generica.");
    }
}
class Divisione extends Operazione throws ArithmeticException {
    @Override
    void esegui(){
        int risultato = 10 / 0;
        System.out.println("Risultato: " + risultato);
    }
}
class Stampa extends Operazione {
    @Override
    void esegui() {
        System.out.println("Stampo un messaggio.");
    }
}

        import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList operazioni = new ArrayList<Operazione>();
        operazioni.add(new Stampa());
        operazioni.add(new Divisione());

        for (Operazione operazione : operazioni) {
            try {
                operazione.esegui();
            } catch (Exception e) {
                System.out.println("Errore generico.");
            } catch (ArithmeticException e) {
                System.out.println("Errore: divisione per zero.");
            }
        }
    }
}