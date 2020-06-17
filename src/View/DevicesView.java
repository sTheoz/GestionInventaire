package src.View;

import src.Controller.DevicesController;
import src.Controller.StorageController;
import src.Model.devices.*;
import src.Model.devices.Webcam.Resolution;
import src.Model.*;
import java.util.Scanner;

public class DevicesView {
    
    private DevicesController dc;
    private StorageController sc;

    public DevicesView(){
        this.dc = DevicesController.getInstance(0, 0);
        this.sc = StorageController.getInstance();
    }

    public DevicesView(int id, int nbElem){
        this.dc = DevicesController.getInstance(id, nbElem);
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
        price = (input_scanner.nextInt());
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
        location = this.sc.getStorageByID(input_scanner.nextInt());
        System.out.println("Rentrez la quantité : ");
        nb = (input_scanner.nextInt());
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
                sz = (input_scanner.nextDouble());
                this.dc.addPhone(ref, name, brand, price, se, sz, st, location, nb);
                break;
            case Webcam:
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
                vr = (input_scanner.nextInt());
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
                sz = (input_scanner.nextDouble());
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

    public void printAllDevices(){
        System.out.println("All devices :");
        System.out.println(dc.toStringDevices(dc.getInventory()));
    }

    public void printDevicesByType(Device.Type t){
        System.out.println("All " + t + " :");
        System.out.println(dc.toStringDevicesByType(dc.getInventory(), t));
    }

    public void printAllAvailableDevices(){
        System.out.println("All available devices :");
        System.out.println(dc.toStringAvailableDevices(dc.getInventory()));
    }

    public void printAllNotAvailableDevices(){
        System.out.println("All unavailable devices :");
        System.out.println(dc.toStringNotAvailableDevices(dc.getInventory()));
    }

    public void printStorageLocation(){
        System.out.println("All storages :");
        System.out.println(dc.toStringLocation(dc.getInventory()));
    }
	
}
