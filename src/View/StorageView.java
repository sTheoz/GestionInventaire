package src.View;

import src.Controller.StorageController;
import src.Model.devices.Device;

public class StorageView {
    
    private StorageController dc;

    public StorageView(){
        this.dc = StorageController.getInstance(0, 0);
    }

    public StorageView(int id, int nbElem){
        this.dc = StorageController.getInstance(id, nbElem);
    }

    public void printAllStorage(){
        System.out.println("All Storage :");
        System.out.println(dc.toStringStorage(dc.getInventory()));
    }

    public void printStorageByType(Device.Type t){
        System.out.println("All " + t + " :");
        System.out.println(dc.toStringStorageByType(dc.getInventory(), t));
    }

    public void printAllAvailableStorage(){
        System.out.println("All available Storage :");
        System.out.println(dc.toStringAvailableStorage(dc.getInventory()));
    }

    public void printAllNotAvailableStorage(){
        System.out.println("All unavailable Storage :");
        System.out.println(dc.toStringNotAvailableStorage(dc.getInventory()));
    }

    public void printStorageLocation(){
        System.out.println("All storages :");
        System.out.println(dc.toStringLocation(dc.getInventory()));
    }
	
}
