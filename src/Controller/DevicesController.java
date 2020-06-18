package src.Controller;

import src.Model.Storage;
import src.Model.devices.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Iterator;

/**
 * DevicesController est une classe représentant le point de contact pour toutes les actions que l'on a avec 
 * les appareils (@see Device)
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class DevicesController implements Serializable{

    //ID available for futur device
    private int id;
    private int numberElement;
    private ArrayList<Device> inventory;

    private static final long serialVersionUID = 41L;

    /** Instance unique non préinitialisée */
    private static DevicesController INSTANCE = null;
    
    /** 
     * Récupère ou crée l'instance de la classe
     * @return Singleton de DevicesController
     * */
    public static DevicesController getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new DevicesController(); 
        }
        return INSTANCE;
    }

    /**
     * Récupère une liste de tous les appareils
     * @return liste des appareils
     */
    public ArrayList<Device> getDevices(){
        return this.inventory;
    }

    /**
     * Récupère un appareil en fonction de son id
     * @param id id d'un appareil
     * @return appareil trouvé ou null
     */
    public Device getDeviceByID(int id){
        Device d = this.inventory.get(0);
        Iterator<Device> iter = this.inventory.iterator();
        while(iter.hasNext()){
            d = iter.next();
            if(d.getID() == id)
                return d;
        }
        return null;
    }

    /**
     * DevicesController est un signeleton et ne peut pas être créé
     */
    private DevicesController(){
        this.id = 0;
        this.numberElement = 0;
        this.inventory = new ArrayList<Device>();
    }

    /**
     * Renvoie la description des appareils d'un lieu de stockage
     * @param id id du lieu de stockage
     * @return la description des appareils dans le lieu de stockage
     */
    public String toStringDevicesByStorage(int id){
        String str = "";
        Iterator<Device> iter = inventory.iterator();
        while(iter.hasNext()){
            Device d = iter.next();
            if(d.getLocation().getID() == id){
                str += d.toString()+"\n";
            }
        }
        return str;
    }

    /**
     * Renvoie la description de toutes les appareils de la liste list
     * @param list liste d'appareils
     * @return la description de toutes les appareils de la liste list
     */
    public String toStringDevices(ArrayList<Device> list){
        String str = "";
        Iterator<Device> iter = list.iterator();
        while(iter.hasNext()){
            str += iter.next().toString()+"\n";
        }
        return str;
    }

    /**
     * Renvoie la description des appareils en fonction de son Type t
     * @param list liste d'appareils
     * @param t Type d'un appareil
     * @return la description des appareils
     */
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

    /**
     * Renvoie la description des appareils qui sont disponibles
     * @param list liste d'appareils
     * @return la description des appareils qui sont disponibles
     */
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

    /**
     * Renvoie la description des appareils qui sont indisponibles
     * @param list liste d'appareils
     * @return la description des appareils qui sont indisponibles
     */
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

    /**
     * Renvoie la liste des localisations utilisés par la liste des appareils devices
     * @param devices liste d'appareils
     * @return la description des lieux de stockage
     */
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

    /**
     * Renvoie un id disponible
     * @return id
     */
    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    /**
     * Renvoie la liste de tous les appareils
     * @return liste de tous les appareils
     */
    public ArrayList<Device> getInventory(){
        return inventory;
    }

    /**
     * Augmente le nombre d'élément du stock
     */
    private void incrementStock(){
        this.numberElement++;
    }

    /**
     * Diminue le nombre d'élément du stock
     */
    private void decrementStock(){
        this.numberElement--;
    }

    /**
     * Renvoie le nombre d'éléments du stock
     * @return nombre d'éléments du stock
     */
    public int getNbElement(){
        return numberElement;
    }

    /**
     * Enlève un appareil d du Stock
     * @param d appareil à enlever
     */
    public void removeDevice(Device d){
        inventory.remove(d);
        decrementStock();
    }

    /**
     * Ajoute un téléphone
     * @param ref Référence
     * @param name nom
     * @param brand marque
     * @param price prix
     * @param se système d'exploitatio
     * @param sz taille en pouce
     * @param st status
     * @param location localisation
     * @param nb nombre d'appareil
     */
    public void addPhone(String ref, String name, String brand, double price, Phone.SE se, double sz, Device.State st, Storage location, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Phone(ref, name, brand, price, se, sz, st, location, Device.Type.Phone, getId()));
            incrementStock();
        }
    }

    /**
     * Ajoute un détecteur de profondeur
     * @param ref Référence
     * @param name nom
     * @param brand marque
     * @param price prix
     * @param st status
     * @param location localisation
     * @param nb nombre d'appareil
     */
    public void addSensor(String ref, String name, String brand, double price, Device.State st, Storage location, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Sensor(ref, name, brand, price, st, location, Device.Type.Sensor, getId()));
            incrementStock();
        }
    }

    /**
     * Ajoute un casque
     * @param ref Référence
     * @param name nom
     * @param brand marque
     * @param price prix
     * @param st status
     * @param location localisation
     * @param nb nombre d'appareil
     * @param vr casque vr ou non
     */
    public void addHeadset(String ref, String name, String brand, double price, Device.State st, Storage location, int vr, int nb){
        for(int i = 0; i < nb; i++){
            inventory.add(new Headset(ref, name, brand, price, vr, st, location, Device.Type.Headset, getId()));
            incrementStock();
        }
    }

    /**
     * Ajoute une manette de jeu
     * @param ref Référence
     * @param name nom
     * @param brand marque
     * @param price prix
     * @param st status
     * @param location localisation
     * @param nb nombre d'appareil
     */
    public void addPlayingRemote(String ref, String name, String brand, double price, Device.State st, Storage location, int nb){
        for(int i = 0 ; i < nb ; i++){
            inventory.add(new PlayingRemote(ref, name, brand, price, st, location, Device.Type.PlayingRemote, getId()));
            incrementStock();
        }
    }

    /**
     * Ajoute une webcam
     * @param ref Référence
     * @param name nom
     * @param brand marque
     * @param price prix
     * @param st status
     * @param location localisation
     * @param nb nombre d'appareil
     * @param rs resolution de la webcam
     */
    public void addWebcam(String ref, String name, String brand, double price, Webcam.Resolution rs, Device.State st, Storage location, int nb){
        for(int i = 0 ; i < nb ; i++){
            inventory.add(new Webcam(ref, name, brand, price, rs, st, location, Device.Type.Webcam, getId()));
            incrementStock();
        }
    }

    /**
     * Ajoute une tablette
     * @param ref Référence
     * @param name nom
     * @param brand marque
     * @param price prix
     * @param se système d'exploitatio
     * @param sz taille en pouce
     * @param st status
     * @param location localisation
     * @param nb nombre d'appareil
     */
    public void addTablet(String ref, String name, String brand, double price, Phone.SE se, double sz, Device.State st, Storage location, int nb){
		for(int i = 0 ; i < nb ; i++){
            inventory.add(new Tablet(ref, name, brand, price, se, sz, st, location, Device.Type.Tablet, getId()));
            incrementStock();
        }
    }

    /**
     * Permet d'initialiser le singleton lors de la désérialisation du fichier data/devicesController.ser
     * @param inventory liste des appareils
     * @param id id pour les appareils
     * @param nbElem nombre d'éléments dans le stock
     */
    public void deserialise(ArrayList<Device> inventory, int id, int nbElem){
        this.inventory = inventory;
        this.id = id;
        this.numberElement = nbElem;
    }
}
