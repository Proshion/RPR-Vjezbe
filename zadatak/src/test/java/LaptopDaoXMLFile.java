package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LaptopDaoXMLFileTest {

    @TempDir
    static File tempDir;

    private LaptopDaoXMLFile laptopDao;

    @BeforeEach
    void setUp() {
        File file = new File(tempDir, "laptops.xml");
        laptopDao = new LaptopDaoXMLFile(file);
    }

    @Test
    void dodajLaptopUFile()  {
        Laptop laptop = new Laptop("HP", "Pavilion", 1000.0, 8, 512, 0, "Intel i5", "Nvidia GTX 1650", 15.6);
        laptopDao.dodajLaptopUFile(laptop);
        Laptop loadedLaptop = null;
        try {
            loadedLaptop = laptopDao.dajLaptop("Intel i5");
        } catch (NeodgovarajuciProcesorException e) {
            throw new RuntimeException(e);
        }
        assertNotNull(loadedLaptop);
        assertEquals("HP", loadedLaptop.getBrend());
        assertEquals("Pavilion", loadedLaptop.getModel());
        assertEquals(1000.0, loadedLaptop.getCijena());
    }

    @Test
    void getLaptop() {
        Laptop laptop1 = new Laptop("Dell", "Inspiron", 800.0, 8, 256, 0, "Intel i7", "Intel UHD Graphics", 14.0);
        Laptop laptop2 = new Laptop("Acer", "Aspire", 600.0, 4, 128, 0, "AMD Ryzen 5", "AMD Radeon Graphics", 15.6);

        laptopDao.dodajLaptopUListu(laptop1);
        laptopDao.dodajLaptopUListu(laptop2);

        Laptop loadedLaptop = laptopDao.getLaptop("Intel i7");
        assertNotNull(loadedLaptop);
        assertEquals("Dell", loadedLaptop.getBrend());
        assertEquals("Inspiron", loadedLaptop.getModel());
        assertEquals(800.0, loadedLaptop.getCijena());
    }

    @Test
    void napuniListu()  {
        ArrayList<Laptop> laptops = new ArrayList<>();
        Laptop laptop1 = new Laptop("Lenovo", "IdeaPad", 700.0, 8, 256, 0, "Intel i5", "Intel UHD Graphics", 13.3);
        Laptop laptop2 = new Laptop("Asus", "ROG", 1200.0, 16, 512, 0, "Intel i9", "Nvidia RTX 3080", 17.3);
        laptops.add(laptop1);
        laptops.add(laptop2);

        laptopDao.napuniListu(laptops);
        Laptop loadedLaptop1 = null;
        try {
            loadedLaptop1 = laptopDao.dajLaptop("Intel i5");
        } catch (NeodgovarajuciProcesorException e) {
            throw new RuntimeException(e);
        }
        Laptop loadedLaptop2 = null;
        try {
            loadedLaptop2 = laptopDao.dajLaptop("Intel i9");
        } catch (NeodgovarajuciProcesorException e) {
            throw new RuntimeException(e);
        }

        assertNotNull(loadedLaptop1);
        assertEquals("Lenovo", loadedLaptop1.getBrend());
        assertEquals("IdeaPad", loadedLaptop1.getModel());
        assertEquals(700.0, loadedLaptop1.getCijena());

        assertNotNull(loadedLaptop2);
        assertEquals("Asus", loadedLaptop2.getBrend());
        assertEquals("ROG", loadedLaptop2.getModel());
        assertEquals(1200.0, loadedLaptop2.getCijena());
    }

    @Test
    void vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> laptops = new ArrayList<>();
        Laptop laptop1 = new Laptop("Samsung", "Galaxy Book", 900.0, 16, 512, 0, "Intel i7", "Intel Iris Xe Graphics", 15.6);
        Laptop laptop2 = new Laptop("Microsoft", "Surface Laptop", 1100.0, 8, 256, 0, "Intel i5", "Intel Iris Plus Graphics", 13.5);
        laptops.add(laptop1);
        laptops.add(laptop2);

        laptopDao.napuniListu(laptops);
        ArrayList<Laptop> loadedLaptops = laptopDao.vratiPodatkeIzDatoteke();

        assertNotNull(loadedLaptops);
        assertEquals(2, loadedLaptops.size());

        assertEquals("Samsung", loadedLaptops.get(0).getBrend());
        assertEquals("Galaxy Book", loadedLaptops.get(0).getModel());
        assertEquals(900.0, loadedLaptops.get(0).getCijena());

        assertEquals("Microsoft", loadedLaptops.get(1).getBrend());
        assertEquals("Surface Laptop", loadedLaptops.get(1).getModel());
        assertEquals(1100.0, loadedLaptops.get(1).getCijena());
    }
}
