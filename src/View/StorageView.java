package src.View;

import src.Controller.StorageController;
import src.Model.devices.Device;

public class StorageView {
    
    private StorageController dc;

    public StorageView(){
        this.dc = StorageController.getInstance();
    }

    public StorageView(int id, int nbElem){
        this.dc = StorageController.getInstance();
    }

    public void printAllStorage(){
        System.out.println("All Storage :");
        System.out.println(dc.toStringStorages(dc.getStorages()));
    }

    public void printStorageByName(String name){
        System.out.println("All " + name + " :");
        System.out.println(dc.toStringStoragesByName(dc.getStorages(), name));
    }

    public void printStorageByLocation(String location){
        System.out.println("All storages :");
        System.out.println(dc.toStringStoragesByLocation(dc.getStorages(), location));
    }
    
	
}
