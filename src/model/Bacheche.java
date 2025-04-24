package model;

import java.util.ArrayList;
import java.util.List;

public class Bacheche {
    private String titoloBacheca;
    private List<ToDo> ToDos;


    public Bacheche(String titoloBacheca) {
        this.titoloBacheca = titoloBacheca;
        this.ToDos = new ArrayList<>();
    }

    public List<ToDo> getToDos() {
        return ToDos;
    }

    public void creaToDo(ToDo toDo){ToDos.add(toDo);
    }
    public void rimuoviToDo(ToDo toDo){ToDos.remove(toDo);
    }


    public String gettitoloBacheca() {
        return titoloBacheca;
    }

    public void settitoloBacheca(String titoloBacheca) {
        this.titoloBacheca = titoloBacheca;
    }

}