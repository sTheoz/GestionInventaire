package src.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import src.Controller.StorageController;

/**
 * StorageView est une classe représentant l'échange homme-machine concernant les lieux de stockage
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class StorageView {
    
    private StorageController sc;

    /**
     * Echange avec l'utilisateur sur les lieux de stockage
     */
    public StorageView(){
        this.sc = StorageController.getInstance();
    }

    /**
     * Affiche tous les lieux de stockage
     */
    public void printAllStorage(){
        System.out.println("All Storage :");
        System.out.println(sc.toStringStorages(sc.getStorages()));
        sleep();
    }

    /**
     * Affiche un lieu de stockage en fonction de son nom
     * @param name nom des lieux de stockage
     */
    public void printStorageByName(String name){
        System.out.println("All " + name + " :");
        System.out.println(sc.toStringStoragesByName(sc.getStorages(), name));
        sleep();
    }

    /**
     * Affiche un lieu de stockage par localisation
     * @param location localisation du lieu
     */
    public void printStorageByLocation(String location){
        System.out.println("All storages :");
        System.out.println(sc.toStringStoragesByLocation(sc.getStorages(), location));
        sleep();
    }

    /**
     * affiche un lieu de stockage par id
     * @param id id d'un lieu de stockage
     */
    public void printStorageByID(int id){
        System.out.println(sc.toStringStorageByID(id));
    }

    /**
     * Ajoute un lieu de stockage
     * @param input_scanner entrée standard
     */
    public void addStorage(Scanner input_scanner){
        System.out.println("=== Ajout d'un lieu de stockage ===");
        System.out.print("Localisation :");
        String location = input_scanner.nextLine();
        System.out.print("Nom du lieu de stockage:");
        String name = input_scanner.nextLine();
        sc.addStorage(name, location, sc.getId());
    }

    /**
     * Vide le terminal
     */
    public void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    /**
     * Modifie un lieu de stockage
     * @param input entrée standard
     */
    public void modifyStorage(Scanner input){
        clear();
        System.out.println("=== Modifier un lieu de stockage ===");
        printAllStorage();
        System.out.print("ID de l'emprunt :");
        int id = Integer.parseInt(input.nextLine());
        clear();
        printStorageByID(id);
        System.out.println("[0] Modifier le nom");
        System.out.println("[1] Modifier la localisation");
        System.out.println("[x] Revenir au menu");
        String attribute = input.nextLine();
        switch(attribute){
            case "0":
                sc.modifyName(id, input);
                break;
            case "1":
                sc.modifyLocalisation(id, input);
                break;
            default:
                return;
        }
    }
    public void sleep(){
        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            System.err.print("Sleep error");
        }
    }
    
    /**
     * Sauvegarde les données
     */
    public void serialise(){
        try{
            File fichier =  new File("data/storageController.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
    
            // sérialization de l'objet
            oos.writeObject(sc);
            oos.close();
        }catch(IOException e){
            System.err.println("Errorrrr 1");
        }
    }

    /**
     * Récupère les données de sauvegarde
     */
    public void deserialise(){
        try{
            File fichier =  new File("data/storageController.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
                    
            // désérialization de l'objet
            sc = ((StorageController) ois.readObject());
            ois.close();
        }catch(IOException|ClassNotFoundException e){
            System.err.println("Error");
        } 
    }
}
