package src.View;

import java.util.Scanner;

import src.Controller.StorageController;
import src.Controller.UsersController;
import src.Model.User;
import src.Model.devices.Device;

public class MenuView {
    private BorrowView borrowView = new BorrowView();
    private DevicesView deviceView = new DevicesView();
    private String term_result;
    private Scanner input_scanner = new Scanner(System.in);
    
    public MenuView(){}

    public String printMenu(){
        System.out.println("=== MENU ===");
        System.out.println("Afficher le matériel");
        System.out.println("\t1.1 : Total");
        System.out.println("\t1.2 : Disponible");
        System.out.println("\t1.3 : Emprunté");
        System.out.println("\t1.4 : Selon leur type");
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
            this.term_result = ((this.input_scanner).nextLine());
            //Pas d'inquiétude, le scanner est clos en fin de programme
            return this.term_result;
        }
    }

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
                int user_id;
                do{
                    System.out.println("Rentrez l'id de l'utilisateur souhaité : ");
                    user_id = ((this.input_scanner).nextInt());
                }while(borrowView.printBorrowsByUser(user_id) == 0);
                break;
            case "2.4" :
                borrowView.printBorrowsInLate();
                break;
            case "3.1" :
                deviceView.printStorageLocation();
                break;
            case "4.1" :
                deviceView.addDevice( getTypeInput(), this.input_scanner );
                break;
            case "4.2" :
                System.out.println(action);
                break;
            case "4.3" :
                UsersController uc = UsersController.getInstance();
                this.term_result = input_scanner.nextLine();
                User u1 = uc.getUserByID(Integer.parseInt(this.term_result));
                if(u1 == null){
                    String firstname = input_scanner.nextLine();
                    String name = input_scanner.nextLine();
                    String addr  = input_scanner.nextLine();
                    String phone = input_scanner.nextLine();
                    String mail = input_scanner.nextLine();
                    u1 = uc.addUser(firstname, name, addr, phone, mail);
                }
                borrowView.addBorrow();
                break;
            case "4.4" :
                String name, location;
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
                System.out.println("Quitter");
                return -1;
            case "6" :
                System.out.println("Serialise");
                borrowView.serialise();
                break;
            case "7" :
            System.out.println("Deserialise");
                borrowView.deserialise();
                break;
            default:
                return 1;
        }
        return 0;
    }

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
