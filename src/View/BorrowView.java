package src.View;

import src.Model.Borrow;
import src.Model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

import src.Controller.BorrowsController;
import src.Controller.DevicesController;
import src.Controller.UsersController;

public class BorrowView {

    private BorrowsController bc;
	
    public BorrowView(){
        this.bc = BorrowsController.getInstance();
    }
	
    public void printAllBorrows(){
        System.out.println(this.bc.toStringBorrows(this.bc.getBorrows()));
    }

    public int printBorrowsByUser(int  id){
        String str = this.bc.toStringBorrowsByUser(this.bc.getBorrows(), id);
        System.out.println(str);
        if(str == "")return 0;
        return 1;
    }

    public void printBorrowsInLate(){
        System.out.println(this.bc.toStringBorrowsInLate(this.bc.getBorrows()));
    }
    
    public int printBorrowsByJustification(String j){
        String str = this.bc.toStringBorrowsByJustification(this.bc.getBorrows(), j);
        System.out.println(str);
        if(str == "")return 0;
        return 1;
    }

    public void serialise(){
        try{
            File fichier =  new File("data/borrowsController.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
    
            // sérialization de l'objet
            oos.writeObject(bc);
            oos.close();
        }catch(IOException e){
            System.err.println("Errorrrr 1");
        }
    }

    public void deserialise(){
        try{
            File fichier =  new File("data/borrowsController.ser") ;

            // ouverture d'un flux sur un fichier
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
                    
            // désérialization de l'objet
            bc = (BorrowsController) ois.readObject();
            ois.close();
        }catch(IOException|ClassNotFoundException e){
            System.err.println("Errorrrr");
        }  
    }

    public void addBorrow(GregorianCalendar expiration, String justif, User u){
        Borrow b = new Borrow(new GregorianCalendar(), expiration, justif, u, bc.getId());
        DevicesController dc = DevicesController.getInstance(1, 1);
        System.out.println("Les produits disponible :");
        System.out.println(dc.toStringAvailableDevices(dc.getInventory()));
        Scanner in = new Scanner(System.in);
        int deviceId = Integer.parseInt(in.nextLine());
        b.addDevice(dc.getDeviceByID(deviceId));
        bc.addBorrow(b);
    }

    public void askCreateBorrow(Scanner input){
        String term_result;
        System.out.println("=== Ajout d'un emprunt ===");
        UsersController uc = UsersController.getInstance();
        System.out.print("Id de l'Utilisateur (-1 pour créer un nouvel utilisateur) :");
        term_result = input.nextLine();
        User u1 = uc.getUserByID(Integer.parseInt(term_result));
        if(u1 == null){
            System.out.println("=== Ajout d'un utilisateur ===");
            System.out.print("Prénom :");
            String firstname = input.nextLine();
            System.out.print("Nom :");
            String name = input.nextLine();
            System.out.print("Adresse :");
            String addr  = input.nextLine();
            System.out.print("Téléphone :");
            String phone = input.nextLine();
            System.out.print("Mail :");
            String mail = input.nextLine();
            u1 = uc.addUser(firstname, name, addr, phone, mail);
        }
        System.out.print("Année d'expiration :");
        String year = input.nextLine();
        System.out.print("Jour d'expiration :");
        String day = input.nextLine();
        System.out.print("Mois d'expiration :");
        String month = input.nextLine();
        GregorianCalendar c = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
        System.out.print("Raison de l'emprunt :");
        String justif = input.nextLine();
        this.addBorrow(c, justif ,u1);
    }

    public void askModifyBorrow(Scanner input){
        System.out.println("=== Modification d'un emprunt ===");
        System.out.print("ID de l'emprunt :");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("[0] Modifier la date d'expiration");
        System.out.println("[1] Modifier la raison de l'emprunt");
        System.out.println("[2] Ajouter un appareil");
        System.out.println("[3] Supprimer un appareil");
        System.out.println("[4] Rendre l'emprunt");
        System.out.println("[x] Revenir au menu");
        int attribute = Integer.parseInt(input.nextLine());
        switch(attribute){
            case 0:
                bc.modifyExpiration(id, input);
                break;
            case 1:
                bc.modifyJustification(id, input);
                break;
            case 2:
                System.out.println("Les produits disponible :");
                System.out.println(DevicesController.getInstance(1, 1).toStringAvailableDevices(DevicesController.getInstance(1, 1).getInventory()));
                Borrow b = bc.getBorrowByID(id);
                bc.addDevice( b, getDeviceByID(Integer.parseInt(input.nextLine())));
                break;
            case 3:
                b = bc.getBorrowByID(id);
                bc.deleteDevice(b, getDeviceByID(Integer.parseInt(input.nextLine())));
                break;
            case 4:
                b = bc.getBorrowByID(id);
                bc.removeBorrow(b);
                break;
            default:
                return;
        }
    }
}
