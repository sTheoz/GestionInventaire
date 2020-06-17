package src.View;

import java.util.Scanner;

import src.Controller.StorageController;
import src.Model.devices.Device;

public class StorageView {
    
    private StorageController sc;

    public StorageView(){
        this.sc = StorageController.getInstance();
    }

    public StorageView(int id, int nbElem){
        this.sc = StorageController.getInstance();
    }

    public void printAllStorage(){
        System.out.println("All Storage :");
        System.out.println(sc.toStringStorages(sc.getStorages()));
    }

    public void printStorageByName(String name){
        System.out.println("All " + name + " :");
        System.out.println(sc.toStringStoragesByName(sc.getStorages(), name));
    }

    public void printStorageByLocation(String location){
        System.out.println("All storages :");
        System.out.println(sc.toStringStoragesByLocation(sc.getStorages(), location));
    }

    public void addStorage(Scanner input_scanner){
        System.out.println("=== Ajout d'un lieu de stockage ===");
        System.out.print("Localisation :");
        String location = input_scanner.nextLine();
        System.out.print("Nom du lieu de stockage:");
        String name = input_scanner.nextLine();
        sc.addStorage(name, location);
    }

    public void modifyStorage(Scanner input_scanner){
        System.out.println("=== Ici il faut modifier TODO ===");
    }
    
	
}
