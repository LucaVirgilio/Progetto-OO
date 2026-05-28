package model;

public class Insegnamento {
    private String nomeInsegnamento;
    private int cfu;
    private String annoCorso;
    private Docente docente;
    boolean corsoAttivato;


    public Insegnamento(String nomeInsegnamento, Docente docente, int cfu, String annoCorso) {
        this.nomeInsegnamento = nomeInsegnamento;
        this.cfu = cfu;
        this.annoCorso = annoCorso;
        this.corsoAttivato = true;
        this.docente = docente;
    }
    public String getNomeInsegnamento() {
        return nomeInsegnamento;
    }
    public int getCfu() {
        return cfu;
    }
    public String getAnnoCorso() {
        return annoCorso;
    }
    public Docente getDocente() {
        return docente;
    }

    @Override
    public String toString() {
            return nomeInsegnamento;
    }

    public boolean isCorsoAttivato() {
        return corsoAttivato;
    }
    public void setCorsoAttivato(boolean corsoAttivato) {
        this.corsoAttivato = corsoAttivato;
    }
}