package src.View;

import java.util.Scanner;

import src.Model.devices.Device;

public class MenuView {
    private BorrowView borrowView = new BorrowView();
    private DevicesView deviceView = new DevicesView();
    private String term_result = new String();
    
    public MenuView(){
    }

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
            try {
                Scanner input_scanner = new Scanner(System.in);
                this.term_result = (input_scanner.next());
                return this.term_result;
            } catch(NumberFormatException ne) {
                System.out.println("Veuillez suivre les instructions du menu : "+ne);
            }
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
                borrowView.printBorrowsByJusitification("Justification à passer");
                break;
            case "2.3" :
                borrowView.printBorrowsByUser(102);
                break;
            case "2.4" :
                borrowView.printBorrowsInLate();
                break;
            case "3.1" :
                System.out.println(action);
                break;
            case "4.1" :
                System.out.println(action);
                break;
            case "4.2" :
                System.out.println(action);
                break;
            case "4.3" :
                System.out.println(action);
                break;
            case "4.4" :
                System.out.println(action);
                break;
            case "5" :
                System.out.println("Quitter");
                break;
            default:
                return 1;
        }
        return 0;
    }

    public Device.Type getTypeInput(){
        System.out.println("Rentrez le type souhaité : Phone, Webcam, Headset, Sensor, PlayingRemote, Tablet, NA");
        while(true){
            try {
                Scanner input_scanner = new Scanner(System.in);
                String res = input_scanner.nextLine();
                switch( res ){
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
            } catch(NumberFormatException ne) {
                System.out.println("Veuillez suivre les instructions du menu : "+ne);
            }
        }
    }
	
}
