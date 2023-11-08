package org.example;

import java.util.HashMap;
import java.util.Map;

import static org.example.FiksniBroj.Grad.*;

public class FiksniBroj extends TelefonskiBroj {
    public enum Grad {Jajce, Sarajevo, Zenica ,Goražde, Doboj ,Tuzla, Brčko, Bihać, BanjaLuka ,Prijedor ,Livno ,Mostar ,Trebinje }
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }
    public static Map<Grad,String> kreirajMapu(){
        Map<Grad,String> mapa=new HashMap<>();
        mapa.put(Jajce, "070");
        mapa.put(Sarajevo, "071");
        mapa.put(Zenica, "072");
        mapa.put(Goražde, "073");
        mapa.put(Doboj, "074");
        mapa.put(Tuzla, "075");
        mapa.put(Brčko, "076");
        mapa.put(Bihać, "077");
        mapa.put(BanjaLuka, "078");
        mapa.put(Prijedor, "079");
        mapa.put(Livno, "080");
        mapa.put(Mostar, "088");
        mapa.put(Trebinje, "089");

        return mapa;
    }
    public String DajBrojGrada(Grad g){
        Map<Grad,String> a=kreirajMapu();

        return a.getOrDefault(this.grad,"0");
    }
    @Override
    public String ispisi() {
        return grad.ordinal() + 1 + "/" + broj;
    }

    @Override
    public int hashCode() {
        // implementacija hashCode metode
    }


}