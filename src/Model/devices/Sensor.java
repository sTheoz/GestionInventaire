package src.Model.devices;

import src.Model.Storage;

public class Sensor extends Device{

	private static final long serialVersionUID = 414L;
	
	public Sensor (String ref, String name, String brand, double price, State st, Storage location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
	}
	
	public String toString(){
		return super.toString();
	}
}
