package src.Controller;

import src.Model.devices.*;

public class DevicesController {
	
    public DevicesController(){
    }

    public void addPhone(String ref, String name, String brand, double price, Phone.SE se, double sz, Device.State st, String location, int nb){
        for(int i = 0; i < nb; i++){
            new Phone(ref, name, brand, price, se, sz, st, location);
        }
    }

    public void addSensor(String ref, String name, String brand, double price, Device.State st, String location, int nb){
        for(int i = 0; i < nb; i++){
            new Sensor(ref, name, brand, price, st, location);
        }
    }

    public void addHeadset(String ref, String name, String brand, double price, Device.State st, String location, int vr, int nb){
        for(int i = 0; i < nb; i++){
            new Headset(ref, name, brand, price, vr, st, location);
        }
    }

    public void addPlayingRemote(String ref, String name, String brand, double price, Device.State st, String location, int nb){
        for(int i = 0 ; i < nb ; i++){
            new PlayingRemote(ref, name, brand, price, st, location);
        }
    }

    public void addWebcam(String ref, String name, String brand, double price, Webcam.Resolution rs, Device.State st, String location, int nb){
        for(int i = 0 ; i < nb ; i++){
            new Webcam(ref, name, brand, price, rs, st, location);
        }
    }

    public void addTablet(String ref, String nom, String marque, double prix, Phone.SE se, double sz, Device.State st, String location, int nb){
		for(int i = 0 ; i < nb ; i++){
            new Tablet(ref, nom, marque, prix, se, sz, st, location);
        }
    }
}
