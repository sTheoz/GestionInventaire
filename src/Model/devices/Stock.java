package src.Model.devices;

import java.util.ArrayList;

public class Stock {

    private int id;
    private int numberElement;
    private ArrayList<Device> inventory;

    private Stock(){
        super();
        id = 0;
        this.numberElement = 0;
        this.inventory = new ArrayList<Device>();
    }

    private Stock(int id, int nbEle){
        super();
        this.id = id;
        this.numberElement = nbEle;
        this.inventory = new ArrayList<Device>();
        //Il faut initialiser l'inventaire avec les elements déjà existant
    }
     
    /** Instance unique non préinitialisée */
    private static Stock INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du Stock */
    public static Stock getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new Stock(); 
        }
        return INSTANCE;
    }

    public static Stock getInstance(int id, int nbEle)
    {           
        if (INSTANCE == null)
        {   INSTANCE = new Stock(id, nbEle); 
        }
        return INSTANCE;
    }

    public int getId(){
        int idR = this.id;
        this.id++;
        return idR;
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

    public void addDevice(Device d){
        inventory.add(d);
        incrementStock();
    }

    public void removeDevice(Device d){
        inventory.remove(d);
        decrementStock();
    }
}