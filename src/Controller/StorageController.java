package src.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import src.Model.Storage;
import java.util.Iterator;
import java.util.Scanner;

/**
 * StorageController est une classe représentant le point de contact pour toutes les actions que l'on a avec 
 * les lieux de stockage (@see Storage)
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class StorageController implements Serializable{
    
    private ArrayList<Storage> storages;
    private int id;

    private static final long serialVersionUID = 31L;

    /**
     * StorageController est un signeleton et ne peut pas être créé
     */
    private StorageController(){
        this.id = 0;
        storages = new ArrayList<Storage>();
    }

    /** Instance unique non préinitialisée */
    private static StorageController INSTANCE = null;
    
    /** 
     * Récupère ou crée l'instance de la classe
     * */
    public static StorageController getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new StorageController(); 
        }
        return INSTANCE;
    }

    /**
     * Récupère un lieu de stockage en fonction de son id ou null si non trouvé
     * @param id id d'un lieu de stockage
     * @return stockage trouvé ou null
     */
    public Storage getStorageByID(int id){
        Iterator<Storage> iter = (this.storages).iterator();
        Storage d;
        while(iter.hasNext()){
            d = iter.next();
            if(d.getID() == id)
                return d;
        }
        return null;
    }

    /**
     * Renvoie la desciption du lieu de stockage en fonction de son id
     * @param id id d'un lieu de stockage
     * @return la description d'un lieu de stockage ou une chaine vide
     */
    public String toStringStorageByID(int id){
        Iterator<Storage> iter = (this.storages).iterator();
        Storage d;
        while(iter.hasNext()){
            d = iter.next();
            if(d.getID() == id)
                return d.toString();
        }
        return "";
    }

    /**
     * Modifie le nom d'un lieu de stockage
     * @param id
     * @param input
     */
    public void modifyName(int id, Scanner input){
        Iterator<Storage> iter = storages.iterator();
        Storage s;
        while(iter.hasNext()){
            s = iter.next();
            if(s.getID() == id){
                System.out.print("Nouveau nom:");
                String name = input.nextLine();
                s.setName(name);
                return;
            }
        }
    }
    
    /**
     * Modifie la localisation d'un lieu de stockage
     * @param id
     * @param input
     */
    public void modifyLocalisation(int id, Scanner input){
        Iterator<Storage> iter = storages.iterator();
        Storage s;
        while(iter.hasNext()){
            s = iter.next();
            if(s.getID() == id){
                System.out.print("Nouvelle localisation:");
                String localisation = input.nextLine();
                s.setLocation(localisation);
                return;
            }
        }
    }

    /**
     * Ajoute un lieu de stockage
     * @param name
     * @param location
     * @param id
     * @return
     */
    public int addStorage(String name, String location, int id){
        storages.add(new Storage(name, location, id));
        return 1;
    }

    /**
     * Retire un lieu de stockage de la liste storages
     * @param s
     */
    public void removeStorage(Storage s){
        storages.remove(s);
    }

    /**
     * Recupère un id disponible
     * @return
     */
    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
    }

    /**
     * Récupère tous les lieux de stockage
     * @return
     */
    public ArrayList<Storage> getStorages(){
        return storages;
    }

    /**
     * Renvoie la description de tous les lieux de stockage présent dans list ou une chaine vide si aucun lieu dans list
     * @param list liste de lieux de stockage
     * @return descriptions des lieux de stockage
     */
    public String toStringStorages(ArrayList<Storage> list){
        String str = "";
        Iterator<Storage> iter = list.iterator();
        while(iter.hasNext()){
            str += iter.next().toString()+"\n";
        }
        return str;
    }

    /**
     * Renvoie la description de tous les lieux de stockage avec le nom name ou une chaine vide
     * @param list liste de lieux de stockage
     * @param name nom d'un lieu de stockage
     * @return descriptions des lieux de stockage
     */
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

    /**
     * Renvoie la description de tous les lieux de stockage avec la localisation location ou une chaine vide
     * @param list liste de lieux de stockage
     * @param location localisation d'un lieu de stockage
     * @return descriptions des lieux de stockage
     */
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

    /**
     * Permet d'initialiser le singleton lors de la désérialisation du fichier data/storageController.ser
     */
    public void deserialise(ArrayList<Storage> storages, int id){
        this.storages = storages;
        this.id = id;
    }
}