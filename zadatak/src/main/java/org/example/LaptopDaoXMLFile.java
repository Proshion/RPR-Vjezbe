package org.example;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoXMLFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoXMLFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
        // Učitavanje podataka iz datoteke ako postoji
        if (file.exists()) {

            try {
                XmlMapper mapper = new XmlMapper();
                laptopi = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        laptopi.add(laptop);
        // Ažuriranje podataka u datoteci
        XmlMapper mapper = new XmlMapper();
        try {
            mapper.writeValue(file, laptopi);
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
        XmlMapper mapper = new XmlMapper();
        try {
            mapper.writeValue(file, this.laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> lista = new ArrayList<>();
        XmlMapper mapper = new XmlMapper();
        try {
            lista = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(ArrayList.class, Laptop.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}