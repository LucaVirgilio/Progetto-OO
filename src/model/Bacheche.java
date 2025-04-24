package model;

import java.util.ArrayList;
import java.util.List;

 public class Bacheche {
    private TitoloBacheca titoloBacheca;
    private String descrizioneBacheca;


    private static List<Bacheche> listaBacheche = new ArrayList<>();


    public Bacheche(TitoloBacheca titoloBacheca, String descrizioneBacheca) {
        this.titoloBacheca = titoloBacheca;
        this.descrizioneBacheca = descrizioneBacheca;
    }


    public TitoloBacheca getTitoloBacheca(){
        return titoloBacheca;
    }

    public void setTitoloBacheca(TitoloBacheca titoloBacheca) {
        this.titoloBacheca = titoloBacheca;
    }

    public String getDescrizioneBacheca() {
        return descrizioneBacheca;
    }

    public void setDescrizioneBacheca(String descrizioneBacheca) {
        this.descrizioneBacheca = descrizioneBacheca;}


    public static void creaBacheca(TitoloBacheca titoloBacheca, String descrizioneBacheca) {
        Bacheche nuovaBacheca = new Bacheche(titoloBacheca, descrizioneBacheca);
        listaBacheche.add(nuovaBacheca);
        System.out.println("Bacheca creata con successo: " + titoloBacheca);
    }



    public static void eliminaBacheca(TitoloBacheca titoloBacheca){

        if(listaBacheche.removeIf(bacheca -> bacheca.getTitoloBacheca().equals(titoloBacheca))){
            System.out.println("Bacheca eliminata" + titoloBacheca);
        }else{
            System.out.println("Bacheca non trovata impossibile eliminarla" + titoloBacheca);
        }
    }





    public static void modificaBacheca(TitoloBacheca titoloBacheca,TitoloBacheca  nuovoTitolo, String nuovaDescrizione) {
        for (Bacheche bacheca : listaBacheche) {
            if (bacheca.getTitoloBacheca().equals(titoloBacheca)) {
                bacheca.setTitoloBacheca(nuovoTitolo);
                bacheca.setDescrizioneBacheca(nuovaDescrizione);
                System.out.println("Bacheca modificata con successo: " + nuovoTitolo);
                return;
            }
        }
        System.out.println("Bacheca non trovata: " + titoloBacheca);
    }



}