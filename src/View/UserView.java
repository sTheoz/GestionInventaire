package src.View;

import java.util.Scanner;

import src.Controller.UsersController;
import src.Model.User;

/**
 * BorrowView est une classe représentant l'échange homme-machine concernant les emprunts
 * 
 * @author Lucas NAVETEUR et Théo SZATKOWSKI
 * @version 1.0
 */
public class UserView {
    
    UsersController uc;

    /**
     * Echange avec l'utilisateur par rapport aux utilisateurs dans le programme
     */
    public UserView(){
        uc = UsersController.getInstance();
    }

    /**
     * Demande les informations pour créer un utilisateur
     * @param input entrée standard
     * @return utilisateur créé
     */
    public User askCreateUser(Scanner input){
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
        return uc.addUser(firstname, name, addr, phone, mail);
    }
}