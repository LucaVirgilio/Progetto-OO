package model;

import java.util.ArrayList;

public class Aula {
    protected String nomeAula;

    public Aula(String nomeAula) {
        this.nomeAula = nomeAula;
    }
    public String getNomeAula() {
        return nomeAula;
    }

    @Override
    public String toString() {
        return nomeAula;

    }
}