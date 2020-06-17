package src.Controller;

import java.util.ArrayList;
import src.Model.Storage;
import java.util.Iterator;

public class StorageController {
    
    private ArrayList<Storage> storages;
    private int id;

    private StorageController(){
        this.id = 0;
        storages = new ArrayList<Storage>();
    }

    /** Instance unique non préinitialisée */
    private static StorageController INSTANCE = null;
    
    /** Point d'accès pour l'instance unique du Stock */
    public static StorageController getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new StorageController(); 
        }
        return INSTANCE;
    }

    public int addStorage(String name, String location){
        storages.add(new Storage(name, location));
        return 1;
    }

    public void removeStorage(Storage s){
        storages.remove(s);
    }

    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    public ArrayList<Storage> getStorages(){
        return storages;
    }

    public String toStringStorages(ArrayList<Storage> list){
        String str = "";
        Iterator<Storage> iter = list.iterator();
        while(iter.hasNext()){
            str += iter.next().toString()+"\n";
        }
        return str;
    }

    public String toStringStoragesByName(ArrayList<Storage> list, String name){
        String str = "";
        Iterator<Storage> iter = list.iterator();
        Storage d;
        while(iter.hasNext()){
            d = iter.next();
            if(d.getName() == name) str += d.toString()+"\n";
        }
        return str;
    }

    public String toStringStoragesByLocation(ArrayList<Storage> list, String location){
        String str = "";
        Iterator<Storage> iter = list.iterator();
        Storage d;
        while(iter.hasNext()){
            d = iter.next();
            if(d.getLocation() == location) str += d.toString()+"\n";
        }
        return str;
    }
}