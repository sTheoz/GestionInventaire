package src.View;

import src.Controller.DevicesController;
import src.Model.devices.Device;

public class DevicesView {
    
    private DevicesController dc;

    public DevicesView(){
        this.dc = DevicesController.getInstance(0, 0);
    }

    public DevicesView(int id, int nbElem){
        this.dc = DevicesController.getInstance(id, nbElem);
    }

    public void printAllDevices(){
        System.out.println("All devices :");
        System.out.println(dc.toStringDevices(dc.getInventory()));
    }

    public void printDevicesByType(Device.Type t){
        System.out.println("All " + t + " :");
        System.out.println(dc.toStringDevicesByType(dc.getInventory(), t));
    }

    public void printAllAvailableDevices(){
        System.out.println("All available devices :");
        System.out.println(dc.toStringAvailableDevices(dc.getInventory()));
    }

    public void printAllNotAvailableDevices(){
        System.out.println("All unavailable devices :");
        System.out.println(dc.toStringNotAvailableDevices(dc.getInventory()));
    }

    public void printStorageLocation(){
        System.out.println("All storages :");
        System.out.println(dc.toStringLocation(dc.getInventory()));
    }
	
}
