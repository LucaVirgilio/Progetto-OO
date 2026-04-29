public class Main {
    public static void main(String[] args) {

        Studente s1 = new Studente("Paolo", "Felice", "paolo.felice@gmail.com", "login", "password", "N86567", 2025);
        System.out.println("Questi sono i dati dello studente: " + "nome: "+ s1.nome + " "+ s1.cognome+" "+"Matricola: "+s1.matricola+" "+"email: "+s1.email+" "+ "login: "+s1.login+" "+"password: "+s1.password+" "+"anno: "+s1.anno);

        Spostamento s2 = new Spostamento("Lunedì", 18, "Accettato", "Storia");
        System.out.println("La lezione di "+s2.lezione+" "+ "si tiene il giorno "+s2.giorno+" "+"alle "+s2.orario);


    }
}