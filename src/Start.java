package src;

import src.Controller.*;
import src.Model.*;
import src.View.*;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;  
import java.util.Date; 
import java.lang.Integer;

public class Start {

    public static void injectData(){
        System.out.println("================= DATA INJECTION =================");
    }

    public static void main(String[] args){
        DevicesView devicesView = new DevicesView();
        BorrowView borrowView = new BorrowView();
        MenuView menuView = new MenuView();
        injectData();
        (menuView).executeMenu( (menuView).printMenu() );
    }
	
}
