package src.View;

import src.Controller.DevicesController;

public class DevicesView {
	
    public DevicesView(){
        System.out.println("Voici la liste de vos matériels :");
    }

    public void printStorageLocation(){
        DevicesController dc = DevicesController.getInstance(0, 0);
        System.out.println(dc.toStringLocation(dc.getInventory()));
    }
	
}
