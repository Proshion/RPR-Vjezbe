package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
        // Učitavanje podataka iz datoteke ako postoji
        if (file.exists()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                laptopi = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        laptopi.add(laptop);
        // Ažuriranje podataka u datoteci
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor)  {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }

        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
        // Ažuriranje podataka u datoteci
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(file, this.laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Laptop dajLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop laptop : laptopi) {
            if (laptop.getProcesor().equals(procesor)) {
                return laptop;
            }
        }
        throw new NeodgovarajuciProcesorException("Nema laptopa sa traženim procesorom: " + procesor);
    }
    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> lista = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            lista = mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
