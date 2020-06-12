package src.View;

import java.util.Scanner;

public class MenuView {
    String term_result = new String();
    
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
        while(true){
            try {
                Scanner input_scanner = new Scanner(System.in);
                this.term_result = (input_scanner.nextLine());
                input_scanner.close();
                return this.term_result;
            } catch(NumberFormatException ne) {
                System.out.println("Veuillez suivre les instructions du menu : "+ne);
            }
        }
    }

    public void executeMenu(String action){
        switch(action) {
            case "1.1" :
                System.out.println(action);
                break;
            case "1.2" :
                System.out.println(action);
                break;
            case "1.3" :
                System.out.println(action);
                break;
            case "1.4" :
                System.out.println(action);
                break;
            case "2.1" :
                System.out.println(action);
                break;
            case "2.2" :
                System.out.println(action);
                break;
            case "2.3" :
                System.out.println(action);
                break;
            case "2.4" :
                System.out.println(action);
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
        }
        return;
    }
	
}
