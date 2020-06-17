package src.View;

import src.Controller.DevicesController;
import src.Controller.StorageController;
import src.Model.devices.*;
import src.Model.devices.Webcam.Resolution;
import src.Model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DevicesView {
    
    private DevicesController dc;
    private StorageController sc;

    public DevicesView(){
        this.dc = DevicesController.getInstance();
        this.sc = StorageController.getInstance();
    }

    public void addDevice(Device.Type type, Scanner input_scanner){
        String ref, name, brand, temp;
        int price, nb, vr;
        double sz;
        Phone.SE se;
        Device.State st;
        Storage location;
        Webcam.Resolution rs;
        System.out.println("Rentrez la référence : ");
        ref = (input_scanner.nextLine());
        System.out.println("Rentrez le nom : ");
        name = (input_scanner.nextLine());
        System.out.println("Rentrez la marque : ");
        brand = (input_scanner.nextLine());
        System.out.println("Rentrez l'état (OK, KO, NEW, NA): ");
        temp = (input_scanner.nextLine());
        System.out.println("Rentrez le prix : ");
        price = Integer.parseInt((input_scanner.nextLine()));
        switch(temp){
            case "OK":
                st = Device.State.OK;
                break;
            case "KO":
                st = Device.State.KO;
                break;
            case "NEW":
                st = Device.State.NEW;
                break;
            case "NA":
                st = Device.State.NA;
                break;
            default:
                System.out.println("Rentrez un état valide");
                return;
        }
        System.out.println("Rentrez l'endroit de stockage : ");
        location = this.sc.getStorageByID(Integer.parseInt(input_scanner.nextLine()));
        System.out.println("Rentrez la quantité : ");
        nb = Integer.parseInt((input_scanner.nextLine()));
        switch(type){
            case Phone:
                System.out.println("Rentrez le Système d'exploitation (Android, iOs, Windows, NA) : ");
                temp = input_scanner.nextLine();
                switch(temp){
                    case "Android":
                        se = Phone.SE.Android;
                        break;
                    case "iOs":
                        se = Phone.SE.iOs;
                        break;
                    case "Windows":
                        se = Phone.SE.Windows;
                        break;
                    case "NA":
                        se = Phone.SE.NA;
                        break;
                    default:
                        System.out.println("Rentrez un SE valide");
                        return;
                }
                System.out.println("Rentrez la taille en pouce sans le \" : ");
                sz = Double.parseDouble(input_scanner.nextLine());
                this.dc.addPhone(ref, name, brand, price, se, sz, st, location, nb);
                break;
            case Webcam:
                System.out.println("Rentrez la résolution (LOW, MEDIUM, HIGH, NA)");
                temp = input_scanner.nextLine();
                switch(temp){
                    case "LOW":
                        rs = Resolution.LOW;
                        break;
                    case "MEDIUM":
                        rs = Resolution.MEDIUM;
                        break;
                    case "HIGH":
                        rs = Resolution.HIGH;
                        break;
                    case "NA":
                        rs = Resolution.NA;
                        break;
                    default:
                        System.out.println("Rentrez une résolution valide");
                        return;
                }
                this.dc.addWebcam(ref, name, brand, price, rs, st, location, nb);
                break;
            case Headset:
                System.out.println("Rentrez si le casque fait de la VR (0/1) : ");
                vr = Integer.parseInt((input_scanner.nextLine()));
                this.dc.addHeadset(ref, name, brand, price, st, location, vr, nb);
                break;
            case Sensor:
                this.dc.addSensor(ref, name, brand, price, st, location, nb);
                break;
            case PlayingRemote:
                this.dc.addPlayingRemote(ref, name, brand, price, st, location, nb);
                break;
            case Tablet:
                System.out.println("Rentrez le Système d'exploitation (Android, iOs, Windows, NA) : ");
                temp = input_scanner.nextLine();
                switch(temp){
                    case "Android":
                        se = Phone.SE.Android;
                        break;
                    case "iOs":
                        se = Phone.SE.iOs;
                        break;
                    case "Windows":
                        se = Phone.SE.Windows;
                        break;
                    case "NA":
                        se = Phone.SE.NA;
                        break;
                    default:
                        System.out.println("Rentrez un SE valide");
                        return;
                }
                System.out.println("Rentrez la taille en pouce sans le \" : ");
                sz = Double.parseDouble(input_scanner.nextLine());
                this.dc.addTablet(ref, name, brand, price, se, sz, st, location, nb);
                break;
            case NA:
                System.out.println("Le type est NA");
                break;
            default:
                System.out.println("Rentrez un type valide");
                return;
        }
    }

    /*
    public void updateDevice(Device.Type inputType, int device_id){
        DevicesController.getInstance(0, 0).getDevices();
        String champ = input_scanner.nextLine();
        switch(champ){
            case "Type" :
                String type = input_scanner.nextLine();
                device.setType();
                break;
            case "Reference" :
                break;
            case "Nom" :
                break;
            case "Marque" :
                break;
            case "Prix" :
                break;
            case "Etat" :
                break;
            case "Local de stockage" :
                break;
            case "Responsable" :
                break;
            case "Disponible" :
                break;
            case "State" :
                break;
        }
    }*/

    public void sleep(){
        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            System.err.print("Sleep error");
        }
    }

    public void printAllDevices(){
        System.out.println("All devices :");
        System.out.println(dc.toStringDevices(dc.getInventory()));
        sleep();
        
    }

    public void printDevicesByType(Device.Type t){
        System.out.println("All " + t + " :");
        System.out.println(dc.toStringDevicesByType(dc.getInventory(), t));
        sleep();
    }

    public void printAllAvailableDevices(){
        System.out.println("All available devices :");
        System.out.println(dc.toStringAvailableDevices(dc.getInventory()));
        sleep();
    }

    public void printAllNotAvailableDevices(){
        System.out.println("All unavailable devices :");
        System.out.println(dc.toStringNotAvailableDevices(dc.getInventory()));
        sleep();
    }

    public void printStorageLocation(){
        System.out.println("All storages :");
        System.out.println(dc.toStringLocation(dc.getInventory()));
        sleep();
    }

    public void serialise(){
        try{
            File fichier =  new File("data/devicesController.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
    
            // sérialization de l'objet
            oos.writeObject(dc);
            oos.close();
        }catch(IOException e){
            System.err.println("Errorrrr 1");
        }
    }
    public void deserialise(){
        try{
            File fichier =  new File("data/devicesController.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
                    
            // désérialization de l'objet
            DevicesController dcTmp = ((DevicesController) ois.readObject());
            ois.close();
            dc = DevicesController.getInstance();
            dc.deserialise(dcTmp.getInventory(), dcTmp.getId(), dcTmp.getNbElement()-1);

            sc = StorageController.getInstance();
            fichier = new  File("data/storageController.ser") ;
            ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
                    
            // désérialization de l'objet
            StorageController scTmp = ((StorageController) ois.readObject());
            ois.close();
            sc.deserialise(scTmp.getStorages(), scTmp.getId());
        }catch(IOException|ClassNotFoundException e){
            System.err.println("Errorrrr");
        } 
    }
	
}
