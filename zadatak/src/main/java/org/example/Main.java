package org.example;


import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        File serializableFile = new File("laptopi_serializable.txt");
        File jsonFile = new File("laptopi_json.json");
        File xmlFile = new File("laptopi_xml.xml");

        LaptopDaoSerializableFile serializableDao = new LaptopDaoSerializableFile(serializableFile);
        LaptopDaoJSONFile jsonDao = new LaptopDaoJSONFile(jsonFile);
        LaptopDaoXMLFile xmlDao = new LaptopDaoXMLFile(xmlFile);

        Laptop laptop  = new Laptop("amd","model1",500,4096,512,256,"Intel i5","Razor",20);
        Laptop laptop1 = new Laptop("lenovo","model1",1500,4096,512,256,"Intel i7","Razor",30);
        Laptop laptop2 = new Laptop("hp","model1",750,4096,512,256,"Intel i5","Razor",30);
        Laptop laptop3 = new Laptop("apple","model1",2500,8192,0,1024,"Intel i9","Razor",40);

        serializableDao.dodajLaptopUFile(laptop);
        jsonDao.dodajLaptopUFile(laptop);
        xmlDao.dodajLaptopUFile(laptop);

        serializableDao.dodajLaptopUFile(laptop1);
        jsonDao.dodajLaptopUFile(laptop1);
        xmlDao.dodajLaptopUFile(laptop1);

        serializableDao.dodajLaptopUFile(laptop2);
        jsonDao.dodajLaptopUFile(laptop2);
        xmlDao.dodajLaptopUFile(laptop2);

        serializableDao.dodajLaptopUFile(laptop3);
        jsonDao.dodajLaptopUFile(laptop3);
        xmlDao.dodajLaptopUFile(laptop3);

        ArrayList<Laptop> list1=serializableDao.vratiPodatkeIzDatoteke();
        ArrayList<Laptop> list2=jsonDao.vratiPodatkeIzDatoteke();
        ArrayList<Laptop> list3=xmlDao.vratiPodatkeIzDatoteke();
        System.out.println("Sadrzaj Serialzible File: ");
        for(Laptop a:list1){
            System.out.println(a);
        }
        System.out.println("Sadrzaj JSon File: ");
        for(Laptop a:list2){
            System.out.println(a);
        }
        System.out.println("Sadrzaj Xml File: ");
        for(Laptop a:list3){
            System.out.println(a);
        }
    }
}