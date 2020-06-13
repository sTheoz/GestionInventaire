package src.Controller;

import java.util.ArrayList;
import src.Model.Storage;

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

    public void addStorage(String name, String location){
        storages.add(new Storage(name, location));
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
}