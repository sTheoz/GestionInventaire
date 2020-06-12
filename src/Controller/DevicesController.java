package src.Controller;

import src.Model.devices.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Iterator;

public class DevicesController {

    //ID available for futur device
    private int id;
    private int numberElement;
    private ArrayList<Device> inventory;

    /** Instance unique non préinitialisée */
    private static DevicesController INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du Stock */
    public static DevicesController getInstance(int id, int nbEle)
    {           
        if (INSTANCE == null)
        {   INSTANCE = new DevicesController(id, nbEle); 
        }
        return INSTANCE;
    }

    private DevicesController(int id, int nbEle){
        this.id = id;
        this.numberElement = nbEle;
        this.inventory = new ArrayList<Device>();
        System.out.println("Bonjour DevicesController");
    }

    public String toStringLocation(ArrayList<Device> devices){
        String str = "";
        ArrayList<String> locations = new ArrayList<String>();
        Iterator<Device> iter = devices.iterator();
        Device b;
        while(iter.hasNext()){
            b = iter.next();
            locations.add(b.getLocation());
        }
        Set<String> mySet = new HashSet<String>(locations);
        List<String> l2 = new ArrayList<String>(mySet);
        Iterator<String> iter2 = l2.iterator();
        while(iter2.hasNext()){
            str += iter2.next();
        }
        return str;
    }

    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    public ArrayList<Device> getInventory(){
        return inventory;
    }

    private void incrementStock(){
        this.numberElement++;
    }

    private void decrementStock(){
        this.numberElement--;
    }

    public int getNbElement(){
        return numberElement;
    }

    public void removeDevice(Device d){
        inventory.remove(d);
        decrementStock();
    }

    public void addPhone(String ref, String name, String brand, double price, Phone.SE se, double sz, Device.State st, String location, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Phone(ref, name, brand, price, se, sz, st, location, Device.Type.Phone, getId()));
            incrementStock();
        }
    }

    public void addSensor(String ref, String name, String brand, double price, Device.State st, String location, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Sensor(ref, name, brand, price, st, location, Device.Type.Sensor, getId()));
            incrementStock();
        }
    }

    public void addHeadset(String ref, String name, String brand, double price, Device.State st, String location, int vr, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Headset(ref, name, brand, price, vr, st, location, Device.Type.Headset, getId()));
            incrementStock();
        }
    }

    public void addPlayingRemote(String ref, String name, String brand, double price, Device.State st, String location, int nb){
        for(int i = 0 ; i < nb ; i++){
            inventory.add(new PlayingRemote(ref, name, brand, price, st, location, Device.Type.PlayingRemote, getId()));
            incrementStock();
        }
    }

    public void addWebcam(String ref, String name, String brand, double price, Webcam.Resolution rs, Device.State st, String location, int nb){
        for(int i = 0 ; i < nb ; i++){
            inventory.add(new Webcam(ref, name, brand, price, rs, st, location, Device.Type.Webcam, getId()));
            incrementStock();
        }
    }

    public void addTablet(String ref, String nom, String marque, double prix, Phone.SE se, double sz, Device.State st, String location, int nb){
		for(int i = 0 ; i < nb ; i++){
            inventory.add(new Tablet(ref, nom, marque, prix, se, sz, st, location, Device.Type.Tablet, getId()));
            incrementStock();
        }
    }
}
