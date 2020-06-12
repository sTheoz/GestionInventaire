package src.Model.devices;

public class Sensor extends Device{
	
	public Sensor (String ref, String name, String brand, double price, State st, String location, Device.Type type, int id){
		super(ref, name, brand, price, st, location, type, id);
	}
	
	public String toString(){
		return super.toString();
	}
}
