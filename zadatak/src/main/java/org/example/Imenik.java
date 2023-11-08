package org.example;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> imenik = new HashMap<>();

    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime) {
        TelefonskiBroj broj = imenik.get(ime);
        if (broj != null) {
            return broj.ispisi();
        } else {
            return "Osoba nije pronađena u imeniku.";
        }
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue().equals(broj)) {
                return entry.getKey();
            }
        }
        return "Broj nije pronađen u imeniku.";
    }

    // Ostale metode prema zahtjevima zadatka
}