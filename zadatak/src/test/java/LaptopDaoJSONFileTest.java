package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LaptopDaoJSONFileTest {

    @Mock
    private LaptopDaoJSONFile laptopDao;

    @BeforeEach
    void setUp(@TempDir File tempDir) {
        MockitoAnnotations.openMocks(this);
        File file = new File(tempDir, "test.json");
        laptopDao = spy(new LaptopDaoJSONFile(file));
    }

    @Test
    void dodajLaptopUListu_ShouldAddLaptop() {
        Laptop laptop = new Laptop("Dell", "XPS 15", 2000.0, 16, 512, 0, "Intel i7", "NVIDIA GTX 1650", 15.6);
        doNothing().when(laptopDao).dodajLaptopUListu(laptop);
        laptopDao.dodajLaptopUListu(laptop);
        verify(laptopDao, times(1)).dodajLaptopUListu(laptop);
        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();
        assertTrue(laptops.contains(laptop));
    }

    @BeforeEach
    void setUp(@TempDir File tempDir) {
        File file = new File(tempDir, "test.json");
        laptopDao = new LaptopDaoJSONFile(file);
    }

    @Test
    void dodajLaptopUListu_ShouldAddLaptop() {
        Laptop laptop = new Laptop("Dell", "XPS 15", 2000.0, 16, 512, 0, "Intel i7", "NVIDIA GTX 1650", 15.6);
        laptopDao.dodajLaptopUListu(laptop);

        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();
        assertTrue(laptops.contains(laptop));
    }

    @Test
    void dodajLaptopUFile_ShouldAddLaptopToFile() {
        Laptop laptop = new Laptop("Dell", "XPS 13", 1800.0, 16, 256, 0, "Intel i5", "Intel UHD Graphics", 13.3);
        laptopDao.dodajLaptopUFile(laptop);

        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();
        assertTrue(laptops.contains(laptop));
    }

    @Test
    void getLaptop_ShouldReturnCorrectLaptop() {
        Laptop laptop1 = new Laptop("Dell", "Inspiron 15", 800.0, 8, 512, 0, "Intel i5", "Intel UHD Graphics", 15.6);
        Laptop laptop2 = new Laptop("HP", "Pavilion", 700.0, 12, 256, 0, "AMD Ryzen 5", "AMD Radeon Graphics", 14.0);

        laptopDao.dodajLaptopUListu(laptop1);
        laptopDao.dodajLaptopUListu(laptop2);

        Laptop foundLaptop = laptopDao.getLaptop("Intel i5");
        assertEquals(laptop1, foundLaptop);
    }

    @Test
    void getLaptop_NonExistentProcesor_ShouldReturnNull() {
        Laptop foundLaptop = laptopDao.getLaptop("Nonexistent Processor");
        assertNull(foundLaptop);
    }

    @Test
    void vratiPodatkeIzDatoteke_ShouldReturnLaptopsFromFile() {
        Laptop laptop1 = new Laptop("Dell", "Latitude 14", 1200.0, 16, 512, 0, "Intel i7", "Intel UHD Graphics", 14.0);
        Laptop laptop2 = new Laptop("Lenovo", "ThinkPad X1 Carbon", 1500.0, 16, 512, 0, "Intel i7", "Intel UHD Graphics", 14.0);

        laptopDao.dodajLaptopUListu(laptop1);
        laptopDao.dodajLaptopUListu(laptop2);

        ArrayList<Laptop> laptops = laptopDao.vratiPodatkeIzDatoteke();
        assertEquals(2, laptops.size());
        assertTrue(laptops.contains(laptop1));
        assertTrue(laptops.contains(laptop2));
    }
}
