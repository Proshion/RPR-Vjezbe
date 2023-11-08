package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LaptopDaoSerializableFileTest {

    private LaptopDaoSerializableFile laptopDao;

    @BeforeEach
    void setUp() {
        File file = new File("test.dat");
        laptopDao = new LaptopDaoSerializableFile(file);
        // Čišćenje datoteke prije svakog testa
        file.delete();
    }

    @Test
    void dodajLaptopUFile_ShouldAddLaptopToFile() {
        Laptop laptop = new Laptop("Dell", "XPS", 1500.0, 16, 512, 0, "Intel i7", "Nvidia GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop);

        ArrayList<Laptop> lista = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(1, lista.size());
        assertEquals(laptop, lista.get(0));
    }

    @Test
    void dajLaptop_ShouldReturnMatchingLaptop() throws NeodgovarajuciProcesorException {
        Laptop laptop = new Laptop("Dell", "XPS", 1500.0, 16, 512, 0, "Intel i7", "Nvidia GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop);

        Laptop result = laptopDao.dajLaptop("Intel i7");
        assertEquals(laptop, result);
    }

    @Test
    void dajLaptop_ShouldThrowExceptionIfProcessorNotFound() {
        Laptop laptop = new Laptop("Dell", "XPS", 1500.0, 16, 512, 0, "Intel i7", "Nvidia GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop);

        assertThrows(NeodgovarajuciProcesorException.class, () -> {
            laptopDao.dajLaptop("AMD Ryzen");
        });
    }

    @Test
    void napuniListu_ShouldAddLaptopsToList() {
        ArrayList<Laptop> laptopi = new ArrayList<>();
        laptopi.add(new Laptop("Dell", "XPS", 1500.0, 16, 512, 0, "Intel i7", "Nvidia GTX 1650", 15.6));
        laptopi.add(new Laptop("HP", "Pavilion", 1200.0, 8, 256, 0, "AMD Ryzen 5", "AMD Radeon Vega 8", 14.0));

        laptopDao.napuniListu(laptopi);

        ArrayList<Laptop> lista = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(2, lista.size());
        assertEquals(laptopi, lista);
    }
}