package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Banka {
    private Long brojRacuna;

    private final List<Korisnik> korisnici;

    private final List<Uposlenik> uposlenici;

    public Banka() {
        this.korisnici = new ArrayList<Korisnik>();
        this.uposlenici = new ArrayList<Uposlenik>();
    }

    public Korisnik kreirajNovogKorisnika(String ime, String prezime){
        Korisnik k = new Korisnik(ime, prezime);
        this.korisnici.add(k);
        return k;
    }

    public Uposlenik kreirajNovogUposlenika(String ime, String prezime){
        Uposlenik u = new Uposlenik(ime, prezime);
        this.uposlenici.add(u);
        return u;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik k){
        Racun r = null;
        for (Korisnik korisnik : this.korisnici) {
            if (korisnik.equals(k)) {
                Long brojRacuna = (new Random()).nextLong();
                r = new Racun(brojRacuna, korisnik);
                break;
            }
        }
        return r;
    }
}
