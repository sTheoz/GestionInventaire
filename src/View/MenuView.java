package src.View;

import java.io.File;
import java.util.Scanner;

import src.Controller.StorageController;
import src.Model.devices.Device;

/**
 * MenuView est une classe représentant l'échange homme-machine avec le Menu principal
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class MenuView {
    private StorageView  storageView = new StorageView();
    private BorrowView borrowView = new BorrowView();
    private DevicesView deviceView = new DevicesView();
    private String term_result;
    private Scanner input_scanner = new Scanner(System.in);
    
    /**
     * Echange entre le programme et l'utilisateur avec le menu principal
     */
    public MenuView(){
        File bcf = new File("data/borrowsController.ser");
        File dcf = new File("data/devicesController.ser");
        File scf = new File("data/storageController.ser");
        if(scf.exists())storageView.deserialise();
        if(dcf.exists())deviceView.deserialise();
        if(bcf.exists())borrowView.deserialise();
    }

    /**
     * Vide le terminal
     */
    public void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    /**
     * Affiche le menu principal
     * @return Renvoie le choix de l'utilisateur
     */
    public String printMenu(){
        this.clearScreen();
        System.out.println("=============== MENU ===============");
        System.out.println("Afficher le matériel");
        System.out.println("\t1.1 : Total");
        System.out.println("\t1.2 : Disponible");
        System.out.println("\t1.3 : Emprunté");
        System.out.println("\t1.4 : Selon leur type");
        System.out.println("\t1.5 : Par lieu stockage");
        System.out.println("Afficher les emprunts");
        System.out.println("\t2.1 : Totaux");
        System.out.println("\t2.2 : Selon la raison d'emprunt");
        System.out.println("\t2.3 : Par emprunteur");
        System.out.println("\t2.4 : En retard");
        System.out.println("Lieux de stockage");
        System.out.println("\t3.1 : Afficher");
        System.out.println("Ajout ou modifier des choses");
        System.out.println("\t4.1 : Matériel(s)");
        System.out.println("\t4.2 : Lieu de stockage");
        System.out.println("\t4.3 : Emprunt");
        System.out.println("\t4.4 : Utilisateur");
        System.out.println("\t5 : Quitter");
        while(true){
            System.out.print("Où allons-nous ?(numéro du choix) ");
            this.term_result = ((this.input_scanner).nextLine());
            //Pas d'inquiétude, le scanner est clos en fin de programme
            return this.term_result;
        }
    }

    /**
     * Execute les fonctions en fonction du menu choisi
     * @param action menu choisi
     * @return -1 pour quitter, 1 pour une mauvaise entrée
     */
    public int executeMenu(String action){
        switch(action) {
            case "1.1" :
                deviceView.printAllDevices();
                break;
            case "1.2" :
                deviceView.printAllAvailableDevices();
                break;
            case "1.3" :
                deviceView.printAllNotAvailableDevices();
                break;
            case "1.4" :
                deviceView.printDevicesByType( getTypeInput() );
                break;
            case "1.5" :
                storageView.printAllStorage();
                deviceView.printDevicesByStockage( input_scanner );
                break;
            case "2.1" :
                borrowView.printAllBorrows();
                break;
            case "2.2" :
                do{
                    System.out.println("Rentrez la justification souhaitée : ");
                    this.term_result = ((this.input_scanner).nextLine());
                }while(borrowView.printBorrowsByJustification(this.term_result) == 0);
                break;
            case "2.3" :
                String user_id;
                do{
                    System.out.println("Rentrez l'id de l'utilisateur souhaité (-1 for exit): ");
                    user_id = (this.input_scanner).nextLine();
                    clearScreen();
                }while(user_id.compareTo("-1") != 0 && borrowView.printBorrowsByUser(Integer.parseInt(user_id)) == 0);
                break;
            case "2.4" :
                borrowView.printBorrowsInLate();
                break;
            case "3.1" :
                storageView.printAllStorage();
                break;
            case "4.1" :
                deviceView.addDevice( getTypeInput(), this.input_scanner );
                break;
            case "4.2" :
                System.out.println("[0] Ajouter un lieu de stockage");
                System.out.println("[1] Modifier un lieu de stockage");
                System.out.println("[x] Revenir au menu");
                term_result = input_scanner.nextLine();
                if(term_result.compareTo("0") == 0){
                    storageView.addStorage(input_scanner);
                }else if(term_result.compareTo("1") == 0){
                    storageView.modifyStorage(input_scanner);
                }
                break;
            case "4.3" :
                System.out.println("[0] Créer un emprunt");
                System.out.println("[1] Modifier un emprunt");
                System.out.println("[x] Revenir au menu");
                term_result = input_scanner.nextLine();
                if(term_result.compareTo("0") == 0){
                    borrowView.askCreateBorrow(input_scanner);
                }else if(term_result.compareTo("1") == 0){
                    borrowView.askModifyBorrow(input_scanner);
                }
                break;
            case "4.4" :
            String name,location;
                StorageController storage = StorageController.getInstance();
                do{
                    System.out.println("Rentrez le nom du stockage souhaité : ");
                    name = ((this.input_scanner).nextLine());
                    System.out.println("Rentrez le nom de la localisation : ");
                    location = ((this.input_scanner).nextLine());
                }while(storage.addStorage(name, location, StorageController.getInstance().getId()) == 0);
                break;
            case "5" :
                (this.input_scanner).close();
                borrowView.serialise();
                storageView.serialise();
                deviceView.serialise();
                System.out.print("Sauvegarde des données...");
                System.out.println("\rAu revoir !              ");
                borrowView.clear();
                return -1;
            default:
                return 1;
        }
        return 0;
    }

    /**
     * Récupère un id
     * @return id
     */
    public int getIDInput(){
        System.out.println("Rentrez un ID :");
        return Integer.parseInt((this.input_scanner).nextLine());
    }

    /**
     * Récupère le Type d'un appareil en fonction de l'entrée de l'utilisateur
     * @return Type de l'appareil
     */
    public Device.Type getTypeInput(){
        System.out.println("Rentrez le type souhaité : Phone, Webcam, Headset, Sensor, PlayingRemote, Tablet, NA");
        while(true){
            switch((this.input_scanner).nextLine()){
                case "Phone":
                    return Device.Type.Phone;
                case "Webcam":
                    return Device.Type.Webcam;
                case "Headset":
                    return Device.Type.Headset;
                case "Sensor":
                    return Device.Type.Sensor;
                case "PlayingRemote":
                    return Device.Type.PlayingRemote;
                case "Tablet":
                    return Device.Type.Tablet;
                default:
                    return Device.Type.NA;
            }
        }
    }
}
