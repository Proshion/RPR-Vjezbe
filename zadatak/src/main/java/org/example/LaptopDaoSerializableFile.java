package org.example;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao {
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile(File file) {
        this.file = file;
        this.laptopi = new ArrayList<>();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) {
        laptopi.add(laptop);
        // Pisanje liste u datoteku
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(String.valueOf(file)))) {
            outputStream.writeObject(laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
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
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
        // Ažuriranje podataka u datoteci
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(String.valueOf(file)))) {
            outputStream.writeObject(this.laptopi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> lista = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(String.valueOf(file)))) {
            lista = (ArrayList<Laptop>) inputStream.readObject(); // Cast to ArrayList<Laptop>
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;

}}