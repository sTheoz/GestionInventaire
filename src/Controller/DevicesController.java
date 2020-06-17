package src.Controller;

import src.Model.Storage;
import src.Model.devices.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Iterator;

public class DevicesController implements Serializable{

    //ID available for futur device
    private int id;
    private int numberElement;
    private ArrayList<Device> inventory;

    private static final long serialVersionUID = 41L;

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

    
    public ArrayList<Device> getDevices(){
        return this.inventory;
    }

    public Device getDeviceByID(int id){
        Device d = this.inventory.get(0);
        Iterator<Device> iter = this.inventory.iterator();
        while(iter.hasNext()){
            d = iter.next();
            if(d.getID() == id)
                return d;
        }
        return d;
    }

    private DevicesController(int id, int nbEle){
        this.id = id;
        this.numberElement = nbEle;
        this.inventory = new ArrayList<Device>();
    }

    public String toStringDevices(ArrayList<Device> list){
        String str = "";
        Iterator<Device> iter = list.iterator();
        while(iter.hasNext()){
            str += iter.next().toString()+"\n";
        }
        return str;
    }

    public String toStringDevicesByType(ArrayList<Device> list, Device.Type t){
        String str = "";
        Iterator<Device> iter = list.iterator();
        Device d;
        while(iter.hasNext()){
            d = iter.next();
            if(d.getType() == t) str += d.toString()+"\n";
        }
        return str;
    }

    public String toStringAvailableDevices(ArrayList<Device> list){
        String str = "";
        Device d;
        Iterator<Device> iter = list.iterator();
        while(iter.hasNext()){
            d = iter.next();
            if(d.isAvailable()) str += d.toString()+"\n";
        }
        return str;
    }

    public String toStringNotAvailableDevices(ArrayList<Device> list){
        String str = "";
        Device d;
        Iterator<Device> iter = list.iterator();
        while(iter.hasNext()){
            d = iter.next();
            if(!d.isAvailable()) str += d.toString()+"\n";
        }
        return str;
    }

    public String toStringLocation(ArrayList<Device> devices){
        String str = "";
        ArrayList<String> locations = new ArrayList<String>();
        Iterator<Device> iter = devices.iterator();
        Device b;
        while(iter.hasNext()){
            b = iter.next();
            locations.add(b.getLocation().getName());
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

    public void addPhone(String ref, String name, String brand, double price, Phone.SE se, double sz, Device.State st, Storage location, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Phone(ref, name, brand, price, se, sz, st, location, Device.Type.Phone, getId()));
            incrementStock();
        }
    }

    public void addSensor(String ref, String name, String brand, double price, Device.State st, Storage location, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Sensor(ref, name, brand, price, st, location, Device.Type.Sensor, getId()));
            incrementStock();
        }
    }

    public void addHeadset(String ref, String name, String brand, double price, Device.State st, Storage location, int vr, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Headset(ref, name, brand, price, vr, st, location, Device.Type.Headset, getId()));
            incrementStock();
        }
    }

    public void addPlayingRemote(String ref, String name, String brand, double price, Device.State st, Storage location, int nb){
        for(int i = 0 ; i < nb ; i++){
            inventory.add(new PlayingRemote(ref, name, brand, price, st, location, Device.Type.PlayingRemote, getId()));
            incrementStock();
        }
    }

    public void addWebcam(String ref, String name, String brand, double price, Webcam.Resolution rs, Device.State st, Storage location, int nb){
        for(int i = 0 ; i < nb ; i++){
            inventory.add(new Webcam(ref, name, brand, price, rs, st, location, Device.Type.Webcam, getId()));
            incrementStock();
        }
    }

    public void addTablet(String ref, String nom, String marque, double prix, Phone.SE se, double sz, Device.State st, Storage location, int nb){
		for(int i = 0 ; i < nb ; i++){
            inventory.add(new Tablet(ref, nom, marque, prix, se, sz, st, location, Device.Type.Tablet, getId()));
            incrementStock();
        }
    }
}
